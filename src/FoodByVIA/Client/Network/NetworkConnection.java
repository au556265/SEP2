package FoodByVIA.Client.Network;

import FoodByVIA.Server.Core.ServerInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NetworkConnection
{
  private ServerInterface serverInterface;
  private static NetworkConnection instance;

  private NetworkConnection(){}

  public static NetworkConnection getInstance()
  {
    if(instance == null)
    {
      instance = new NetworkConnection();
    }
    return instance;
  }

  public ServerInterface getServerInterface()
  {
    if(serverInterface == null)
    {
      try
      {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        serverInterface = (ServerInterface) registry.lookup("Server");
      }
      catch (RemoteException | NotBoundException e)
      {
        e.printStackTrace();
      }
    }
    return serverInterface;
  }
}
