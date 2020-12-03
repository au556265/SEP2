package FoodByVIA.Shared.Network.RegisterUser;

import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RegisterUserServer extends Remote
{
  void registerClient(MessageCallBack client) throws RemoteException;
  void addUser(User user) throws RemoteException;
}
