package FoodByVIA.Server.Core;

import FoodByVIA.Shared.Network.AddMenu.AddMenuServer;
import FoodByVIA.Shared.Network.RegisterUser.RegisterUserServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote
{
  AddMenuServer getAddMenuServerImpl() throws RemoteException;
  RegisterUserServer getRegisterUserServerImpl() throws RemoteException;
}
