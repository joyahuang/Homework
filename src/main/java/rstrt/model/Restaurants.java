package rstrt.model;


public class Restaurants {
	protected int RestaurantId;
	protected String Name;
	protected String Description;
	protected String Menu;
	protected String Hours;
	protected Boolean Active;
	protected CuisineType CuisineType;
	protected String Street1;
	protected String Street2;
	protected String City;
	protected String State;
	protected int Zip;
	protected String CompanyName;

	public enum CuisineType{
		AFRICAN, AMERICAN, ASIAN, EUROPEAN, HISPANIC
	}

	public Restaurants(int restaurantId, String name, String description,
			String menu, String hours, Boolean active,
			Restaurants.CuisineType cuisineType, String street1,
			String street2, String city, String state, int zip,
			String companyName) {
		RestaurantId = restaurantId;
		Name = name;
		Description = description;
		Menu = menu;
		Hours = hours;
		Active = active;
		CuisineType = cuisineType;
		Street1 = street1;
		Street2 = street2;
		City = city;
		State = state;
		Zip = zip;
		CompanyName = companyName;
	}

	public Restaurants(String name, String description, String menu,
			String hours, Boolean active,
			Restaurants.CuisineType cuisineType, String street1,
			String street2, String city, String state, int zip,
			String companyName) {
		Name = name;
		Description = description;
		Menu = menu;
		Hours = hours;
		Active = active;
		CuisineType = cuisineType;
		Street1 = street1;
		Street2 = street2;
		City = city;
		State = state;
		Zip = zip;
		CompanyName = companyName;
	}

	public Restaurants(String name, String description, String menu,
			String hours, Boolean active,
			Restaurants.CuisineType cuisineType, String street1,
			String city, String state, int zip) {
		Name = name;
		Description = description;
		Menu = menu;
		Hours = hours;
		Active = active;
		CuisineType = cuisineType;
		Street1 = street1;
		City = city;
		State = state;
		Zip = zip;
	}

	public Restaurants(String name, String description,
			String menu, String hours, Boolean active,
			Restaurants.CuisineType cuisineType, String street1,
			String city, String state, int zip, String companyName) {
		Name = name;
		Description = description;
		Menu = menu;
		Hours = hours;
		Active = active;
		CuisineType = cuisineType;
		Street1 = street1;
		City = city;
		State = state;
		Zip = zip;
		CompanyName = companyName;
	}

	public Restaurants(String name, String description,
			String menu, String hours, Boolean active,
			Restaurants.CuisineType cuisineType, String street1,
			String street2, String city, String state, int zip) {
		Name = name;
		Description = description;
		Menu = menu;
		Hours = hours;
		Active = active;
		CuisineType = cuisineType;
		Street1 = street1;
		Street2 = street2;
		City = city;
		State = state;
		Zip = zip;
	}

	public int getRestaurantId() {
		return RestaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		RestaurantId = restaurantId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMenu() {
		return Menu;
	}

	public void setMenu(String menu) {
		Menu = menu;
	}

	public String getHours() {
		return Hours;
	}

	public void setHours(String hours) {
		Hours = hours;
	}

	public Boolean getActive() {
		return Active;
	}

	public void setActive(Boolean active) {
		Active = active;
	}

	public Restaurants.CuisineType getCuisineType() {
		return CuisineType;
	}

	public void setCuisineType(Restaurants.CuisineType cuisineType) {
		CuisineType = cuisineType;
	}

	public String getStreet1() {
		return Street1;
	}

	public void setStreet1(String street1) {
		Street1 = street1;
	}

	public String getStreet2() {
		return Street2;
	}

	public void setStreet2(String street2) {
		Street2 = street2;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public int getZip() {
		return Zip;
	}

	public void setZip(int zip) {
		Zip = zip;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
}
