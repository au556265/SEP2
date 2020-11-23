package FoodByVIA.Server.Core;

import FoodByVIA.Server.Network.AddMenuServerImpl;
import FoodByVIA.Shared.Network.AddMenuServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public class ServerFactory implements Remote
{
  private AddMenuServer addMenuServer;
  private ServerModelFactory modelFactory;

  public ServerFactory(ServerModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public AddMenuServer getAddMenuServer()
  {
    if(addMenuServer == null)
    {
      try
      {
        addMenuServer= new AddMenuServerImpl(modelFactory.getAddMenuServerModel());
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
    }
    return addMenuServer;
  }
}
