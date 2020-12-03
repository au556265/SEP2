package FoodByVIA.Client.Model.AddMenu;

import FoodByVIA.Shared.Util.PropertyChangeSubject;

public interface AddMenuModel extends PropertyChangeSubject
{
  void addFoodItem(String name, double price, String description);
}
