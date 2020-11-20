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

public class AddMenuServerImpl extends StartServer implements AddMenuServer
{
  private AddMenuServerModel model;
  private List<AddMenuCallBack> clients;

  public AddMenuServerImpl(AddMenuServerModel model) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.model = model;
    clients = new ArrayList<>();
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", this);
  }

  @Override public void addFoodItem(FoodItem item)
  {
    model.addFoodItem(item);
  }
}
