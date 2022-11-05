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
  protected String UserName;
  protected int RestaurantId;

  public Reviews(int reviewId, Timestamp created, String content, Float rating,
      String userName, int restaurantId) {
    ReviewId = reviewId;
    Created = created;
    Content = content;
    Rating = rating;
    UserName = userName;
    RestaurantId = restaurantId;
  }

  public Reviews(Timestamp created, String content, Float rating, String userName,
      int restaurantId) {
    Created = created;
    Content = content;
    Rating = rating;
    UserName = userName;
    RestaurantId = restaurantId;
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
