package FoodByVIA.Server;


import FoodByVIA.Server.Core.ServerFactory;
import FoodByVIA.Server.Core.ServerModelFactory;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    ServerModelFactory modelFactory = new ServerModelFactory();
    ServerFactory serverFactory = new ServerFactory(modelFactory);

    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", serverFactory);


  }
}
