package FoodByVIA.Shared.Network.ManageOrder;

import FoodByVIA.Client.Network.ManageOrder.ManageOrderClientImpl;
import FoodByVIA.Shared.Network.CallBack.ManageOrderCallBack;
import FoodByVIA.Shared.Order;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;


public interface ManageOrderServer extends Remote
{
  void registerClient(ManageOrderCallBack client) throws RemoteException;
  void search(boolean isActive, LocalDate date) throws RemoteException;

}
