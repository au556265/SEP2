package FoodByVIA.Shared.Networking;

import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Menu;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddMenuCallBack extends Remote
{
  void update (FoodItem item) throws RemoteException;
}
