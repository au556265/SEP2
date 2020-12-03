package FoodByVIA.Client.Model.Login;

import FoodByVIA.Client.Network.Login.LoginClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginModelImpl implements LoginModel
{
  private LoginClient loginClient;
  private PropertyChangeSupport support;

  public LoginModelImpl(LoginClient loginClient){
    this.loginClient=loginClient;
    loginClient.startClient();
    support = new PropertyChangeSupport(this);
    loginClient.addPropertyChangeListener("LoginMessage", this::addMessage);
  }

  private void addMessage(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }

  @Override public boolean checkUserInput(String username, String password,
      String usertype)
  {
    return loginClient.checkUserInput(username, password, usertype);
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
