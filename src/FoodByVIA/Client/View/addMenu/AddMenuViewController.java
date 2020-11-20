package FoodByVIA.Client.View.addMenu;

import FoodByVIA.Client.Core.ViewHandler;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class AddMenuViewController
{
  @FXML
  public TextField foodNameID;
  @FXML
  public TextField foodPriceID;
  @FXML
  public TextField foodDescriptionID;

  private AddMenuViewModel addMenuViewModel;
  private ViewHandler vh;

  public void init(ViewHandler vh, AddMenuViewModel addMenuViewModel)
  {
    this.addMenuViewModel=addMenuViewModel;
    this.vh=vh;
    StringConverter<Number> converter = new NumberStringConverter();
    foodNameID.textProperty().bindBidirectional(addMenuViewModel.getName());
    /*need a method that can change the binding from StringProperty to DoubleProperty*/
    foodPriceID.textProperty().bindBidirectional(addMenuViewModel.getPrice(),converter);
    foodDescriptionID.textProperty().bindBidirectional(addMenuViewModel.getDescription());
  }

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
}
