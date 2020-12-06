package FoodByVIA.Client.View.addMenu;

import FoodByVIA.Client.Core.ViewHandler;
import FoodByVIA.Client.Core.ViewModelFactory;
import FoodByVIA.Client.View.ViewController;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class AddMenuViewController implements ViewController
{
  @FXML private TextField foodNameID;
  @FXML private TextField foodPriceID;
  @FXML private TextField foodDescriptionID;
  @FXML private Label messageField;
  @FXML private Label username;

  private AddMenuViewModel addMenuViewModel;
  private ViewHandler vh;

  @FXML
  private void addMenuButton(ActionEvent actionEvent)
  {
    addMenuViewModel.addMenu();
  }

  @FXML
  private void cancelMenuButton(ActionEvent actionEvent)
  {
    addMenuViewModel.clear();
  }

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    addMenuViewModel = vmf.getAddMenuViewModel();
    this.vh = vh;
    StringConverter<Number> converter = new NumberStringConverter();
    foodNameID.textProperty().bindBidirectional(addMenuViewModel.getName());
    foodPriceID.textProperty().bindBidirectional(addMenuViewModel.getPrice(),converter);
    foodDescriptionID.textProperty().bindBidirectional(addMenuViewModel.getDescription());
    messageField.textProperty().bindBidirectional(addMenuViewModel.getMessage());
    username.textProperty().bindBidirectional(addMenuViewModel.getUsername());
  }

  @FXML private void onLogout(ActionEvent actionEvent)
  {
    addMenuViewModel.logOut();
    vh.openToLoginView();
  }

  @FXML private void onMakeOrder(ActionEvent actionEvent)
  {
    vh.openToSelectOrderScene();
  }
}
