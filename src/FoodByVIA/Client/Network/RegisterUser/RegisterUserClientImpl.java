package FoodByVIA.Client.Network.RegisterUser;

import FoodByVIA.Client.Network.NetworkConnection;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Network.RegisterUser.RegisterUserServer;
import FoodByVIA.Shared.User;
import FoodByVIA.Shared.Util.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RegisterUserClientImpl implements RegisterUserClient,
    MessageCallBack
{
  private NetworkConnection networkConnection;
  private RegisterUserServer registerUserServer;
  private PropertyChangeSupport support;

  public RegisterUserClientImpl()
  {
    networkConnection = NetworkConnection.getInstance();
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      registerUserServer = networkConnection.getServerInterface().getRegisterUserServerImpl();
      registerUserServer.registerClient(this);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error");
    }
  }

  @Override public void addUser(User user)
  {
    try
    {
      registerUserServer.addUser(user);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void getMessage(String message)
  {
    support.firePropertyChange("RegisterMessage", null, message);
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
