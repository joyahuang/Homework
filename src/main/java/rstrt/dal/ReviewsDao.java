package rstrt.dal;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import rstrt.model.Restaurants;
import rstrt.model.Reviews;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import rstrt.model.Users;


public class ReviewsDao {
  protected ConnectionManager connectionManager;
  private static ReviewsDao instance=null;
  protected ReviewsDao(){
    connectionManager=new ConnectionManager();
  }
  public static ReviewsDao getInstance(){
    if(instance==null){
      instance=new ReviewsDao();
    }
    return instance;
  }
  UsersDao usersDao=UsersDao.getInstance();
  RestaurantsDao restaurantsDao=RestaurantsDao.getInstance();
  public Reviews create(Reviews review)throws SQLException{
    String insertOne =
        "INSERT INTO Reviews(Created,Content,Rating,UserName,RestaurantId) " +
            "VALUES(?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertOne,
          Statement.RETURN_GENERATED_KEYS);
      insertStmt.setTimestamp(1, new Timestamp(review.getCreated().getTime()));
      insertStmt.setString(2, review.getContent());
      insertStmt.setFloat(3, review.getRating());
      insertStmt.setString(4,review.getUsers().getUserName());
      insertStmt.setInt(5,review.getRestaurants().getRestaurantId());
      insertStmt.executeUpdate();
      resultKey = insertStmt.getGeneratedKeys();
      int reviewId = -1;
      if(resultKey.next()) {
        reviewId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      review.setReviewId(reviewId);
      return review;
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
  public Reviews getReviewFromResult(ResultSet results)throws SQLException{
    int resultReviewId = results.getInt("ReviewId");
    Timestamp created =  results.getTimestamp("Created");
    String content = results.getString("Content");
    Float rating=results.getFloat("Rating");
    Users user=usersDao.getPersonByUserName(results.getString("UserName"));
    Restaurants restaurant=restaurantsDao.getRestaurantById(results.getInt("RestaurantId"));
    Reviews review=new Reviews(resultReviewId,created,content,rating,user,restaurant);
    return review;
  }
  public Reviews getReviewById(int reviewId)throws SQLException{
    String selectOne =
        "SELECT ReviewId,Created,Content,Rating,UserName,RestaurantId " +
            "FROM Reviews " +
            "WHERE ReviewId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setInt(1, reviewId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        return getReviewFromResult(results);
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
  public List<Reviews> getReviewsByUserName(String userName)throws SQLException{
    List<Reviews> res=new ArrayList<>();
    String selectOne =
        "SELECT ReviewId,Created,Content,Rating,UserName,RestaurantId " +
            "FROM Reviews " +
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
        res.add(getReviewFromResult(results));
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
  public List<Reviews> getReviewsByRestaurantId(int restaurantId)throws SQLException{
    List<Reviews> res=new ArrayList<>();
    String selectOne =
        "SELECT ReviewId,Created,Content,Rating,UserName,RestaurantId " +
            "FROM Reviews " +
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
        res.add(getReviewFromResult(results));
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
  public Reviews delete(Reviews review)throws SQLException{
    String deleteOne = "DELETE FROM Reviews WHERE ReviewId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteOne);
      deleteStmt.setInt(1, review.getReviewId());
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
