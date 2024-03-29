package rstrt.dal;

import rstrt.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
  protected String UserName;
  protected String Password;
  protected String FirstName;
  protected String LastName;
  protected String Email;
  protected String Phone;
 */

public class UsersDao {
  protected ConnectionManager connectionManager;

  // Single pattern: instantiation is limited to one object.
  private static UsersDao instance = null;
  protected UsersDao() {
    connectionManager = new ConnectionManager();
  }
  public static UsersDao getInstance() {
    if(instance == null) {
      instance = new UsersDao();
    }
    return instance;
  }

  /**
   * Save the Persons instance by storing it in your MySQL instance.
   * This runs a INSERT statement.
   */
  public Users create(Users user) throws SQLException {
    String insertPerson = "INSERT INTO Users(UserName,Password,FirstName,LastName,Email,Phone) VALUES(?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertPerson);
      // PreparedStatement allows us to substitute specific types into the query template.
      // For an overview, see:
      // http://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html.
      // http://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
      // For nullable fields, you can check the property first and then call setNull()
      // as applicable.
      insertStmt.setString(1, user.getUserName());
      insertStmt.setString(2, user.getPassword());
      insertStmt.setString(3, user.getFirstName());
      insertStmt.setString(4, user.getLastName());
      insertStmt.setString(5, user.getEmail());
      insertStmt.setString(6, user.getPhone());
      // Note that we call executeUpdate(). This is used for a INSERT/UPDATE/DELETE
      // statements, and it returns an int for the row counts affected (or 0 if the
      // statement returns nothing). For more information, see:
      // http://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
      // I'll leave it as an exercise for you to write UPDATE/DELETE methods.
      insertStmt.executeUpdate();

      // Note 1: if this was an UPDATE statement, then the person fields should be
      // updated before returning to the caller.
      // Note 2: there are no auto-generated keys, so no update to perform on the
      // input param person.
      return user;
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
    }
  }

  /**
   * Delete the Persons instance.
   * This runs a DELETE statement.
   */
  public Users delete(Users user) throws SQLException {
    String deletePerson = "DELETE FROM Users WHERE UserName=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deletePerson);
      deleteStmt.setString(1, user.getUserName());
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

  /**
   * Get the Persons record by fetching it from your MySQL instance.
   * This runs a SELECT statement and returns a single Persons instance.
   * public Users getUserByUserName(String userName)
   */
  public Users getPersonByUserName(String userName) throws SQLException {
    String selectPerson = "SELECT UserName,Password,FirstName,LastName,Phone,Email FROM Users WHERE UserName=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectPerson);
      selectStmt.setString(1, userName);
      // Note that we call executeQuery(). This is used for a SELECT statement
      // because it returns a result set. For more information, see:
      // http://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
      // http://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
      results = selectStmt.executeQuery();
      // You can iterate the result set (although the example below only retrieves
      // the first record). The cursor is initially positioned before the row.
      // Furthermore, you can retrieve fields by name and by type.
      if(results.next()) {
        String resultUserName = results.getString("UserName");
        String password = results.getString("Password");
        String firstName = results.getString("FirstName");
        String lastName = results.getString("LastName");
        String phone = results.getString("Phone");
        String email = results.getString("Email");
        Users user = new Users(resultUserName, password,firstName, lastName,phone,email);
        return user;
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
}

