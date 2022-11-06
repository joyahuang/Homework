package rstrt.model;


public class TakeOutRestaurants extends Restaurants {
	protected int MaxWaitTime;

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
}
