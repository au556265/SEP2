package FoodByVIA.Server.Core;

import FoodByVIA.Server.Network.*;
import FoodByVIA.Shared.Network.AddMenu.AddMenuServer;
import FoodByVIA.Shared.Network.Login.LoginServer;
import FoodByVIA.Shared.Network.MakeOrder.MakeOrderServer;
import FoodByVIA.Shared.Network.RegisterUser.RegisterUserServer;
import FoodByVIA.Shared.Network.TableReservation.TableReservationServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerFactory implements ServerInterface
{
  private AddMenuServer addMenuServer;
  private RegisterUserServer registerUserServer;
  private LoginServer loginServer;
  private MakeOrderServer makeOrderServer;
  private ServerModelFactory modelFactory;
  private ClientCallBackFactory callBackFactory;
  private TableReservationServer tableReservationServer;

  public ServerFactory(ServerModelFactory modelFactory, ClientCallBackFactory callBackFactory) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.modelFactory = modelFactory;
    this.callBackFactory = callBackFactory;
  }

  @Override public AddMenuServer getAddMenuServerImpl()
  {
    if(addMenuServer == null)
    {
      try
      {
        addMenuServer= new AddMenuServerImpl(modelFactory.getAddMenuServerModel(), callBackFactory.getMessageCallBack());
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
        registerUserServer = new RegisterUserServerImpl(modelFactory.getRegisterUserServerModel(), callBackFactory.getMessageCallBack());
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
    }
    return registerUserServer;
  }

  @Override public LoginServer getLoginServerImpl()
  {
    if(loginServer == null)
    {
      try
      {
        loginServer = new LoginServerImpl(modelFactory.getLoginServerModel(), callBackFactory.getMessageCallBack());
      }
      catch(RemoteException e)
      {
        e.printStackTrace();
      }
    }
    return loginServer;
  }

  @Override public MakeOrderServer getMakeOrderServerImpl()
  {
    if(makeOrderServer == null)
    {
      try
      {
        makeOrderServer = new MakeOrderServerImpl(modelFactory.getMakeOrderServerModel(), callBackFactory.getMakeOrderCallBack());
      }
      catch(RemoteException e)
      {
        e.printStackTrace();
      }
    }
    return makeOrderServer;
  }

  @Override public TableReservationServer getTableReservationServerImpl()
  {
    if(tableReservationServer == null)
    {
      try
      {
        tableReservationServer = new TableReservationServerImpl(modelFactory.getTableReservationServerModel(), callBackFactory.getReserveTableCallBack());
      }
      catch(RemoteException e)
      {
        e.printStackTrace();
      }
    }
    return tableReservationServer;
  }

}
