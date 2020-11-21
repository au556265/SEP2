package FoodByVIA.Client.Network.AddMenu;

import FoodByVIA.Shared.Util.PropertyChangeSubject;

public interface AddMenuClient extends PropertyChangeSubject
{
  void addFoodItem(String name, double price, String description);
}
