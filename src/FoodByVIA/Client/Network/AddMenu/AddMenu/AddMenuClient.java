package FoodByVIA.Client.Network.AddMenu.AddMenu;
import FoodByVIA.Shared.FoodItem;
public interface AddMenuClient
{
  String AddItem(FoodItem createdItem);
  boolean testConnection();

}
