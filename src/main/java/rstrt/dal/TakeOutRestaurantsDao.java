package rstrt.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rstrt.model.TakeOutRestaurants;

public class TakeOutRestaurantsDao {
  protected ConnectionManager connectionManager;
  private static TakeOutRestaurantsDao instance=null;
  protected TakeOutRestaurantsDao(){
    connectionManager=new ConnectionManager();
  }
  public static TakeOutRestaurantsDao getInstance(){
    if(instance==null){
      instance=new TakeOutRestaurantsDao();
    }
    return instance;
  }
  public TakeOutRestaurants create(TakeOutRestaurants takeOutRestaurants)throws SQLException {
    String insertOne="INSERT INTO TakeOutRestaurant(RestaurantId,MaxWaitTime) VALUES(?,?)";
    Connection connection=null;
    PreparedStatement insertStmt=null;
    try{
      connection=connectionManager.getConnection();
      insertStmt=connection.prepareStatement(insertOne);
      insertStmt.setInt(1,takeOutRestaurants.getRestaurantId());
      insertStmt.setInt(2,takeOutRestaurants.getMaxWaitTime());
      insertStmt.executeUpdate();
      return takeOutRestaurants;
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
  public TakeOutRestaurants getTakeOutRestaurantById(int restaurantId)throws SQLException{
    String selectOne = "SELECT RestaurantId,Name,Description,Menu,Hours,Active,"
        + "CuisineType,Street1,Street2,City,State,Zip,CompanyName,TakeOutRestaurant.MaxWaitTime "
        + "FROM Restaurants INNER JOIN TakeOutRestaurant "
        + "ON Restaurants.RestaurantId=TakeOutRestaurant.RestaurantId"
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
        int MaxWaitTime=results.getInt("MaxWaitTime");
        TakeOutRestaurants takeoutrestaurants=new TakeOutRestaurants(RestaurantsDao.getInstance()
            .getRestaurantFromResult(results), MaxWaitTime);
        return takeoutrestaurants;
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
  public List<TakeOutRestaurants> getTakeOutRestaurantsByCompanyName(String companyName)throws SQLException{
    List<TakeOutRestaurants> res=new ArrayList<TakeOutRestaurants>();
    String selectOne = "SELECT RestaurantId,Name,Description,Menu,Hours,Active,"
        + "CuisineType,Street1,Street2,City,State,Zip,CompanyName,TakeOutRestaurant.MaxWaitTime "
        + "FROM Restaurants INNER JOIN TakeOutRestaurant "
        + "ON Restaurants.RestaurantId=TakeOutRestaurant.RestaurantId"
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
        int MaxWaitTime=results.getInt("MaxWaitTime");
        TakeOutRestaurants takeOutrestaurants=new TakeOutRestaurants(RestaurantsDao.getInstance()
            .getRestaurantFromResult(results), MaxWaitTime);
        res.add(takeOutrestaurants);
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
  public TakeOutRestaurants delete(TakeOutRestaurants takeOutRestaurant)throws SQLException{
    String deleteOne = "DELETE FROM TakeOutRestaurant WHERE RestaurantId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteOne);
      deleteStmt.setInt(1, takeOutRestaurant.getRestaurantId());
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
