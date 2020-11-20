package FoodByVIA.Shared;

import java.util.ArrayList;

public class Menu extends FoodItem
{
  ArrayList<FoodItem> Menu;
  void addFoodItem(FoodItem item)
  {
      Menu.add(item);
  }

  String getMenu;
}
