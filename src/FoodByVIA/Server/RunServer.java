package FoodByVIA.Server;

import FoodByVIA.Server.Model.AddMenu.AddMenuServerModelImpl;
import FoodByVIA.Server.Network.AddMenuServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args)
      throws RemoteException
  {
    AddMenuServerImpl addMenuServer = new AddMenuServerImpl(new AddMenuServerModelImpl());
    addMenuServer.start();
  }
}
