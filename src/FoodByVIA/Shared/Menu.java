package FoodByVIA.Shared;

import java.util.ArrayList;

public class Menu extends FoodItem
{
  ArrayList<FoodItem> Menu;

  public Menu(String name, double price, String description)
  {
    super(name, price, description);
  }

  void addFoodItem(FoodItem item)
  {
      Menu.add(item);
  }

  String getMenu;
}
