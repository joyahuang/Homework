package rstrt.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rstrt.model.Restaurants;
import rstrt.model.SitDownRestaurants;

public class SitDownRestaurantsDao {
  protected ConnectionManager connectionManager;
  private static SitDownRestaurantsDao instance=null;
  protected SitDownRestaurantsDao(){
    connectionManager=new ConnectionManager();
  }
  public static SitDownRestaurantsDao getInstance(){
    if(instance==null){
      instance=new SitDownRestaurantsDao();
    }
    return instance;
  }
  public SitDownRestaurants create(SitDownRestaurants sitDownRestaurant)throws SQLException{
    String insertOne="INSERT INTO SitDownRestaurant(RestaurantId,Capacity) VALUES(?,?)";
    Connection connection=null;
    PreparedStatement insertStmt=null;
    try{
      connection=connectionManager.getConnection();
      insertStmt=connection.prepareStatement(insertOne);
      insertStmt.setInt(1,sitDownRestaurant.getRestaurantId());
      insertStmt.setInt(2,sitDownRestaurant.getCapacity());
      insertStmt.executeUpdate();
      return sitDownRestaurant;
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
  public SitDownRestaurants getSitDownRestaurantById(int sitDownRestaurantId)throws SQLException{
    String selectOne = "SELECT RestaurantId,Name,Description,Menu,Hours,Active,"
        + "CuisineType,Street1,Street2,City,State,Zip,CompanyName,SitDownRestaurant.Capacity "
        + "FROM Restaurants INNER JOIN SitDownRestaurant "
        + "ON Restaurants.RestaurantId=SitDownRestaurant.RestaurantId"
        + " WHERE RestaurantId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setInt(1, sitDownRestaurantId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        int Capacity=results.getInt("Capacity");
        SitDownRestaurants sitdownrestaurants=new SitDownRestaurants(RestaurantsDao.getInstance()
            .getRestaurantFromResult(results), Capacity);
        return sitdownrestaurants;
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
  public List<SitDownRestaurants> getSitDownRestaurantsByCompanyName(String companyName)throws SQLException{
    List<SitDownRestaurants> res=new ArrayList<SitDownRestaurants>();
    String selectOne = "SELECT RestaurantId,Name,Description,Menu,Hours,Active,"
        + "CuisineType,Street1,Street2,City,State,Zip,CompanyName,SitDownRestaurant.Capacity "
        + "FROM Restaurants INNER JOIN SitDownRestaurant "
        + "ON Restaurants.RestaurantId=SitDownRestaurant.RestaurantId"
        + " WHERE CompanyName=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setString(1, companyName);
      results = selectStmt.executeQuery();
      while(results.next()) {
        int Capacity=results.getInt("Capacity");
        SitDownRestaurants sitdownrestaurants=new SitDownRestaurants(RestaurantsDao.getInstance()
            .getRestaurantFromResult(results), Capacity);
        res.add(sitdownrestaurants);
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
  public SitDownRestaurants delete(SitDownRestaurants sitDownRestaurant)throws SQLException{
    String deleteOne = "DELETE FROM SitDownRestaurant WHERE RestaurantId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteOne);
      deleteStmt.setInt(1, sitDownRestaurant.getRestaurantId());
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
