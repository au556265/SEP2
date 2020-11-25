package FoodByVIA.Client.Network.AddMenu;

import FoodByVIA.Client.Network.NetworkConnection;
import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Network.AddMenu.AddMenuServer;

import java.rmi.RemoteException;

public class AddMenuClientImpl implements AddMenuClient
{
  private AddMenuServer addMenuServer;
  private NetworkConnection networkConnection;

  public AddMenuClientImpl()
  {
    networkConnection = NetworkConnection.getInstance();
  }

  @Override public void startClient()
  {
    try
    {
      addMenuServer = networkConnection.getServerInterface().getAddMenuServerImpl();
    }
    catch (RemoteException e)
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
}
