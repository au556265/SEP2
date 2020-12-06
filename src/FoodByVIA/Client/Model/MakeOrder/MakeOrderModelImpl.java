package FoodByVIA.Client.Model.MakeOrder;

import FoodByVIA.Client.Network.MakeOrder.MakeOrderClient;
import FoodByVIA.Shared.Order;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MakeOrderModelImpl implements MakeOrderModel
{
  private MakeOrderClient client;
  private PropertyChangeSupport support;

  public MakeOrderModelImpl(MakeOrderClient client)
  {
    this.client = client;
    client.startClient();
    support = new PropertyChangeSupport(this);
    client.addPropertyChangeListener("OrderNumber", this::addOrderNumber);
    client.addPropertyChangeListener("FoodItems", this::addItem);
  }

  private void addItem(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }

  private void addOrderNumber(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }

  @Override public void createOrder(Order order)
  {
    client.createOrder(order);
  }

  @Override public void showMenu()
  {
    client.showMenu();
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
