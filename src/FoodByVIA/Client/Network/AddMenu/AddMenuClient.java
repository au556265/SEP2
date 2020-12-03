package FoodByVIA.Client.Network.AddMenu;
import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Util.PropertyChangeSubject;

public interface AddMenuClient extends PropertyChangeSubject
{
  void startClient();
  void addFoodItem(FoodItem createdItem);
}
