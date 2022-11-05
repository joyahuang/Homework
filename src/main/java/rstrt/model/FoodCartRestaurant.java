package rstrt.model;

import rstrt.model.Restaurants.CruisineType;

public class FoodCartRestaurant extends Restaurants{
  protected boolean Licensed;

  public FoodCartRestaurant(int restaurantId, String name, String description, String menu,
      String hours, Boolean active, Restaurants.CruisineType cruisineType, String street1,
      String street2, String city, String state, int zip, String companyName, boolean licensed) {
    super(restaurantId, name, description, menu, hours, active, cruisineType, street1, street2,
        city,
        state, zip, companyName);
    Licensed = licensed;
  }

  public FoodCartRestaurant(String name, String description, String menu, String hours,
      Boolean active, Restaurants.CruisineType cruisineType, String street1, String street2,
      String city, String state, int zip, String companyName, boolean licensed) {
    super(name, description, menu, hours, active, cruisineType, street1, street2, city, state, zip,
        companyName);
    Licensed = licensed;
  }

  public FoodCartRestaurant(String name, String description, String menu, String hours,
      Boolean active, Restaurants.CruisineType cruisineType, String street1, String city,
      String state, int zip, boolean licensed) {
    super(name, description, menu, hours, active, cruisineType, street1, city, state, zip);
    Licensed = licensed;
  }

  public FoodCartRestaurant(String name, String description, String menu, String hours,
      Boolean active, Restaurants.CruisineType cruisineType, String street1, String city,
      String state, int zip, String companyName, boolean licensed) {
    super(name, description, menu, hours, active, cruisineType, street1, city, state, zip,
        companyName);
    Licensed = licensed;
  }

  public FoodCartRestaurant(String name, String description, String menu, String hours,
      Boolean active, Restaurants.CruisineType cruisineType, String street1, String street2,
      String city, String state, int zip, boolean licensed) {
    super(name, description, menu, hours, active, cruisineType, street1, street2, city, state, zip);
    Licensed = licensed;
  }

  public boolean isLicensed() {
    return Licensed;
  }

  public void setLicensed(boolean licensed) {
    Licensed = licensed;
  }
}
