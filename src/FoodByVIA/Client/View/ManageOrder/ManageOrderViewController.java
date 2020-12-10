package FoodByVIA.Client.View.ManageOrder;

import FoodByVIA.Client.Core.ViewHandler;
import FoodByVIA.Client.Core.ViewModelFactory;
import FoodByVIA.Client.View.ViewController;
import FoodByVIA.Shared.Order;
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
  }

  @FXML private void onSearch(ActionEvent actionEvent)
  {
    viewModel.clear();
    if(date.getValue() != null)
    {
      if (isActive.isSelected())
      {
        viewModel.search(true, date.getValue());
      }
      else
      {
        viewModel.search(false, date.getValue());
      }
    }
    else
    {
      messegeLabel.setText("Please select a date.");
    }
  }

  @FXML private void onCompleteOrder(ActionEvent actionEvent)
  {
    viewModel.completeOrder(allOrders.getSelectionModel().getSelectedItem());
  }
}
