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
  @FXML
  public TextField foodNameID;
  @FXML
  public TextField foodPriceID;
  @FXML
  public TextField foodDescriptionID;
  public Label messageField;

  private AddMenuViewModel addMenuViewModel;
  private ViewHandler vh;

  @FXML
  public void addMenuButton(ActionEvent actionEvent)
  {
    addMenuViewModel.addMenu();

  }

  @FXML
  public void cancelMenuButton(ActionEvent actionEvent)
  {
    addMenuViewModel.clear();
  }

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    addMenuViewModel = vmf.getAddMenuViewModel();
    this.vh = vh;
    StringConverter<Number> converter = new NumberStringConverter();
    foodNameID.textProperty().bindBidirectional(addMenuViewModel.getName());
    /*need a method that can change the binding from StringProperty to DoubleProperty*/
    foodPriceID.textProperty().bindBidirectional(addMenuViewModel.getPrice(),converter);
    foodDescriptionID.textProperty().bindBidirectional(addMenuViewModel.getDescription());
    messageField.textProperty().bindBidirectional(addMenuViewModel.getMessage());
  }
}
