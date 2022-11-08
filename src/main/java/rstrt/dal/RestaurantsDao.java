package rstrt.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rstrt.model.Companies;
import rstrt.model.Restaurants;

public class RestaurantsDao {
  protected ConnectionManager connectionManager;
  private static RestaurantsDao instance=null;
  protected RestaurantsDao(){
    connectionManager=new ConnectionManager();
  }
  public static RestaurantsDao getInstance(){
    if(instance==null){
      instance=new RestaurantsDao();
    }
    return instance;
  }
  public Restaurants create(Restaurants restaurant)throws SQLException{
    String insertOne="INSERT INTO Restaurants(Name,Description,Menu,"
        + "Hours,Active,CuisineType,Street1,Street2,City,State,Zip,CompanyName) "
        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    if(restaurant.getCompany()==null){
      insertOne="INSERT INTO Restaurants(Name,Description,Menu,"
          + "Hours,Active,CuisineType,Street1,Street2,City,State,Zip) "
          + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    }
    Connection connection=null;
    PreparedStatement insertStmt=null;
    ResultSet resultKey = null;
    try{
      connection=connectionManager.getConnection();
      insertStmt=connection.prepareStatement(insertOne, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1,restaurant.getName());
      insertStmt.setString(2,restaurant.getDescription());
      insertStmt.setString(3,restaurant.getMenu());
      insertStmt.setString(4,restaurant.getHours());
      insertStmt.setBoolean(5,restaurant.getActive());
      insertStmt.setString(6,restaurant.getCuisineType().name());
      insertStmt.setString(7,restaurant.getStreet1());
      insertStmt.setString(8,restaurant.getStreet1());
      insertStmt.setString(9,restaurant.getCity());
      insertStmt.setString(10,restaurant.getState());
      insertStmt.setInt(11,restaurant.getZip());
      if(restaurant.getCompany()!=null){
        insertStmt.setString(12,restaurant.getCompany().getCompanyName());
      }
      insertStmt.executeUpdate();
      int restaurantId=-1;
      resultKey=insertStmt.getGeneratedKeys();
      if(resultKey.next()){
        restaurantId=resultKey.getInt(1);
      }
      restaurant.setRestaurantId(restaurantId);
      return restaurant;
    }catch (SQLException e){
      e.printStackTrace();
      throw e;
    }finally {
      if(connection!=null){
        connection.close();
      }
      if(insertStmt!=null){
        insertStmt.close();
      }
    }
  }
  public Restaurants getRestaurantFromResult(ResultSet results) throws SQLException {
    try {
      int RestaurantId = results.getInt("RestaurantId");
      String Name = results.getString("Name");
      String Description = results.getString("Description");
      String Menu = results.getString("Menu");
      String Hours = results.getString("Hours");
      Boolean Active = results.getBoolean("Active");
      Restaurants.CuisineType CuisineType = Restaurants.CuisineType.valueOf(
          results.getString("CuisineType"));
      String Street1 = results.getString("Street1");
      String Street2 = results.getString("Street2");
      String City = results.getString("City");
      String State = results.getString("State");
      int Zip = results.getInt("Zip");
      CompaniesDao companiesDao=CompaniesDao.getInstance();
      Companies Company=companiesDao.getCompanyByCompanyName(results.getString("CompanyName"));
      Restaurants restaurant = new Restaurants(RestaurantId, Name, Description, Menu, Hours,
          Active, CuisineType, Street1, Street2, City, State, Zip, Company);
      return restaurant;
    }
    catch (SQLException e) {
      e.printStackTrace();
      throw e;
    }
  }
  public Restaurants getRestaurantById(int restaurantId)throws SQLException{
    String selectOne = "SELECT RestaurantId,Name,Description,Menu,Hours,Active,"
        + "CuisineType,Street1,Street2,City,State,Zip,CompanyName FROM Restaurants"
        + " WHERE RestaurantId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setInt(1, restaurantId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        return getRestaurantFromResult(results);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(selectStmt != null) {
        selectStmt.close();
      }
      if(results != null) {
        results.close();
      }
    }
    return null;
  }
  public List<Restaurants> getRestaurantsByCuisine(Restaurants.CuisineType cuisine)throws SQLException{
    List<Restaurants> res=new ArrayList<Restaurants>();
    String selectOne = "SELECT RestaurantId,Name,Description,Menu,Hours,Active,"
        + "CuisineType,Street1,Street2,City,State,Zip,CompanyName "
        + "FROM Restaurants WHERE CuisineType=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setString(1, cuisine.name());
      results = selectStmt.executeQuery();
      while(results.next()) {
        res.add(getRestaurantFromResult(results));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(selectStmt != null) {
        selectStmt.close();
      }
      if(results != null) {
        results.close();
      }
    }
    return res;
  }
  public List<Restaurants> getRestaurantsByCompanyName(String companyName)throws SQLException{
    List<Restaurants> res=new ArrayList<Restaurants>();
    String selectOne = "SELECT RestaurantId,Name,Description,Menu,Hours,Active,"
        + "CuisineType,Street1,Street2,City,State,Zip,CompanyName "
        + "FROM Restaurants WHERE CompanyName=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setString(1, companyName);
      results = selectStmt.executeQuery();
      while(results.next()) {
        res.add(getRestaurantFromResult(results));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(selectStmt != null) {
        selectStmt.close();
      }
      if(results != null) {
        results.close();
      }
    }
    return res;
  }
  public Restaurants delete(Restaurants restaurant)throws SQLException{
    String deleteOne = "DELETE FROM Restaurants WHERE RestaurantId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteOne);
      deleteStmt.setInt(1, restaurant.getRestaurantId());
      deleteStmt.executeUpdate();
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(deleteStmt != null) {
        deleteStmt.close();
      }
    }
  }

}
