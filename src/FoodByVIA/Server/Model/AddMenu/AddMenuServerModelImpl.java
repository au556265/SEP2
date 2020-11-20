package FoodByVIA.Server.Model.AddMenu;

import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Menu;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddMenuServerModelImpl implements AddMenuServerModel
{
  private Menu menu;
  private PropertyChangeSupport support;

  public AddMenuServerModelImpl()
  {
    menu = Menu.getInstance();
    support = new PropertyChangeSupport(this);
  }

  @Override public void addFoodItem(FoodItem item)
  {
    menu.addFoodItem(item);
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
