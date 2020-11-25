package FoodByVIA.Server.Core;

import FoodByVIA.Server.Network.AddMenuServerImpl;
import FoodByVIA.Server.Network.RegisterUserServerImpl;
import FoodByVIA.Shared.Network.AddMenu.AddMenuServer;
import FoodByVIA.Shared.Network.RegisterUser.RegisterUserServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerFactory implements ServerInterface
{
  private AddMenuServer addMenuServer;
  private RegisterUserServer registerUserServer;
  private ServerModelFactory modelFactory;

  public ServerFactory(ServerModelFactory modelFactory) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.modelFactory = modelFactory;
  }

  @Override public AddMenuServer getAddMenuServerImpl()
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

  @Override public RegisterUserServer getRegisterUserServerImpl()
  {
    if(registerUserServer == null)
    {
      try
      {
        registerUserServer = new RegisterUserServerImpl(modelFactory.getRegisterUserServerModel());
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
    }
    return registerUserServer;
  }

}
