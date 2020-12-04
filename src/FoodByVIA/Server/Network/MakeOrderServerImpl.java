package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.MakeOrder.MakeOrderServerModel;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Network.MakeOrder.MakeOrderServer;
import FoodByVIA.Shared.Order;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MakeOrderServerImpl implements MakeOrderServer
{
  private MakeOrderServerModel model;
  private MessageCallBack client;

  public MakeOrderServerImpl(MakeOrderServerModel model, MessageCallBack client)
      throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.client = client;
    this.model = model;
  }

  @Override public void registerClient(MessageCallBack client)
  {
    this.client = client;
    model.addPropertyChangeListener("OrderNumber", this::throwMessage);
  }

  private void throwMessage(PropertyChangeEvent evt)
  {
    try
    {
      String message = (String) evt.getNewValue();
      client.getMessage(message);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Can't pass message from serverimpl");
    }
  }

  @Override public void createOrder(Order order)
  {
    model.createOrder(order);
  }
}
