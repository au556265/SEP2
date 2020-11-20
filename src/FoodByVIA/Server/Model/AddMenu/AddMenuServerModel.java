package FoodByVIA.Server.Model.AddMenu;

import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Util.PropertyChangeSubject;

public interface AddMenuServerModel extends PropertyChangeSubject
{
  void addFoodItem(FoodItem item);
}
