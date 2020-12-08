package FoodByVIA.Client.View.Login;

import FoodByVIA.Client.Core.ViewHandler;
import FoodByVIA.Client.Core.ViewModelFactory;
import FoodByVIA.Client.View.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;

public class LoginViewController implements ViewController
{
  @FXML private Label messageLabel;
  @FXML private ComboBox<String> usertypeID;
  @FXML private TextField passwordField;
  @FXML private TextField usernameField;
  private ViewHandler vh;
  private LoginViewModel loginViewModel;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh=vh;
    loginViewModel = vmf.getLoginViewModel();
    usernameField.textProperty().bindBidirectional(loginViewModel.getUsername());
    passwordField.textProperty().bindBidirectional(loginViewModel.getPassword());
    messageLabel.textProperty().bindBidirectional(loginViewModel.getMessage());
    usertypeID.getItems().addAll(loginViewModel.getUserType());
  }

  @FXML private void loginButton(ActionEvent actionEvent){
    if(loginViewModel.checkUserInput(usernameField.getText(), passwordField.getText(),
        usertypeID.getSelectionModel().getSelectedItem()))
    {
      if(usertypeID.getSelectionModel().getSelectedItem().equalsIgnoreCase("Administrator"))
      {
        vh.openAddMenuView();
      }
      else if(usertypeID.getSelectionModel().getSelectedItem().equalsIgnoreCase("Employee")){
      }  else if(usertypeID.getSelectionModel().getSelectedItem().equalsIgnoreCase("Customer")){
        vh.openToSelectOrderScene();
      }
      else{
        System.out.println("invalid user, please choose a usertype");
        messageLabel.setText("Invalid user");
      }
      messageLabel.setText("");
    }
    else
    {
      messageLabel.setText("Incorrect username or password or usertype not matched");
    }
  }

  @FXML private void registerButton(ActionEvent actionEvent)
  {
    vh.openRegisterUserView();
  }



  @FXML private void onCancel(ActionEvent actionEvent)
  {
    loginViewModel.clear();
  }
}
