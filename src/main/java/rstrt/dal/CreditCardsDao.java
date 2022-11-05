package rstrt.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
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

  }
  public List<CreditCards> getCreditCardsByUserName(String userName){

  }
  public CreditCards updateExpiration(CreditCards creditCard, Date newExpiration){

  }
  public CreditCards delete(CreditCards creditCard){

  }

}
