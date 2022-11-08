package rstrt.model;
/*
*   CardNumber BIGINT,
  Expiration DATE NOT NULL,
  UserName VARCHAR(255) NOT NULL,
* */
import java.sql.Date;
public class CreditCards {
  protected long CardNumber;
  protected Date Expiration;
  protected Users user;

  public CreditCards(long cardNumber, Date expiration, Users user) {
    CardNumber = cardNumber;
    Expiration = expiration;
    this.user = user;
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

  public Users getUser() {
    return user;
  }

  public void setUser(Users user) {
    this.user = user;
  }
}
