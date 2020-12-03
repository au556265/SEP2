package FoodByVIA.Shared.Network.CallBack;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessageCallBack extends Remote
{
  void getMessage(String message) throws RemoteException;
}
