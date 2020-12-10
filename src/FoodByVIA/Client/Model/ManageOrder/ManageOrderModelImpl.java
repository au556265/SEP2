package FoodByVIA.Client.Model.ManageOrder;

import FoodByVIA.Client.Network.ManageOrder.ManageOrderClient;
import FoodByVIA.Shared.Order;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;

public class ManageOrderModelImpl implements ManageOrderModel
{
  private PropertyChangeSupport support;
  private ManageOrderClient client;
  public ManageOrderModelImpl(ManageOrderClient client)
  {
    this.client = client;
    client.startClient();
    support= new PropertyChangeSupport(this);
  }

  @Override public void search(boolean isActive, LocalDate date)
  {
    client.search(isActive,date);
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
