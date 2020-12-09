package FoodByVIA.Server.Core;

import FoodByVIA.Shared.Network.AddMenu.AddMenuServer;
import FoodByVIA.Shared.Network.Login.LoginServer;
import FoodByVIA.Shared.Network.MakeOrder.MakeOrderServer;
import FoodByVIA.Shared.Network.ManageOrder.ManageOrderServer;
import FoodByVIA.Shared.Network.RegisterUser.RegisterUserServer;
import FoodByVIA.Shared.Network.TableReservation.TableReservationServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote
{
  AddMenuServer getAddMenuServerImpl() throws RemoteException;
  RegisterUserServer getRegisterUserServerImpl() throws RemoteException;
  LoginServer getLoginServerImpl() throws RemoteException;
  MakeOrderServer getMakeOrderServerImpl() throws RemoteException;
  TableReservationServer getTableReservationServerImpl()throws RemoteException;
  ManageOrderServer getManageOrderServerImpl();
}
