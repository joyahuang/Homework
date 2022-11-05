package rstrt.model;
/*
  RecommendationId INT AUTO_INCREMENT,
  UserName VARCHAR(255),
  RestaurantId INT,

 */
public class Recommendations {
  protected int RecommendationId;
  protected String UserName;
  protected int RestaurantId;

  public Recommendations(int recommendationId, String userName, int restaurantId) {
    RecommendationId = recommendationId;
    UserName = userName;
    RestaurantId = restaurantId;
  }

  public Recommendations(String userName, int restaurantId) {
    UserName = userName;
    RestaurantId = restaurantId;
  }

  public int getRecommendationId() {
    return RecommendationId;
  }

  public void setRecommendationId(int recommendationId) {
    RecommendationId = recommendationId;
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
