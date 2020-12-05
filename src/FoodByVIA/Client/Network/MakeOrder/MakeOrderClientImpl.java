package FoodByVIA.Client.Network.MakeOrder;

import FoodByVIA.Client.Network.NetworkConnection;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.MyDate;
import FoodByVIA.Shared.Network.MakeOrder.MakeOrderServer;
import FoodByVIA.Shared.Order;
import FoodByVIA.Shared.User;

import java.beans.PropertyChangeSupport;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MakeOrderClientImpl
    implements MakeOrderClient,MessageCallBack
{
  private MakeOrderServer makeOrderServer;
  private NetworkConnection networkConnection;
  private PropertyChangeSupport support;
  private Order order;

  public MakeOrderClientImpl()
  {
   networkConnection = NetworkConnection.getInstance();
   support= new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {

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
    }
  }

  @Override public void getMessage(String message)
  {
    support.firePropertyChange("CreateOrder", null, message);

  }
}
