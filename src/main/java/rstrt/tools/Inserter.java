package rstrt.tools;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import rstrt.dal.*;
import rstrt.model.*;
import rstrt.model.Restaurants.CuisineType;

public class Inserter {

  public static void main(String[] args) throws SQLException {
    // restaurantDao
    RestaurantsDao restaurantsDao=RestaurantsDao.getInstance();
    SitDownRestaurantsDao sitDownRestaurantsDao=SitDownRestaurantsDao.getInstance();
    FoodCartRestaurantsDao foodCartRestaurantsDao=FoodCartRestaurantsDao.getInstance();
    TakeOutRestaurantsDao takeOutRestaurantsDao=TakeOutRestaurantsDao.getInstance();
    CompaniesDao companiesDao=CompaniesDao.getInstance();

    // userDao
    CreditCardsDao creditCardsDao=CreditCardsDao.getInstance();
    UsersDao usersDao=UsersDao.getInstance();


    // re-dao
    RecommendatioinsDao recommendatioinsDao=RecommendatioinsDao.getInstance();
    ReviewsDao reviewsDao=ReviewsDao.getInstance();
    ReservationsDao reservationsDao=ReservationsDao.getInstance();

    Date date=new Date(1667867750);
    Timestamp timestamp=new Timestamp(1667867750);

    // user insert

    Users u1=new Users("u1","1","1","1","1");
    Users u2=new Users("u2","2","2","2","2");
    CreditCards card1=new CreditCards(1,date,u1);
    u1=usersDao.create(u1);
    u2=usersDao.create(u2);
    card1=creditCardsDao.create(card1);


    // Restaurant insert
    Companies c1=new Companies("c2","1");
    c1=companiesDao.create(c1);
    System.out.println("create company "+c1);

    Restaurants r1=new Restaurants("r1","description1","1","1",
        Boolean.TRUE, Restaurants.CuisineType.AFRICAN,"1","1","1","1",98109);
    Restaurants r2=new Restaurants("r2","description2","2","2",
        Boolean.TRUE, Restaurants.CuisineType.AFRICAN,"2","2","2","2",98109,c1);
    Restaurants r3=new Restaurants("r3","description3","3","3",
        Boolean.TRUE, CuisineType.AMERICAN,"3","3","3","3",98109);

    r1=restaurantsDao.create(r1);
    r2=restaurantsDao.create(r2);
    r3=restaurantsDao.create(r3);

    System.out.println("creat restaurant: "+r1);
    System.out.println("creat restaurant: "+r2);
    System.out.println("creat restaurant: "+r3);

    SitDownRestaurants s1=new SitDownRestaurants(r1,1);
    sitDownRestaurantsDao.create(s1);
    System.out.println("create sitdown restaurant: "+s1);

    TakeOutRestaurants t1=new TakeOutRestaurants(r1,1);
    takeOutRestaurantsDao.create(t1);
    System.out.println("create takeout restaurant: "+t1);

    FoodCartRestaurants f1=new FoodCartRestaurants(r1,Boolean.TRUE);
    foodCartRestaurantsDao.create(f1);
    System.out.println("create foodcart restaurant: "+f1);

    // re* insert
    Recommendations recom1=new Recommendations(u1,r1);
    Recommendations recom2=new Recommendations(u1,r2);
    Recommendations recom3=new Recommendations(u2,r1);
    Recommendations recom4=new Recommendations(u1,r3);
    recommendatioinsDao.create(recom1);
    recommendatioinsDao.create(recom2);
    recommendatioinsDao.create(recom3);
    recommendatioinsDao.create(recom4);
    System.out.println("create recommendations: "+recom1);
    System.out.println("create recommendations: "+recom2);
    System.out.println("create recommendations: "+recom3);
    System.out.println("create recommendations: "+recom4);

    Reviews review1=new Reviews(timestamp,"1", 1.0F,u1,r1);
    reviewsDao.create(review1);

    Reservations res1=new Reservations(timestamp,timestamp,1,u1,s1);
    reservationsDao.create(res1);

    // get
    List<Restaurants> restaurants=restaurantsDao.getRestaurantsByCuisine(CuisineType.AFRICAN);
    System.out.println("getRestaurantsByCuisine - African");
    for(Restaurants r:restaurants){
      System.out.println(r);
    }

    List<Recommendations> recoms1=recommendatioinsDao.getRecommendationsByRestaurantId(r1.getRestaurantId());
    System.out.println("getRecommendationsByRestaurantId - r1");
    for(Recommendations r:recoms1){
      System.out.println(r);
    }

    List<Recommendations> recoms2=recommendatioinsDao.getRecommendationsByUserName(u1.getUserName());
    System.out.println("getRecommendationsByRestaurantId - u1");
    for(Recommendations r:recoms2){
      System.out.println(r);
    }



    // delete
    creditCardsDao.delete(card1);
    recommendatioinsDao.delete(recom1);
    recommendatioinsDao.delete(recom2);
    recommendatioinsDao.delete(recom3);
    recommendatioinsDao.delete(recom4);
    reviewsDao.delete(review1);
    reservationsDao.delete(res1);

    sitDownRestaurantsDao.delete(s1);
    takeOutRestaurantsDao.delete(t1);
    foodCartRestaurantsDao.delete(f1);

    restaurantsDao.delete(r1);
    restaurantsDao.delete(r2);
    restaurantsDao.delete(r3);

    usersDao.delete(u1);
    usersDao.delete(u2);

    companiesDao.delete(c1);

  }
}
