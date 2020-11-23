package FoodByVIA.Shared.Network;

import FoodByVIA.Shared.FoodItem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddMenuCallBack extends Remote
{
  void update (FoodItem item) throws RemoteException;
}
