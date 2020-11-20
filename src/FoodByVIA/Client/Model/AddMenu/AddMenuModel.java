package FoodByVIA.Client.Model.AddMenu;

import FoodByVIA.Shared.Util.PropertyChangeSubject;

public interface AddMenuModel
{
  void addFoodItem(String name, double price, String description);
}
