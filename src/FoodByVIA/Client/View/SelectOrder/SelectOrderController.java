package FoodByVIA.Client.View.SelectOrder;

import FoodByVIA.Client.Core.ViewHandler;
import FoodByVIA.Client.Core.ViewModelFactory;
import FoodByVIA.Client.View.ViewController;
import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class SelectOrderController implements ViewController
{
  @FXML private Label messageField;
  @FXML private TextField totalPrice;
  @FXML private Label username;
  @FXML private ListView<FoodItem> menu;
  @FXML private ComboBox<FoodItem> selectedItem;
  @FXML private DatePicker datePicker;

  private MakeOrderViewModel makeOrderViewModel;
  private ViewHandler vh;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    makeOrderViewModel = vmf.getSelectOrderViewModel();

    StringConverter<Number> converter = new NumberStringConverter();
    messageField.textProperty().bindBidirectional(makeOrderViewModel.getMessage());
    username.textProperty().bindBidirectional(makeOrderViewModel.getUser());
    menu.setItems(makeOrderViewModel.getMenu());
    totalPrice.textProperty().bindBidirectional(makeOrderViewModel.getTotalPrice(), converter);
  }

  @FXML private void addItemButton(ActionEvent actionEvent)
  {
    FoodItem foodItem = menu.getSelectionModel().getSelectedItem();
    selectedItem.getItems().add(foodItem);
    makeOrderViewModel.addToTotalPrice(foodItem);
  }

  @FXML private void bookTableButton(ActionEvent actionEvent)
  {
    vh.openToTableReservation();
  }

  @FXML private void orderTakeawayButton(ActionEvent actionEvent)
  {
    makeOrderViewModel.createOrder(datePicker.getValue(), selectedItem.getItems());
  }

  @FXML private void onLogout(ActionEvent actionEvent)
  {
    makeOrderViewModel.logout();
    vh.openToLoginView();
  }

  @FXML private void onShowMenu(ActionEvent actionEvent)
  {
    makeOrderViewModel.showMenu();
  }
}
