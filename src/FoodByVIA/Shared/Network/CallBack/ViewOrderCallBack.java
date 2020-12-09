package FoodByVIA.Shared.Network.CallBack;

import FoodByVIA.Shared.Order;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ViewOrderCallBack
{
  void getAllOrders(ArrayList<Order> Orders) throws RemoteException;
}
