package FoodByVIA.Shared.Networking;

import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Menu;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface AddMenuServer extends Remote
{
   void addFoodItem(FoodItem item) throws
       RemoteException;
}
