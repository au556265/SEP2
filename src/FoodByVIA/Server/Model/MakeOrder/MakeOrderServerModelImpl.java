package FoodByVIA.Server.Model.MakeOrder;

import FoodByVIA.DAO.Persistance.Order.OrderDAO;
import FoodByVIA.Shared.Order;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MakeOrderServerModelImpl implements MakeOrderServerModel
{
  private OrderDAO orderDAO;
  private PropertyChangeSupport support;

  public MakeOrderServerModelImpl(OrderDAO orderDAO)
  {
    this.orderDAO = orderDAO;
    support = new PropertyChangeSupport(this);
  }

  @Override public void createOrder(Order order)
  {
    //ToDo validate
    orderDAO.createOrder(order);
    support.firePropertyChange("OrderNumber", null, order.getOrdernumber());
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
