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
  private LocalDate date;

  public ManageOrderServerModelImpl(OrderDAO orderDAO)
  {
    this.orderDAO = orderDAO;
    this.date = LocalDate.now();
    support = new PropertyChangeSupport(this);
    ArrayList<Order> allOrders = orderDAO.getAllActiveOrders(true, date);
    if(allOrders.size() == 0)
    {
      support.firePropertyChange("ViewOrderMessage", null, "There is no order");
    }
    else
    {
      support.firePropertyChange("CurrentOrder", null, allOrders);
    }
  }

  @Override public void search(boolean isActive, LocalDate date)
  {
    ArrayList<Order> allOrders = orderDAO.getAllActiveOrders(isActive, date);
    if(allOrders.size() == 0)
    {
      support.firePropertyChange("ViewOrderMessage", null, "There is no order");
    }
    else
    {
      support.firePropertyChange("AllOrders", null, allOrders);
    }
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
