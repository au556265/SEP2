package FoodByVIA.Client.Network.AddMenu;

import FoodByVIA.Client.Network.NetworkConnection;
import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Network.AddMenu.AddMenuServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddMenuClientImpl implements AddMenuClient, MessageCallBack
{
  private AddMenuServer addMenuServer;
  private NetworkConnection networkConnection;
  private PropertyChangeSupport support;

  public AddMenuClientImpl()
  {
    networkConnection = NetworkConnection.getInstance();
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      addMenuServer = networkConnection.getServerInterface().getAddMenuServerImpl();
      addMenuServer.registerClient(this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addFoodItem(FoodItem item)
  {
    try
    {
      addMenuServer.addFoodItem(item);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error");
    }
  }

  @Override public void getMessage(String message)
  {
    support.firePropertyChange("AddMenuMessage", null, message);
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
