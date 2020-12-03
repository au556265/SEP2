package FoodByVIA.Client.Network.Login;

import FoodByVIA.Client.Network.NetworkConnection;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Network.Login.LoginServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginClientImpl implements LoginClient, MessageCallBack
{
  private LoginServer loginServer;
  private NetworkConnection networkConnection;
  private PropertyChangeSupport support;

  public LoginClientImpl()
  {
    networkConnection = NetworkConnection.getInstance();
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      loginServer = networkConnection.getServerInterface().getLoginServerImpl();
      loginServer.registerClient(this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public boolean checkUserInput(String username, String password,
      String usertype)
  {
    try
    {
      return loginServer.checkUserInput(username,password,usertype);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not contact to Server");
    }
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

  @Override public void getMessage(String message)
  {
    support.firePropertyChange("LoginMessage", null, message);
  }
}
