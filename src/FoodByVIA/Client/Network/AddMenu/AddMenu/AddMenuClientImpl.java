package FoodByVIA.Client.Network.AddMenu.AddMenu;

import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Network.AddMenuCallBack;
import FoodByVIA.Shared.Network.AddMenuServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AddMenuClientImpl implements AddMenuClient, AddMenuCallBack
{
  private AddMenuServer addMenuServer;

  @Override public void startClient()
  {
   try
   {
     UnicastRemoteObject.exportObject(this, 0);
     Registry registry = LocateRegistry.getRegistry("localhost", 1099);
     addMenuServer = (AddMenuServer) registry.lookup("AddMenuServer");
    // addMenuServer.registerClient(this);
     System.out.println("Server Connected");
   }
   catch (RemoteException | NotBoundException e)
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
      e.printStackTrace();
    }
  }

  @Override public void update(FoodItem item)
  {

  }
}
