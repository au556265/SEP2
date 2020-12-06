package FoodByVIA.Shared.Network.MakeOrder;

import FoodByVIA.Server.Core.ClientCallBackFactory;
import FoodByVIA.Shared.Network.CallBack.MakeOrderCallBack;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Order;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MakeOrderServer extends Remote
{
  void registerClient(MakeOrderCallBack client) throws RemoteException;
  void createOrder(Order order) throws RemoteException;
  void showMenu() throws RemoteException;
}
