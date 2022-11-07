package rstrt.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import rstrt.model.Recommendations;
import rstrt.model.Restaurants;
import rstrt.model.Users;

public class RecommendatioinsDao {
  protected ConnectionManager connectionManager;
  private static RecommendatioinsDao instance=null;
  protected RecommendatioinsDao(){
    connectionManager=new ConnectionManager();
  }
  public static RecommendatioinsDao getInstance(){
    if(instance==null){
      instance=new RecommendatioinsDao();
    }
    return instance;
  }
  UsersDao usersDao=UsersDao.getInstance();
  RestaurantsDao restaurantsDao=RestaurantsDao.getInstance();
  public Recommendations create(Recommendations recommendation)throws SQLException{
    String insertOne =
        "INSERT INTO Recommendations(UserName,RestaurantId) " +
            "VALUES(?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertOne,
          Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1,recommendation.getUsers().getUserName());
      insertStmt.setInt(2,recommendation.getRestaurants().getRestaurantId());
      insertStmt.executeUpdate();
      resultKey = insertStmt.getGeneratedKeys();
      int recommendationId = -1;
      if(resultKey.next()) {
        recommendationId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      recommendation.setRecommendationId(recommendationId);
      return recommendation;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(insertStmt != null) {
        insertStmt.close();
      }
      if(resultKey != null) {
        resultKey.close();
      }
    }
  }
  public Recommendations getRecommendationFromResult(ResultSet results)throws SQLException{
    int resultRecommendationId = results.getInt("RecommendationId");
    Users user=usersDao.getPersonByUserName(results.getString("UserName"));
    Restaurants restaurant=restaurantsDao.getRestaurantById(results.getInt("RestaurantId"));
    Recommendations recommendation=new Recommendations(resultRecommendationId,user,restaurant);
    return recommendation;
  }
  public Recommendations getRecommendationById(int recommendationId)throws SQLException{
    String selectOne =
        "SELECT RecommendationId,UserName,RestaurantId " +
            "FROM Recommendations " +
            "WHERE RecommendationId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setInt(1, recommendationId);
      results = selectStmt.executeQuery();

      if(results.next()) {
        return getRecommendationFromResult(results);
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
  public List<Recommendations> getRecommendationsByUserName(String userName)throws SQLException{
    List<Recommendations> res=new ArrayList<>();
    String selectOne =
        "SELECT RecommendationId,UserName,RestaurantId " +
            "FROM Recommendations " +
            "WHERE UserName=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setString(1, userName);
      results = selectStmt.executeQuery();
      while(results.next()) {
        res.add(getRecommendationFromResult(results));
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
  public List<Recommendations> getRecommendationsByRestaurantId(int restaurantId)throws SQLException{
    List<Recommendations> res=new ArrayList<>();
    String selectOne =
        "SELECT RecommendationId,UserName,RestaurantId " +
            "FROM Recommendations " +
            "WHERE RestaurantId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setInt(1, restaurantId);
      results = selectStmt.executeQuery();
      while(results.next()) {
        res.add(getRecommendationFromResult(results));
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
  public Recommendations delete(Recommendations recommendation)throws SQLException{
    String deleteOne = "DELETE FROM Recommendations WHERE RecommendationId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteOne);
      deleteStmt.setInt(1, recommendation.getRecommendationId());
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
