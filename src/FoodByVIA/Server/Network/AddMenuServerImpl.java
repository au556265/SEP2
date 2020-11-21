package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.AddMenu.AddMenuServerModel;
import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Networking.AddMenuCallBack;
import FoodByVIA.Shared.Networking.AddMenuServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

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
