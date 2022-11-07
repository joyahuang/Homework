package rstrt.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rstrt.model.FoodCartRestaurants;

public class FoodCartRestaurantsDao {
  protected ConnectionManager connectionManager;
  private static FoodCartRestaurantsDao instance=null;
  protected FoodCartRestaurantsDao(){
    connectionManager=new ConnectionManager();
  }
  public static FoodCartRestaurantsDao getInstance(){
    if(instance==null){
      instance=new FoodCartRestaurantsDao();
    }
    return instance;
  }
  public FoodCartRestaurants create(FoodCartRestaurants foodCartRestaurants)throws SQLException {
    RestaurantsDao.getInstance().create(foodCartRestaurants.getParent());
    String insertOne="INSERT INTO TakeOutRestaurants(RestaurantId,Licensed) VALUES(?,?)";
    Connection connection=null;
    PreparedStatement insertStmt=null;
    try{
      connection=connectionManager.getConnection();
      insertStmt=connection.prepareStatement(insertOne);
      insertStmt.setInt(1,foodCartRestaurants.getRestaurantId());
      insertStmt.setBoolean(2,foodCartRestaurants.isLicensed());
      insertStmt.executeUpdate();
      return foodCartRestaurants;
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
  public FoodCartRestaurants getFoodCartRestaurantById(int restaurantId)throws SQLException{
    String selectOne = "SELECT RestaurantId,Name,Description,Menu,Hours,Active,"
        + "CuisineType,Street1,Street2,City,State,Zip,CompanyName,FoodCartRestaurants.Licensed "
        + "FROM Restaurants INNER JOIN FoodCartRestaurants "
        + "ON Restaurants.RestaurantId=FoodCartRestaurants.RestaurantId"
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
        Boolean Licensed=results.getBoolean("Licensed");
        FoodCartRestaurants foodCartrestaurants=new FoodCartRestaurants(RestaurantsDao.getInstance()
            .getRestaurantFromResult(results), Licensed);
        return foodCartrestaurants;
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
  public List<FoodCartRestaurants> getFoodCartRestaurantsByCompanyName(String companyName)throws SQLException{
    List<FoodCartRestaurants> res=new ArrayList<FoodCartRestaurants>();
    String selectOne = "SELECT RestaurantId,Name,Description,Menu,Hours,Active,"
        + "CuisineType,Street1,Street2,City,State,Zip,CompanyName,FoodCartRestaurants.Licensed "
        + "FROM Restaurants INNER JOIN FoodCartRestaurants "
        + "ON Restaurants.RestaurantId=FoodCartRestaurants.RestaurantId"
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
        Boolean Licensed=results.getBoolean("Licensed");
        FoodCartRestaurants foodCartRestaurants=new FoodCartRestaurants(RestaurantsDao.getInstance()
            .getRestaurantFromResult(results), Licensed);
        res.add(foodCartRestaurants);
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
  public FoodCartRestaurants delete(FoodCartRestaurants foodCartRestaurant)throws SQLException{
    String deleteOne = "DELETE FROM FoodCartRestaurants WHERE RestaurantId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteOne);
      deleteStmt.setInt(1, foodCartRestaurant.getRestaurantId());
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
