package rstrt.model;

public class SitDownRestaurants extends Restaurants {
	protected int capacity;

	public SitDownRestaurants(int restaurantId, String name, String description, String menu,
			String hours, Boolean active, Restaurants.CuisineType cuisineType, String street1,
			String street2, String city, String state, int zip, String companyName, int capacity) {
		super(restaurantId, name, description, menu, hours, active, cuisineType, street1, street2,
				city,
				state, zip, companyName);
		this.capacity = capacity;
	}

	public SitDownRestaurants(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CuisineType cuisineType, String street1, String street2,
			String city, String state, int zip, String companyName, int capacity) {
		super(name, description, menu, hours, active, cuisineType, street1, street2, city, state, zip,
				companyName);
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
			String state, int zip, String companyName, int capacity) {
		super(name, description, menu, hours, active, cuisineType, street1, city, state, zip,
				companyName);
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

}
