package FoodByVIA.Server.Model.AddMenu;

import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDAO;
import FoodByVIA.Shared.FoodItem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class AddMenuServerModelImpl implements AddMenuServerModel
{
  private FoodItemDAO foodItemDAO;
  private PropertyChangeSupport support;

  public AddMenuServerModelImpl(FoodItemDAO foodItemDAO)
  {
    this.foodItemDAO = foodItemDAO ;
    support = new PropertyChangeSupport(this);
  }

  @Override public void addFoodItem(FoodItem item)
  {
    if(!(checkFoodItem(item)))
    {
      foodItemDAO.addMenu(item);
      System.out.println(item.getName() + " Added");
      support.firePropertyChange("AddMenuMessage", null, "Item Added");
    }
    else
    {
      System.out.println("Item name matched");
      support.firePropertyChange("AddMenuMessage", null, "Use different item name");
    }
  }

  /*@Override public String addFoodItem(FoodItem item)
  {
    if(!(checkFoodItem(item)))
    {
      foodItemDAO.addMenu(item);
      System.out.println(item.getName() + " Added");
      return "Item added";
    }
    else
    {
      System.out.println("Item name matched");
      return "Item name matched";
    }
  }*/

  private boolean checkFoodItem(FoodItem item)
  {
    boolean bool = false;
    ArrayList<FoodItem> items = foodItemDAO.getAllFoodItems();
    for(FoodItem foodItem : items)
    {
      if(foodItem.getName().equals(item.getName()))
      {
        bool = true;
        break;
      }
    }
    return bool;
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void removerPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }
}
