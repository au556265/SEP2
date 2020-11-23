package FoodByVIA.Server.Model.AddMenu;

import FoodByVIA.DAO.Persistance.FoodItemDAO;
import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Menu;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class AddMenuServerModelImpl implements AddMenuServerModel
{
  private FoodItemDAO foodItemDAO;
  private List<FoodItem> items;
  private PropertyChangeSupport support;

  public AddMenuServerModelImpl(FoodItemDAO foodItemDAO)
  {
    this.foodItemDAO = foodItemDAO ;
    items = new ArrayList<>();
    support = new PropertyChangeSupport(this);
  }

  @Override public void addFoodItem(FoodItem item)
  {
    if(!(checkFoodItem(item)))
    {
      foodItemDAO.addMenu(item);
      items.add(item);
      support.firePropertyChange("NewFoodItem", null, item);
      System.out.println(item.getName() + " Added");
    }
    else
    {
      System.out.println("Item name matched");
    }
  }

  private boolean checkFoodItem(FoodItem item)
  {
    boolean bool = false;
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
