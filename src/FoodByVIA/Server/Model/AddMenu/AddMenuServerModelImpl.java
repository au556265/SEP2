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
  private PropertyChangeSupport support;

  public AddMenuServerModelImpl(FoodItemDAO foodItemDAO)
  {
    this.foodItemDAO = foodItemDAO ;
    support = new PropertyChangeSupport(this);
  }

  @Override public void addFoodItem(FoodItem item)
  {
    foodItemDAO.addMenu(item);
    support.firePropertyChange("NewFoodItem", null, item);
    System.out.println(item.getName() + " Added");
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
