package FoodByVIA.Client.View.ManageOrder;

import FoodByVIA.Client.Core.ViewHandler;
import FoodByVIA.Client.Core.ViewModelFactory;
import FoodByVIA.Client.View.ViewController;
import FoodByVIA.Shared.Order;
import com.sun.javafx.beans.IDProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ManageOrderViewController implements ViewController
{
  @FXML private Label username;
  @FXML private Label messegeLabel;
  @FXML private DatePicker date;
  @FXML private CheckBox isActive;
  @FXML private ListView<Order> allOrders;

  private ManageOrderViewModel viewModel;
  private ViewHandler vh;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    viewModel = vmf.getManageOrderViewModel();

    username.textProperty().bind(viewModel.getusername());
    messegeLabel.textProperty().bindBidirectional(viewModel.getMessage());
    allOrders.setItems(viewModel.getOrders());
  }

  @FXML private void onLogout(ActionEvent actionEvent)
  {
    viewModel.logout();
    viewModel.clear();
    messegeLabel.setText("");
    date.setValue(null);
    vh.openToLoginView();
  }

  @FXML private void onSearch(ActionEvent actionEvent)
  {
    if(date.getValue() != null)
    {
      viewModel.search(isActive.isSelected(), date.getValue());
    }
    else
    {
      messegeLabel.setText("Please select a date.");
    }
  }

  @FXML private void onCompleteOrder(ActionEvent actionEvent)
  {
    if(allOrders.getSelectionModel().getSelectedItem() == null)
    {
      messegeLabel.setText("Please select the item");
    }
    else
    viewModel.completeOrder(allOrders.getSelectionModel().getSelectedItem());
  }

  @FXML private void onMakeOrder(ActionEvent actionEvent)
  {
    vh.openToSelectOrderScene();
  }
}
