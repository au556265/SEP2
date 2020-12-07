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

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

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
    LocalDate currentDate = LocalDate.now();
    if(datePicker.getValue() == null)
    {
      messageField.setText("Please select a date");
    }
    else if(selectedItem.getItems().size() == 0)
    {
      messageField.setText("Please select from the menu. You have to double click on Show Menu to see the menu. :)");
    }
    else if(datePicker.getValue().isBefore(currentDate) || datePicker.getValue().isEqual(currentDate))
    {
      messageField.setText("You cannot order in selected date");
    }
    else
    {
      makeOrderViewModel.createOrder(datePicker.getValue(), selectedItem.getItems());
    }
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
