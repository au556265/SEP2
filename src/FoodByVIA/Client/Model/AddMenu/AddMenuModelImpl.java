package FoodByVIA.Client.Model.AddMenu;

import FoodByVIA.Client.Network.AddMenu.AddMenuClient;
import FoodByVIA.Shared.FoodItem;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddMenuModelImpl implements AddMenuModel
{
  private AddMenuClient client;
  private PropertyChangeSupport support;

  public AddMenuModelImpl(AddMenuClient client) {
    this.client=client;
    client.startClient();
    support = new PropertyChangeSupport(this);
    client.addPropertyChangeListener("AddMenuMessage", this::throwMessage);
  }

  private void throwMessage(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }

  @Override public void addFoodItem(String name, double price,
      String description)
  {
    FoodItem item = new FoodItem(name, price, description);
    client.addFoodItem(item);
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
