package rstrt.model;


public class TakeOutRestaurants extends Restaurants {
	protected int MaxWaitTime;
	public TakeOutRestaurants(Restaurants restaurant,int maxWaitTime){
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
				restaurant.getCompanyName());
		MaxWaitTime=maxWaitTime;
	}
	public TakeOutRestaurants(int restaurantId, String name, String description, String menu,
			String hours, Boolean active, Restaurants.CuisineType cuisineType, String street1,
			String street2, String city, String state, int zip, String companyName, int maxWaitTime) {
		super(restaurantId, name, description, menu, hours, active, cuisineType, street1, street2,
				city,
				state, zip, companyName);
		MaxWaitTime = maxWaitTime;
	}

	public TakeOutRestaurants(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CuisineType cuisineType, String street1, String street2,
			String city, String state, int zip, String companyName, int maxWaitTime) {
		super(name, description, menu, hours, active, cuisineType, street1, street2, city, state, zip,
				companyName);
		MaxWaitTime = maxWaitTime;
	}

	public TakeOutRestaurants(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CuisineType cuisineType, String street1, String city,
			String state, int zip, int maxWaitTime) {
		super(name, description, menu, hours, active, cuisineType, street1, city, state, zip);
		MaxWaitTime = maxWaitTime;
	}

	public TakeOutRestaurants(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CuisineType cuisineType, String street1, String city,
			String state, int zip, String companyName, int maxWaitTime) {
		super(name, description, menu, hours, active, cuisineType, street1, city, state, zip,
				companyName);
		MaxWaitTime = maxWaitTime;
	}

	public TakeOutRestaurants(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CuisineType cuisineType, String street1, String street2,
			String city, String state, int zip, int maxWaitTime) {
		super(name, description, menu, hours, active, cuisineType, street1, street2, city, state, zip);
		MaxWaitTime = maxWaitTime;
	}

	public int getMaxWaitTime() {
		return MaxWaitTime;
	}

	public void setMaxWaitTime(int maxWaitTime) {
		MaxWaitTime = maxWaitTime;
	}
	public Restaurants getParent(){
		return new Restaurants(RestaurantId,Name,Description,Menu,Hours,
				Active,CuisineType,Street1,Street2,City,State,Zip,CompanyName);
	}
}
