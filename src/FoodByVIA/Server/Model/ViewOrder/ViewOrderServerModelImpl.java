package FoodByVIA.Server.Model.ViewOrder;

import FoodByVIA.DAO.Persistance.Order.OrderDAO;
import FoodByVIA.Shared.Order;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.util.ArrayList;

public class ViewOrderServerModelImpl implements ViewOrderServerModel
{
  private OrderDAO orderDAO;
  private PropertyChangeSupport support;

  public ViewOrderServerModelImpl(OrderDAO orderDAO)
  {
    this.orderDAO = orderDAO;
    support = new PropertyChangeSupport(this);
  }

  @Override public void getAllOrders(Boolean isActive, LocalDate localDate)
  {
    ArrayList<Order> allActiveOrders = orderDAO.getAllActiveOrders(isActive,localDate);
    support.firePropertyChange("AllOrders",null,allActiveOrders);
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
