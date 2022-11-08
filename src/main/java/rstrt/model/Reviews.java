package rstrt.model;
/*
  ReviewId INT AUTO_INCREMENT,
  Created TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  Content VARCHAR(1024) NOT NULL,
  Rating DECIMAL(2,1) NOT NULL,
  UserName VARCHAR(255),
  RestaurantId INT,

 */
import java.sql.Timestamp;

public class Reviews {
  protected int ReviewId;
  protected Timestamp Created;
  protected String Content;
  protected Float Rating;
  protected Users users;
  protected Restaurants restaurants;

  public Reviews(int reviewId, Timestamp created, String content, Float rating,
      Users users, Restaurants restaurants) {
    ReviewId = reviewId;
    Created = created;
    Content = content;
    Rating = rating;
    this.users = users;
    this.restaurants = restaurants;
  }

  public Reviews(Timestamp created, String content, Float rating, Users users,
      Restaurants restaurants) {
    Created = created;
    Content = content;
    Rating = rating;
    this.users = users;
    this.restaurants = restaurants;
  }

  public int getReviewId() {
    return ReviewId;
  }

  public void setReviewId(int reviewId) {
    ReviewId = reviewId;
  }

  public Timestamp getCreated() {
    return Created;
  }

  public void setCreated(Timestamp created) {
    Created = created;
  }

  public String getContent() {
    return Content;
  }

  public void setContent(String content) {
    Content = content;
  }

  public Float getRating() {
    return Rating;
  }

  public void setRating(Float rating) {
    Rating = rating;
  }

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  public Restaurants getRestaurants() {
    return restaurants;
  }

  public void setRestaurants(Restaurants restaurants) {
    this.restaurants = restaurants;
  }

  @Override
  public String toString() {
    return "Reviews{" +
        "ReviewId=" + ReviewId +
        ", Created=" + Created +
        ", Content='" + Content + '\'' +
        ", Rating=" + Rating +
        ", users=" + users +
        ", restaurants=" + restaurants +
        '}';
  }
}
