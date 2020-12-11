package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.AddMenu.AddMenuServerModel;
import FoodByVIA.Server.Model.MakeOrder.MakeOrderServerModel;
import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Network.CallBack.MakeOrderCallBack;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Network.MakeOrder.MakeOrderServer;
import FoodByVIA.Shared.Order;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MakeOrderServerImpl implements MakeOrderServer
{
  private MakeOrderServerModel model;
  private MakeOrderCallBack client;

  public MakeOrderServerImpl(MakeOrderServerModel model, MakeOrderCallBack client)
      throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.client = client;
    this.model = model;
    model.addPropertyChangeListener("OrderNumber", this::throwMessage);
    model.addPropertyChangeListener("FoodItems", this::addItem);
  }

  @Override public void registerClient(MakeOrderCallBack client)
  {
    this.client = client;
  }

  private void addItem(PropertyChangeEvent evt)
  {
    try
    {
      ArrayList<FoodItem> items = (ArrayList<FoodItem>) evt.getNewValue();
      client.additems(items);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Can't pass message from serverimpl");
    }
  }

  private void throwMessage(PropertyChangeEvent evt)
  {
    try
    {
      String  message = (String) evt.getNewValue();
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

  @Override public void showMenu()
  {
    model.showMenu();

  }
}
