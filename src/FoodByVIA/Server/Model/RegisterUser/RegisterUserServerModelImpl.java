package FoodByVIA.Server.Model.RegisterUser;

import FoodByVIA.Persistance.User.UserDAO;
import FoodByVIA.Shared.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class RegisterUserServerModelImpl implements RegisterUserServerModel
{
  private UserDAO userDAO;
  private List<User> users;
  private PropertyChangeSupport support;

  public RegisterUserServerModelImpl(UserDAO userDAO)
  {
    this.userDAO = userDAO;
    users = new ArrayList<>();
    support = new PropertyChangeSupport(this);
  }

  @Override public void addUser(User user)
  {
    if(!(checkAvailableUser(user)))
    {
      userDAO.addUser(user);
      users.add(user);
      System.out.println(user + " Added");
      support.firePropertyChange("NewUser", null, user);
    }
    else
    {
      System.out.println("Account not created");
    }
  }

  private boolean checkAvailableUser(User user)
  {
    boolean bool = false;
    for(User u : users)
    {
      if(u.getUsername().equals(user.getUsername()))
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
