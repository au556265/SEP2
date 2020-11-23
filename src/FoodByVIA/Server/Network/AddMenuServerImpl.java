package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.AddMenu.AddMenuServerModel;
import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Network.AddMenuCallBack;
import FoodByVIA.Shared.Network.AddMenuServer;

import java.beans.PropertyChangeListener;
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
  private List<AddMenuCallBack> callBackList;

  public AddMenuServerImpl(AddMenuServerModel model) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.model = model;
    callBackList = new ArrayList<>();
  }

  public void start()
  {
    try
    {
      Registry registry = LocateRegistry.createRegistry(1099);
      registry.bind("AddMenuServer", this);
      System.out.println("Server Started");
    }
    catch (RemoteException | AlreadyBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addFoodItem(FoodItem item)
  {
    model.addFoodItem(item);
  }

  @Override public void registerClient(AddMenuCallBack client)
  {
    PropertyChangeListener listener = null;
    PropertyChangeListener finalListener = listener;
    listener = evt -> {
      try
      {
        client.update((FoodItem) evt.getNewValue());
      }
      catch (RemoteException e)
      {
        model.removerPropertyChangeListener("NewFoodItem", finalListener);
      }
    };
    model.addPropertyChangeListener("NewFoodItem", listener);
  }
}
