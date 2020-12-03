package FoodByVIA.Shared.Network.AddMenu;

import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddMenuServer extends Remote
{
   void registerClient(MessageCallBack client) throws RemoteException;
   void addFoodItem(FoodItem item) throws
       RemoteException;
}
