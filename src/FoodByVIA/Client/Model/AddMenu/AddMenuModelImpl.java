package FoodByVIA.Client.Model.AddMenu;

import FoodByVIA.Client.Network.AddMenu.AddMenu.AddMenuClient;
import FoodByVIA.Shared.FoodItem;

public class AddMenuModelImpl implements AddMenuModel
{
  private AddMenuClient client;
  public AddMenuModelImpl(AddMenuClient client) {
    this.client=client;
  }


  @Override public void addFoodItem(String name, double price,
      String description)
  {
    FoodItem item = new FoodItem(name, price, description);
   client.addFoodItem(item);
  }
}
