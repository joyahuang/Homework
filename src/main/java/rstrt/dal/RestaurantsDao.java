package rstrt.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    String insertOne="INSERT INTO Restaurants(RestaurantId,Name,Description,Menu,"
        + "Hours,Active,CuisineType,Street1,Street2,City,State,Zip,CompanyName) "
        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    Connection connection=null;
    PreparedStatement insertStmt=null;
    try{
      connection=connectionManager.getConnection();
      insertStmt=connection.prepareStatement(insertOne);
      insertStmt.setInt(1,restaurant.getRestaurantId());
      insertStmt.setString(2,restaurant.getName());
      insertStmt.setString(3,restaurant.getDescription());
      insertStmt.setString(4,restaurant.getMenu());
      insertStmt.setString(5,restaurant.getHours());
      insertStmt.setBoolean(6,restaurant.getActive());
      insertStmt.setString(7,restaurant.getCuisineType().name());
      insertStmt.setString(8,restaurant.getStreet1());
      insertStmt.setString(9,restaurant.getStreet1());
      insertStmt.setString(10,restaurant.getCity());
      insertStmt.setString(11,restaurant.getState());
      insertStmt.setInt(12,restaurant.getZip());
      insertStmt.setString(13,restaurant.getCompanyName());
      insertStmt.executeUpdate();
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
      String CompanyName = results.getString("CompanyName");
      Restaurants restaurant = new Restaurants(RestaurantId, Name, Description, Menu, Hours,
          Active, CuisineType, Street1, Street2, City, State, Zip, CompanyName);
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
        int RestaurantId = results.getInt("RestaurantId");
        String Name = results.getString("Name");
        String Description = results.getString("Description");
        String Menu = results.getString("Menu");
        String Hours = results.getString("Hours");
        Boolean Active = results.getBoolean("Active");
        Restaurants.CuisineType CuisineType=Restaurants.CuisineType.valueOf(results.getString("CuisineType"));
        String Street1 = results.getString("Street1");
        String Street2 = results.getString("Street2");
        String City  = results.getString("City");
        String State  = results.getString("State");
        int Zip=results.getInt("Zip");
        String CompanyName  = results.getString("CompanyName");
        Restaurants restaurant=new Restaurants(RestaurantId,Name,Description,Menu,Hours,
            Active,CuisineType,Street1,Street2,City,State,Zip,CompanyName);
        res.add(restaurant);
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
