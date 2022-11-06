package rstrt.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import rstrt.model.Restaurants;
import rstrt.model.SitDownRestaurants;

public class SitDownRestaurantsDao {
  protected ConnectionManager connectionManager;
  private static SitDownRestaurantsDao instance=null;
  protected SitDownRestaurantsDao(){
    connectionManager=new ConnectionManager();
  }
  public static SitDownRestaurantsDao getInstance(){
    if(instance==null){
      instance=new SitDownRestaurantsDao();
    }
    return instance;
  }
  public SitDownRestaurants create(SitDownRestaurants sitDownRestaurant)throws SQLException{
    RestaurantsDao.getInstance().create(new Restaurants(sitDownRestaurant.getRestaurantId(),
        sitDownRestaurant.getName(),
        sitDownRestaurant.getDescription(),
        sitDownRestaurant.getMenu(),
        sitDownRestaurant.getHours(),
        sitDownRestaurant.getActive(),
        sitDownRestaurant.getCuisineType(),
        sitDownRestaurant.getStreet1(),
        sitDownRestaurant.getStreet2(),
        sitDownRestaurant.getCity(),
        sitDownRestaurant.getState(),
        sitDownRestaurant.getZip(),
        sitDownRestaurant.getCompanyName()));
    String insertOne="INSERT INTO SitDownRestaurants(RestaurantId,Capacity) VALUES(?,?)";
    Connection connection=null;
    PreparedStatement insertStmt=null;
    try{
      connection=connectionManager.getConnection();
      insertStmt=connection.prepareStatement(insertOne);
      insertStmt.setInt(1,sitDownRestaurant.getRestaurantId());
      insertStmt.setInt(2,sitDownRestaurant.getCapacity());
      insertStmt.executeUpdate();
      return sitDownRestaurant;
    }catch (SQLException e){
      e.printStackTrace();
      throw e;
    }finally {
      if(connection!=null){
        connection.close();
      }
      if(insertStmt!=null){
        insertStmt.close();
      }
    }
  }
  public SitDownRestaurants getSitDownRestaurantById(int sitDownRestaurantId)throws SQLException{

  }
  public List<SitDownRestaurants> getSitDownRestaurantsByCompanyName(String companyName)throws SQLException
  public SitDownRestaurants delete(SitDownRestaurants sitDownRestaurant)throws SQLException

}
