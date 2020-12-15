package FoodByVIA.Shared;

import java.io.Serializable;

public class User implements Serializable
{
  private String username;
  private String password;
  private String name;
  private String address;
  private String phoneNumber;
  private String emailAddress;
  private String userType;

  public User(String name, String address, String phoneNumber, String emailAddress, String username, String password, String userType)
  {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
    this.username = username;
    this.password = password;
    this.userType = userType;
  }

  public User(String username, String usertype)
  {
    this.username = username;
    userType = usertype;
  }

  public void set(String address, String phoneNumber, String emailAddress, String password)
  {
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
    this.password = password;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  public String getName()
  {
    return name;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public String getAddress()
  {
    return address;
  }

  public String getEmail()
  {
    return emailAddress;
  }

  public String getUserType()
  {
    return userType;
  }

  public String toString()
  {
    return name + "  " + address + "  " + username;
  }
}
