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
      userDAO.createUser(user);
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
    return userDAO.checkLogin(user.getUsername(), user.getPassword());
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
