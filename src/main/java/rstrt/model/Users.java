package rstrt.model;
/*
  UserName VARCHAR(255),
  Password VARCHAR(255) NOT NULL,
  FirstName VARCHAR(255) NOT NULL,
  LastName VARCHAR(255) NOT NULL,
  Email VARCHAR(255) NOT NULL,
  Phone VARCHAR(255),

 */
public class Users {
  protected String UserName;
  protected String Password;
  protected String FirstName;
  protected String LastName;
  protected String Email;
  protected String Phone;

  public Users(String userName, String password, String firstName, String lastName,
      String email, String phone) {
    UserName = userName;
    Password = password;
    FirstName = firstName;
    LastName = lastName;
    Email = email;
    Phone = phone;
  }

  public Users(String userName, String password, String firstName, String lastName,
      String email) {
    UserName = userName;
    Password = password;
    FirstName = firstName;
    LastName = lastName;
    Email = email;
  }

  public String getUserName() {
    return UserName;
  }

  public void setUserName(String userName) {
    UserName = userName;
  }

  public String getPassword() {
    return Password;
  }

  public void setPassword(String password) {
    Password = password;
  }

  public String getFirstName() {
    return FirstName;
  }

  public void setFirstName(String firstName) {
    FirstName = firstName;
  }

  public String getLastName() {
    return LastName;
  }

  public void setLastName(String lastName) {
    LastName = lastName;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }

  public String getPhone() {
    return Phone;
  }

  public void setPhone(String phone) {
    Phone = phone;
  }
}
