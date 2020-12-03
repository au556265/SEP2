package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.AddMenu.AddMenuServerModel;
import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Network.AddMenu.AddMenuServer;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class AddMenuServerImpl implements AddMenuServer
{
  private AddMenuServerModel model;
  private MessageCallBack client;

  public AddMenuServerImpl(AddMenuServerModel model, MessageCallBack client) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.client = client;
    this.model = model;
  }

  @Override public void registerClient(MessageCallBack client)
  {
    this.client = client;
    model.addPropertyChangeListener("AddMenuMessage", this::throwMessage);
  }

  @Override public void addFoodItem(FoodItem item)
  {
    model.addFoodItem(item);
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
      e.printStackTrace();
    }
  }
}
