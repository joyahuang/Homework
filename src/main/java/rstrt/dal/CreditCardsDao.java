package rstrt.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import rstrt.model.*;
public class CreditCardsDao {
  protected ConnectionManager connectionManager;
  private static CreditCardsDao instance=null;
  protected CreditCardsDao(){
    connectionManager=new ConnectionManager();
  }
  public static CreditCardsDao getInstance(){
    if(instance==null){
      instance=new CreditCardsDao();
    }
    return instance;
  }
  public CreditCards create(CreditCards creditCard) throws SQLException {
    String insertCreditCard="INSERT INTO CreditCards(CardNumber,Expiration,UserName) VALUES(?,?,?)";
    Connection connection=null;
    PreparedStatement insertStmt=null;
    try{
      connection=connectionManager.getConnection();
      insertStmt=connection.prepareStatement(insertCreditCard);
      insertStmt.setLong(1,creditCard.getCardNumber());
      insertStmt.setDate(2,creditCard.getExpiration());
      insertStmt.setString(3,creditCard.getUserName());
      insertStmt.executeUpdate();
      return creditCard;
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
  public CreditCards getCreditCardByCardNumber(long cardNumber)throws SQLException{
    String selectOne = "SELECT CardNumber,Expiration,UserName FROM CreditCards WHERE CardNumber=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setLong(1, cardNumber);

      results = selectStmt.executeQuery();

      if(results.next()) {
        long resultCardNumber = results.getLong("CardNumber");
        Date expiration = results.getDate("Expiration");
        String username = results.getString("UserName");
        CreditCards creditcard = new CreditCards(resultCardNumber, expiration,username);
        return creditcard;
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
  public List<CreditCards> getCreditCardsByUserName(String userName)throws SQLException{
    List<CreditCards> cards=new ArrayList<CreditCards>();
    String selectOne = "SELECT CardNumber,Expiration,UserName "
        + "FROM CreditCards WHERE UserName=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setString(1, userName);

      results = selectStmt.executeQuery();

      while(results.next()) {
        long resultCardNumber = results.getLong("CardNumber");
        Date expiration = results.getDate("Expiration");
        String username = results.getString("UserName");
        CreditCards creditcard = new CreditCards(resultCardNumber, expiration,username);
        cards.add(creditcard);
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
    return cards;
  }
  public CreditCards updateExpiration(CreditCards creditCard, Date newExpiration)throws SQLException{
    String updateCreditCard="UPDATE CreditCards SET Expiration=? WHERE CardNumber=?";
    Connection connection=null;
    PreparedStatement insertStmt=null;
    try{
      connection=connectionManager.getConnection();
      insertStmt=connection.prepareStatement(updateCreditCard);
      insertStmt.setDate(1,newExpiration);
      insertStmt.setLong(2,creditCard.getCardNumber());
      insertStmt.executeUpdate();
      creditCard.setExpiration(newExpiration);
      return creditCard;
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
  public CreditCards delete(CreditCards creditCard)throws SQLException{
    String deleteOne = "DELETE FROM CreditCards WHERE CardNumber=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteOne);
      deleteStmt.setLong(1, creditCard.getCardNumber());
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
