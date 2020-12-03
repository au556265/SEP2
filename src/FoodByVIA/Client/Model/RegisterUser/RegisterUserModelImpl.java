package FoodByVIA.Client.Model.RegisterUser;

import FoodByVIA.Client.Network.RegisterUser.RegisterUserClient;
import FoodByVIA.Shared.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RegisterUserModelImpl implements RegisterUserModel
{
  private RegisterUserClient client;
  private PropertyChangeSupport support;

  public RegisterUserModelImpl(RegisterUserClient client)
  {
    this.client = client;
    client.startClient();
    support = new PropertyChangeSupport(this);
    client.addPropertyChangeListener("RegisterMessage", this::throwMessage);
  }

  private void throwMessage(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }

  @Override public void addUser(User user)
  {
    client.addUser(user);
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
