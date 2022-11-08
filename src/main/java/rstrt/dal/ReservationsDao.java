package rstrt.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import rstrt.model.Reservations;
import rstrt.model.SitDownRestaurants;
import rstrt.model.Users;

public class ReservationsDao {
  protected ConnectionManager connectionManager;
  private static ReservationsDao instance=null;
  protected ReservationsDao(){
    connectionManager=new ConnectionManager();
  }
  public static ReservationsDao getInstance(){
    if(instance==null){
      instance=new ReservationsDao();
    }
    return instance;
  }
  UsersDao usersDao=UsersDao.getInstance();
  SitDownRestaurantsDao restaurantsDao=SitDownRestaurantsDao.getInstance();
  public Reservations create(Reservations reservation)throws SQLException{
    String insertOne =
        "INSERT INTO Reservations(Start,End,Size,UserName,RestaurantId) " +
            "VALUES(?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertOne,
          Statement.RETURN_GENERATED_KEYS);
      insertStmt.setTimestamp(1,reservation.getStart());
      insertStmt.setTimestamp(2,reservation.getEnd());
      insertStmt.setInt(3,reservation.getSize());
      insertStmt.setString(4,reservation.getUsers().getUserName());
      insertStmt.setInt(5,reservation.getRestaurants().getRestaurantId());

      insertStmt.executeUpdate();
      resultKey = insertStmt.getGeneratedKeys();
      int reservationId = -1;
      if(resultKey.next()) {
        reservationId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      reservation.setReservationId(reservationId);
      return reservation;
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
  public Reservations getReservationFromResult(ResultSet results)throws SQLException{
    int resultReservationId = results.getInt("ReservationId");
    Timestamp start=results.getTimestamp("Start");
    Timestamp end=results.getTimestamp("End");
    int size=results.getInt("Size");
    Users user=usersDao.getPersonByUserName(results.getString("UserName"));
    SitDownRestaurants restaurant=restaurantsDao.getSitDownRestaurantById(results.getInt("RestaurantId"));
    Reservations reservation=new Reservations(resultReservationId,start,end,size,user,restaurant);
    return reservation;
  }
  public Reservations getReservationById(int reservationId)throws SQLException{
    String selectOne =
        "SELECT ReservationId,Start,End,Size,UserName,RestaurantId " +
            "FROM Reservations " +
            "WHERE ReservationId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setInt(1, reservationId);
      results = selectStmt.executeQuery();

      if(results.next()) {
        return getReservationFromResult(results);
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
  public List<Reservations> getReservationsByUserName(String userName)throws SQLException{
    List<Reservations> res=new ArrayList<>();
    String selectOne =
        "SELECT ReservationId,Start,End,Size,UserName,RestaurantId " +
            "FROM Reservations " +
            "WHERE UserName=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setString(1, userName);
      results = selectStmt.executeQuery();
      if(results.next()) {
        res.add(getReservationFromResult(results));
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
  public List<Reservations> getReservationsBySitDownRestaurantId(int sitDownRestaurantId)throws SQLException{
    List<Reservations> res=new ArrayList<>();
    String selectOne =
        "SELECT ReservationId,Start,End,Size,UserName,RestaurantId " +
            "FROM Reservations " +
            "WHERE RestaurantId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setInt(1, sitDownRestaurantId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        res.add(getReservationFromResult(results));
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
  public Reservations delete(Reservations reservation)throws SQLException{
    String deleteOne = "DELETE FROM Reservations WHERE ReservationId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteOne);
      deleteStmt.setInt(1, reservation.getReservationId());
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
