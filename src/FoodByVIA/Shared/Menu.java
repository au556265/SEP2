package FoodByVIA.Shared;

import java.util.ArrayList;
import java.util.List;

public class Menu
{
  private List<FoodItem> items;
  private int size;
  private static Menu instance;

  private Menu()
  {
    items = new ArrayList<>();
  }

  public static Menu getInstance()
  {
    if(instance == null)
    {
      instance = new Menu();
    }
    return instance;
  }

  public void addFoodItem(FoodItem item)
  {
    items.add(item);
    size++;
  }

  public void removeItem(FoodItem item)
  {
    items.remove(item);
    size--;
  }

  public int getSize()
  {
    return size;
  }

  public FoodItem getItem(String name)
  {
    FoodItem result = null;
    for(FoodItem item : items)
    {
      if(item.getName().equals(name))
      {
        result = item;
        break;
      }
    }
    return result;
  }

  public String toString()
  {
    String result = "";
    for (FoodItem item : items)
    {
      result += item + "\n";
    }
    return result;
  }
}
