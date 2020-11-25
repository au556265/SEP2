package FoodByVIA.Shared;

import java.util.ArrayList;

public class User
{
  String username;
  String password;
  String name;
  String userType;
  String phoneNumber;
  String address;
  String email;

  public User(String username, String password, String name, String userType, String phoneNumber, String address, String email)
  {
    this.username = username;
    this.password = password;
    this.name = name;
    this.userType = userType;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.email = email;
  }

  public String getUserType()
  {
    return userType;
  }

  public void setUserType(String userType)
  {
    this.userType = userType;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  @Override public String toString()
  {
    return "User{" + "username='" + username + '\'' + ", password='" + password
        + '\'' + ", name='" + name + '\'' + ", userType='" + userType + '\''
        + ", phoneNumber=" + phoneNumber + ", address='" + address + '\''
        + ", email='" + email + '\'' + '}';
  }
}
