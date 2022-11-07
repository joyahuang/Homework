package rstrt.model;
/*
  RecommendationId INT AUTO_INCREMENT,
  UserName VARCHAR(255),
  RestaurantId INT,

 */
public class Recommendations {
  protected int RecommendationId;
  protected Users users;
  protected Restaurants restaurants;

  public Recommendations(int recommendationId, Users users, Restaurants restaurants) {
    RecommendationId = recommendationId;
    this.users = users;
    this.restaurants = restaurants;
  }

  public Recommendations(Users users, Restaurants restaurants) {
    this.users = users;
    this.restaurants = restaurants;
  }

  public int getRecommendationId() {
    return RecommendationId;
  }

  public void setRecommendationId(int recommendationId) {
    RecommendationId = recommendationId;
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
}
