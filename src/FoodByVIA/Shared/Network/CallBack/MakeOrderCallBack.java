package FoodByVIA.Shared.Network.CallBack;

import FoodByVIA.Shared.FoodItem;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MakeOrderCallBack extends Remote, MessageCallBack
{
  void additems(ArrayList<FoodItem> items) throws RemoteException;
}
