package FoodByVIA.Client.Network.MakeOrder;

import FoodByVIA.Client.Network.NetworkConnection;
import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Network.CallBack.MakeOrderCallBack;
import FoodByVIA.Shared.Network.MakeOrder.MakeOrderServer;
import FoodByVIA.Shared.Order;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MakeOrderClientImpl
    implements MakeOrderClient, MakeOrderCallBack
{
  private MakeOrderServer makeOrderServer;
  private NetworkConnection networkConnection;
  private PropertyChangeSupport support;

  public MakeOrderClientImpl()
  {
   networkConnection = NetworkConnection.getInstance();
   support= new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      makeOrderServer = networkConnection.getServerInterface().getMakeOrderServerImpl();
      makeOrderServer.registerClient(this);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error");
    }
  }

  @Override public void createOrder(Order order)
  {
    try
    {
      makeOrderServer.createOrder(order);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();

      throw new RuntimeException("Error from Client");
    }
  }

  @Override public void showMenu()
  {
    try
    {
      makeOrderServer.showMenu();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error from Client");
    }
  }

  @Override public void additems(ArrayList<FoodItem> item)
  {
    support.firePropertyChange("FoodItems", null, item);
  }

  @Override public void getMessage(String message)
  {
    support.firePropertyChange("OrderNumber", null, message);
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
