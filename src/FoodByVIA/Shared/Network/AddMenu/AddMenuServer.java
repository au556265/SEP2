package FoodByVIA.Shared.Network.AddMenu;

import FoodByVIA.Shared.FoodItem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddMenuServer extends Remote
{
   void addFoodItem(FoodItem item) throws
       RemoteException;
}
