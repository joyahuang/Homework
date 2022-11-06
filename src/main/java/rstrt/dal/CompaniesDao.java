package rstrt.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rstrt.model.Companies;
import rstrt.model.CreditCards;

public class CompaniesDao {
  protected ConnectionManager connectionManager;
  private static CompaniesDao instance=null;
  protected CompaniesDao(){
    connectionManager=new ConnectionManager();
  }
  public static CompaniesDao getInstance(){
    if(instance==null){
      instance=new CompaniesDao();
    }
    return instance;
  }
  public Companies create(Companies company)throws SQLException{
    String insertOne="INSERT INTO Companies(CompanyName,About) VALUES(?,?)";
    Connection connection=null;
    PreparedStatement insertStmt=null;
    try{
      connection=connectionManager.getConnection();
      insertStmt=connection.prepareStatement(insertOne);
      insertStmt.setString(1,company.getCompanyName());
      insertStmt.setString(2,company.getAbout());
      insertStmt.executeUpdate();
      return company;
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
  public Companies getCompanyByCompanyName(String companyName)throws SQLException{
    String selectOne = "SELECT CompanyName,About FROM Companies WHERE CompanyName=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectOne);
      selectStmt.setString(1, companyName);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String about = results.getString("About");
        Companies company = new Companies(companyName,about);
        return company;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(selectStmt != null) {
        selectStmt.close();
      }
      if(results != null) {
        results.close();
      }
    }
    return null;
  }
  public Companies updateAbout(Companies company, String newAbout)throws SQLException{
    String updateOne="UPDATE Companies SET About=? WHERE CompanyName=?";
    Connection connection=null;
    PreparedStatement insertStmt=null;
    try{
      connection=connectionManager.getConnection();
      insertStmt=connection.prepareStatement(updateOne);
      insertStmt.setString(1,newAbout);
      insertStmt.setString(2,company.getCompanyName());
      insertStmt.executeUpdate();
      company.setAbout(newAbout);
      return company;
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
  public Companies delete(Companies company)throws SQLException{
    String deleteOne = "DELETE FROM Companies WHERE CompanyName=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteOne);
      deleteStmt.setString(1, company.getCompanyName());
      deleteStmt.executeUpdate();
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(deleteStmt != null) {
        deleteStmt.close();
      }
    }
  }

}
