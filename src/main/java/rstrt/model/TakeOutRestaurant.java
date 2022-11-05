package rstrt.model;

import java.util.Date;
import rstrt.model.Restaurants.CruisineType;


public class TakeOutRestaurant extends Restaurants {
	protected int MaxWaitTime;

	public TakeOutRestaurant(int restaurantId, String name, String description, String menu,
			String hours, Boolean active, Restaurants.CruisineType cruisineType, String street1,
			String street2, String city, String state, int zip, String companyName, int maxWaitTime) {
		super(restaurantId, name, description, menu, hours, active, cruisineType, street1, street2,
				city,
				state, zip, companyName);
		MaxWaitTime = maxWaitTime;
	}

	public TakeOutRestaurant(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CruisineType cruisineType, String street1, String street2,
			String city, String state, int zip, String companyName, int maxWaitTime) {
		super(name, description, menu, hours, active, cruisineType, street1, street2, city, state, zip,
				companyName);
		MaxWaitTime = maxWaitTime;
	}

	public TakeOutRestaurant(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CruisineType cruisineType, String street1, String city,
			String state, int zip, int maxWaitTime) {
		super(name, description, menu, hours, active, cruisineType, street1, city, state, zip);
		MaxWaitTime = maxWaitTime;
	}

	public TakeOutRestaurant(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CruisineType cruisineType, String street1, String city,
			String state, int zip, String companyName, int maxWaitTime) {
		super(name, description, menu, hours, active, cruisineType, street1, city, state, zip,
				companyName);
		MaxWaitTime = maxWaitTime;
	}

	public TakeOutRestaurant(String name, String description, String menu, String hours,
			Boolean active, Restaurants.CruisineType cruisineType, String street1, String street2,
			String city, String state, int zip, int maxWaitTime) {
		super(name, description, menu, hours, active, cruisineType, street1, street2, city, state, zip);
		MaxWaitTime = maxWaitTime;
	}

	public int getMaxWaitTime() {
		return MaxWaitTime;
	}

	public void setMaxWaitTime(int maxWaitTime) {
		MaxWaitTime = maxWaitTime;
	}
}
