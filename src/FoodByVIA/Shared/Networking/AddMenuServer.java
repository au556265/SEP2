package FoodByVIA.Shared.Networking;

import FoodByVIA.Shared.Menu;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface AddMenuServer extends Remote
{
   void addFoodItem(String name, double price, String description) throws
       RemoteException;
   List<Menu> getMenu() throws RemoteException;
   void registerClient (AddMenuCallBack menu)throws RemoteException;
}
