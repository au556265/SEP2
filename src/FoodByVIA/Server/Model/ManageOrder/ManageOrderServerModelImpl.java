package FoodByVIA.Server.Model.ManageOrder;

import FoodByVIA.DAO.Persistance.Order.OrderDAO;
import FoodByVIA.Shared.Order;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManageOrderServerModelImpl implements ManageOrderServerModel
{
  private OrderDAO orderDAO;
  private PropertyChangeSupport support;

  public ManageOrderServerModelImpl(OrderDAO orderDAO)
  {
    this.orderDAO = orderDAO;
    support = new PropertyChangeSupport(this);
  }

  @Override public void search(boolean isActive, LocalDate date)
  {
    ArrayList<Order> allOrders = orderDAO.getAllActiveOrders(isActive, date);
    support.firePropertyChange("AllOrders",null, allOrders);
  }

  @Override public void completeOrder(Order order)
  {
    orderDAO.completeOrder(order);
    support.firePropertyChange("CompleteOrder", null, "Order marked as completed");
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void removerPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }
}
