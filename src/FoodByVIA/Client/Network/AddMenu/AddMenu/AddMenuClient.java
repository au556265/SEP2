package FoodByVIA.Client.Network.AddMenu.AddMenu;
import FoodByVIA.Shared.FoodItem;
public interface AddMenuClient
{
  void startClient();
  void addFoodItem(FoodItem createdItem);
}
