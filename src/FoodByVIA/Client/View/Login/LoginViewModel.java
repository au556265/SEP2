package FoodByVIA.Client.View.Login;

import FoodByVIA.Client.Model.Login.LoginModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class LoginViewModel
{
  private List<String> userType;
  private StringProperty username;
  private StringProperty password;
  private StringProperty message;
  private LoginModel loginModel;

  public LoginViewModel(LoginModel loginModel)
  {
    this.loginModel=loginModel;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    message = new SimpleStringProperty();

    userType = new ArrayList<>();
    userType.add("Administrator");
    userType.add("Employee");
    userType.add("Customer");
  }

  public StringProperty getUsername()
  {
    return username;
  }

  public StringProperty getPassword()
  {
    return password;
  }

  public StringProperty getMessage(){
    return message;
  }

  public List<String> getUserType()
  {
    return userType;
  }

  public boolean checkUserInput(String username, String password, String usertype)
  {
    return loginModel.checkUserInput(username, password, usertype);
  }

  public void clear()
  {
    username.setValue("");
    password.setValue("");
    message.setValue("");
  }
}
