package FoodByVIA.Client.View.Login;

import FoodByVIA.Client.Model.Login.LoginModel;
import FoodByVIA.Shared.Catalogue;
import FoodByVIA.Shared.User;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
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

    loginModel.addPropertyChangeListener("LoginMessage", this::addMessage);
  }

  private void addMessage(PropertyChangeEvent evt)
  {
    String messageFromServer = (String) evt.getNewValue();
    Platform.runLater(() -> message.setValue(messageFromServer));
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
    if(loginModel.checkUserInput(username, password, usertype))
    {
      Catalogue catalogue = Catalogue.getInstance();
      User user = new User(username, usertype);
      catalogue.saveCurrentUser(user);
      clear();
    }
    return loginModel.checkUserInput(username, password, usertype);
  }

  public void clear()
  {
    username.setValue("");
    password.setValue("");
    message.setValue("");
  }
}
