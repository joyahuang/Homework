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
  protected Users users;
  protected SitDownRestaurants restaurants;

  public Reservations(int reservationId, Timestamp start, Timestamp end, int size,
      Users users, SitDownRestaurants restaurants) {
    ReservationId = reservationId;
    Start = start;
    End = end;
    Size = size;
    this.users = users;
    this.restaurants = restaurants;
  }

  public Reservations(Timestamp start, Timestamp end, int size, Users users,
      SitDownRestaurants restaurants) {
    Start = start;
    End = end;
    Size = size;
    this.users = users;
    this.restaurants = restaurants;
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

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  public SitDownRestaurants getRestaurants() {
    return restaurants;
  }

  public void setRestaurants(SitDownRestaurants restaurants) {
    this.restaurants = restaurants;
  }

  @Override
  public String toString() {
    return "Reservations{" +
        "ReservationId=" + ReservationId +
        ", Start=" + Start +
        ", End=" + End +
        ", Size=" + Size +
        ", users=" + users +
        ", restaurants=" + restaurants +
        '}';
  }
}
