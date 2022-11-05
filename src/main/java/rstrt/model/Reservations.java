package rstrt.model;

import java.sql.Timestamp;

/*
  ReservationId INT AUTO_INCREMENT,
  Start TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  End TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  Size INT NOT NULL,
  UserName VARCHAR(255),
  RestaurantId INT,

 */
public class Reservations {
  protected int ReservationId;
  protected Timestamp Start;
  protected Timestamp End;
  protected int Size;
  protected String UserName;
  protected int RestaurantId;

  public Reservations(int reservationId, Timestamp start, Timestamp end, int size,
      String userName, int restaurantId) {
    ReservationId = reservationId;
    Start = start;
    End = end;
    Size = size;
    UserName = userName;
    RestaurantId = restaurantId;
  }

  public Reservations(Timestamp start, Timestamp end, int size, String userName, int restaurantId) {
    Start = start;
    End = end;
    Size = size;
    UserName = userName;
    RestaurantId = restaurantId;
  }

  public int getReservationId() {
    return ReservationId;
  }

  public void setReservationId(int reservationId) {
    ReservationId = reservationId;
  }

  public Timestamp getStart() {
    return Start;
  }

  public void setStart(Timestamp start) {
    Start = start;
  }

  public Timestamp getEnd() {
    return End;
  }

  public void setEnd(Timestamp end) {
    End = end;
  }

  public int getSize() {
    return Size;
  }

  public void setSize(int size) {
    Size = size;
  }

  public String getUserName() {
    return UserName;
  }

  public void setUserName(String userName) {
    UserName = userName;
  }

  public int getRestaurantId() {
    return RestaurantId;
  }

  public void setRestaurantId(int restaurantId) {
    RestaurantId = restaurantId;
  }
}
