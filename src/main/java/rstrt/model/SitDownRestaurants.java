package rstrt.model;

import rstrt.model.Restaurants.CuisineType;

public class SitDownRestaurants extends Restaurants {
	protected int capacity;
	public SitDownRestaurants(Restaurants restaurant,int capacity){
		super(restaurant.getRestaurantId(),
				restaurant.getName(),
				restaurant.getDescription(),
				restaurant.getMenu(),
				restaurant.getHours(),
				restaurant.getActive(),
				restaurant.getCuisineType(),
				restaurant.getStreet1(),
				restaurant.getStreet2(),
				restaurant.getCity(),
				restaurant.getState(),
				restaurant.getZip(),
				restaurant.getCompany());
		this.capacity=capacity;
	}

	public SitDownRestaurants(int restaurantId, String name, String description, String menu,
			String hours, Boolean active, Restaurants.CuisineType cuisineType, String street1,
			String street2, String city, String state, int zip, Companies company, int capacity) {
		super(restaurantId, name, description, menu, hours, active, cuisineType, street1, street2, city,
				state, zip, company);
		this.capacity = capacity;
	}

	public SitDownRestaurants(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CuisineType cuisineType, String street1, String street2,
			String city, String state, int zip, Companies company, int capacity) {
		super(name, description, menu, hours, active, cuisineType, street1, street2, city, state, zip,
				company);
		this.capacity = capacity;
	}

	public SitDownRestaurants(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CuisineType cuisineType, String street1, String city,
			String state, int zip, int capacity) {
		super(name, description, menu, hours, active, cuisineType, street1, city, state, zip);
		this.capacity = capacity;
	}

	public SitDownRestaurants(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CuisineType cuisineType, String street1, String city,
			String state, int zip, Companies company, int capacity) {
		super(name, description, menu, hours, active, cuisineType, street1, city, state, zip, company);
		this.capacity = capacity;
	}

	public SitDownRestaurants(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CuisineType cuisineType, String street1, String street2,
			String city, String state, int zip, int capacity) {
		super(name, description, menu, hours, active, cuisineType, street1, street2, city, state, zip);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Restaurants getParent(){
		return new Restaurants(RestaurantId,Name,Description,Menu,Hours,
				Active,CuisineType,Street1,Street2,City,State,Zip,Company);
	}
}
