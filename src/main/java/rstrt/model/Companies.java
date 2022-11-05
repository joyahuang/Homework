package rstrt.model;
/*
  CompanyName VARCHAR(255),
  About VARCHAR(1024),

 */
public class Companies {
  protected String CompanyName;
  protected String About;

  public Companies(String companyName, String about) {
    CompanyName = companyName;
    About = about;
  }

  public Companies(String companyName) {
    CompanyName = companyName;
  }

  public String getCompanyName() {
    return CompanyName;
  }

  public void setCompanyName(String companyName) {
    CompanyName = companyName;
  }

  public String getAbout() {
    return About;
  }

  public void setAbout(String about) {
    About = about;
  }
}
