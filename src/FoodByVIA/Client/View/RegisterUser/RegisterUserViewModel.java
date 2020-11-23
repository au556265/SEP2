package FoodByVIA.Client.View.RegisterUser;

import FoodByVIA.Client.Model.RegisterUser.RegisterUserModel;
import FoodByVIA.Shared.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class RegisterUserViewModel
{
  private List<String> userType;
  private StringProperty name;
  private StringProperty address;
  private StringProperty phoneNumber;
  private StringProperty emailAddress;
  private StringProperty username;
  private StringProperty password;
  private StringProperty confirmPassword;
  private StringProperty message;
  private RegisterUserModel registerUserModel;


  public RegisterUserViewModel(RegisterUserModel registerUserModel)
  {
    this.registerUserModel = registerUserModel;
    name = new SimpleStringProperty();
    address = new SimpleStringProperty();
    phoneNumber = new SimpleStringProperty();
    emailAddress = new SimpleStringProperty();
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    message = new SimpleStringProperty();
    userType = new ArrayList<>();
    userType.add("Employee");
    userType.add("Customer");
    confirmPassword = new SimpleStringProperty();
  }

  public void createAccount()
  {
    if(name.getValue().equals("") || address.getValue().equals("") || phoneNumber.getValue().equals("") ||
        username.getValue().equals("") || password.getValue().equals("") || confirmPassword.getValue().equals(""))
    {
      message.setValue("Required fields cannot be empty");
    }
    else if(!(password.getValue().equals(confirmPassword.getValue())))
    {
      message.setValue("Password not matched");
    }
    else
    {
      User user = new User(name.getValue(), address.getValue(), phoneNumber.getValue(),
          emailAddress.getValue(), username.getValue(), password.getValue(), userType.get(0));
      registerUserModel.addUser(user);
      message.setValue("Account created");

      clear();
    }
  }

  public void clear()
  {
    name.setValue("");
    address.setValue("");
    phoneNumber.setValue("");
    emailAddress.setValue("");
    username.setValue("");
    password.setValue("");
    confirmPassword.setValue("");
  }

  public StringProperty getName()
  {
    return name;
  }

  public StringProperty getAddress()
  {
    return address;
  }

  public StringProperty getPhoneNumber()
  {
    return phoneNumber;
  }

  public StringProperty getMessage()
  {
    return message;
  }

  public StringProperty getEmailAddress()
  {
    return emailAddress;
  }

  public StringProperty getUsername()
  {
    return username;
  }

  public StringProperty getPassword()
  {
    return password;
  }

  public StringProperty getConfirmPassword()
  {
    return confirmPassword;
  }

  public List<String> getUserType()
  {
    return userType;
  }
}
