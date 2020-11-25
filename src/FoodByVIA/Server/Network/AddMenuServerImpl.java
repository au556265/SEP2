package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.AddMenu.AddMenuServerModel;
import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Network.AddMenu.AddMenuServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class AddMenuServerImpl implements AddMenuServer
{
  private AddMenuServerModel model;

  public AddMenuServerImpl(AddMenuServerModel model) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.model = model;
  }

  @Override public void addFoodItem(FoodItem item)
  {
    model.addFoodItem(item);
  }
}
