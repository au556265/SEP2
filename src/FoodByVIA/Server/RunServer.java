package FoodByVIA.Server;

import FoodByVIA.Server.Core.ClientCallBackFactory;
import FoodByVIA.Server.Core.DAOFactory;
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
    DAOFactory daoFactory = new DAOFactory();
    ServerModelFactory serverModelFactory = new ServerModelFactory(daoFactory);
    ClientCallBackFactory clientCallBackFactory = new ClientCallBackFactory();
    ServerFactory serverFactory = new ServerFactory(serverModelFactory, clientCallBackFactory);

    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", serverFactory);
    System.out.println("Server Started");
  }
}
