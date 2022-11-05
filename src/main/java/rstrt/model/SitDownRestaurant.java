package rstrt.model;

import rstrt.model.Restaurants.CruisineType;

public class SitDownRestaurant extends Restaurants {
	protected int capacity;

	public SitDownRestaurant(int restaurantId, String name, String description, String menu,
			String hours, Boolean active, Restaurants.CruisineType cruisineType, String street1,
			String street2, String city, String state, int zip, String companyName, int capacity) {
		super(restaurantId, name, description, menu, hours, active, cruisineType, street1, street2,
				city,
				state, zip, companyName);
		this.capacity = capacity;
	}

	public SitDownRestaurant(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CruisineType cruisineType, String street1, String street2,
			String city, String state, int zip, String companyName, int capacity) {
		super(name, description, menu, hours, active, cruisineType, street1, street2, city, state, zip,
				companyName);
		this.capacity = capacity;
	}

	public SitDownRestaurant(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CruisineType cruisineType, String street1, String city,
			String state, int zip, int capacity) {
		super(name, description, menu, hours, active, cruisineType, street1, city, state, zip);
		this.capacity = capacity;
	}

	public SitDownRestaurant(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CruisineType cruisineType, String street1, String city,
			String state, int zip, String companyName, int capacity) {
		super(name, description, menu, hours, active, cruisineType, street1, city, state, zip,
				companyName);
		this.capacity = capacity;
	}

	public SitDownRestaurant(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CruisineType cruisineType, String street1, String street2,
			String city, String state, int zip, int capacity) {
		super(name, description, menu, hours, active, cruisineType, street1, street2, city, state, zip);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
