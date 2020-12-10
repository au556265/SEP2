package FoodByVIA.Client.View.ManageOrder;

import FoodByVIA.Client.Model.ManageOrder.ManageOrderModel;
import FoodByVIA.Shared.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ManageOrderViewModel
{
  private ArrayList<Order> orders;
  private ManageOrderModel model;
  public ManageOrderViewModel(ManageOrderModel model)
  {
    this.model=model;
    orders = new ArrayList<>();


  }



  public List<Order> getOrders()
  {
    return orders;
  }
}
