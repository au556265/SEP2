package FoodByVIA.Shared.Network.Login;

import FoodByVIA.Shared.Network.CallBack.MessageCallBack;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginServer extends Remote
{
  void registerClient(MessageCallBack client) throws RemoteException;
  boolean checkUserInput(String username, String password, String usertype) throws
      RemoteException;
}
