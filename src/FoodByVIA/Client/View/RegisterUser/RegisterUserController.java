package FoodByVIA.Client.View.RegisterUser;

import FoodByVIA.Client.Core.ViewHandler;
import FoodByVIA.Client.Core.ViewModelFactory;
import FoodByVIA.Client.View.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterUserController implements ViewController
{
  @FXML private ComboBox<String> userType;
  @FXML private TextField nameField;
  @FXML private TextField addressField;
  @FXML private TextField phoneNoField;
  @FXML private Label messageField;
  @FXML private TextField emailAddressField;
  @FXML private TextField usernameField;
  @FXML private TextField passwordField;
  @FXML private TextField confirmPasswordField;

  private ViewHandler vh;
  private RegisterUserViewModel registerUserViewModel;

  @FXML private void createAccountButton(ActionEvent actionEvent)
  {
    registerUserViewModel.createAccount();
  }

  @FXML private void cancelButton(ActionEvent actionEvent)
  {
    registerUserViewModel.clear();
    //vh.openToFrontPage;
  }

  @FXML private void clearButton(ActionEvent actionEvent)
  {
    registerUserViewModel.clear();
  }

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    registerUserViewModel = vmf.getRegisterUserViewModel();
    nameField.textProperty().bindBidirectional(registerUserViewModel.getName());
    addressField.textProperty().bindBidirectional(registerUserViewModel.getAddress());
    phoneNoField.textProperty().bindBidirectional(registerUserViewModel.getPhoneNumber());
    messageField.textProperty().bindBidirectional(registerUserViewModel.getMessage());
    emailAddressField.textProperty().bindBidirectional(registerUserViewModel.getEmailAddress());
    usernameField.textProperty().bindBidirectional(registerUserViewModel.getUsername());
    passwordField.textProperty().bindBidirectional(registerUserViewModel.getPassword());
    confirmPasswordField.textProperty().bindBidirectional(registerUserViewModel.getConfirmPassword());
    userType.getItems().addAll(registerUserViewModel.getUserType());
  }
}
