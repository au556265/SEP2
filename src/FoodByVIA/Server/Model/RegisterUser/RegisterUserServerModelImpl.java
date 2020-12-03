package FoodByVIA.Server.Model.RegisterUser;

import FoodByVIA.DAO.Persistance.User.UserDAO;
import FoodByVIA.Shared.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class RegisterUserServerModelImpl implements RegisterUserServerModel
{
  private UserDAO userDAO;
  private PropertyChangeSupport support;

  public RegisterUserServerModelImpl(UserDAO userDAO)
  {
    this.userDAO = userDAO;
    support = new PropertyChangeSupport(this);
  }

  @Override public void addUser(User user)
  {
    if(!(checkAvailableUser(user)))
    {
      userDAO.createUser(user);
      System.out.println(user + " Added");
      support.firePropertyChange("RegisterMessage", null, "Account created");
    }
    else
    {
      System.out.println("Account not created");
      support.firePropertyChange("RegisterMessage", null, "Use a different Username");
    }
  }

  private boolean checkAvailableUser(User user)
  {
    ArrayList<User> users = userDAO.getAllUsers();
    boolean bool = false;
    for (User existing : users)
    {
      if(existing.getUsername().equalsIgnoreCase(user.getUsername()))
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
