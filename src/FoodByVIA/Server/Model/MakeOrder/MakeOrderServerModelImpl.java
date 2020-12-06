package FoodByVIA.Server.Model.MakeOrder;

import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDAO;
import FoodByVIA.DAO.Persistance.Order.OrderDAO;
import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Order;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class MakeOrderServerModelImpl implements MakeOrderServerModel
{
  private OrderDAO orderDAO;
  private FoodItemDAO foodItemDAO;
  private PropertyChangeSupport support;

  public MakeOrderServerModelImpl(OrderDAO orderDAO, FoodItemDAO foodItemDAO)
  {
    this.orderDAO = orderDAO;
    this.foodItemDAO = foodItemDAO;
    support = new PropertyChangeSupport(this);
  }

  @Override public void createOrder(Order order)
  {
    //ToDo get all the list of orders for the day and validate the number of order
    orderDAO.createOrder(order);
    support.firePropertyChange("OrderNumber", null, "Your order number is " + order.getOrdernumber());
  }

  @Override public void showMenu()
  {
    support.firePropertyChange("FoodItems", null, foodItemDAO.getAllFoodItems());
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name,listener);
  }

  @Override public void removerPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }
}
