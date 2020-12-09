package FoodByVIA.Shared.Network.CallBack;

import FoodByVIA.Shared.Order;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ManageOrderCallBack extends Remote
{
  void addOrders(ArrayList<Order> orders) throws RemoteException;
}
