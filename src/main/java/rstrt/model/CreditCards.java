package rstrt.model;
/*
*   CardNumber BIGINT,
  Expiration DATE NOT NULL,
  UserName VARCHAR(255) NOT NULL,
* */
import java.sql.Date
public class CreditCards {
  protected long CardNumber;
  protected Date Expiration;
  protected String UserName;

  public CreditCards(long cardNumber, Date expiration, String userName) {
    CardNumber = cardNumber;
    Expiration = expiration;
    UserName = userName;
  }

  public long getCardNumber() {
    return CardNumber;
  }

  public void setCardNumber(long cardNumber) {
    CardNumber = cardNumber;
  }

  public Date getExpiration() {
    return Expiration;
  }

  public void setExpiration(Date expiration) {
    Expiration = expiration;
  }

  public String getUserName() {
    return UserName;
  }

  public void setUserName(String userName) {
    UserName = userName;
  }
}
