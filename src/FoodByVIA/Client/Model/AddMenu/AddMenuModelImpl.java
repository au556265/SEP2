package FoodByVIA.Client.Model.AddMenu;

import FoodByVIA.Client.Network.AddMenu.AddMenuClient;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddMenuModelImpl implements AddMenuModel
{
  private AddMenuClient client;
  public AddMenuModelImpl(AddMenuClient client) {
    this.client=client;
  }


  @Override public void addFoodItem(String name, double price,
      String description)
  {
   client.addFoodItem(name,price,description);
  }
}
