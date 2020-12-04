package FoodByVIA.Server.Model.Login;

import FoodByVIA.DAO.Persistance.User.UserDAO;
import FoodByVIA.Shared.Catalogue;
import FoodByVIA.Shared.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginServerModelImpl implements LoginServerModel
{
  private UserDAO userDAO;
  private PropertyChangeSupport support;

  public LoginServerModelImpl(UserDAO userDAO)
  {
    this.userDAO = userDAO;
    support = new PropertyChangeSupport(this);
  }

  @Override public boolean checkUserInput(String username, String password,
      String usertype)
  {
    if(!(userDAO.checkLogin(username, password, usertype)))
    {
      support.firePropertyChange("LoginMessage", null, "Incorrect username or password or usertype");
    }
    return userDAO.checkLogin(username, password, usertype);
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
