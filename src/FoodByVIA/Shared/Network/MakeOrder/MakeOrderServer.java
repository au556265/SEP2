package FoodByVIA.Shared.Network.MakeOrder;

import FoodByVIA.Server.Core.ClientCallBackFactory;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Order;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MakeOrderServer extends Remote
{
  void registerClient(MessageCallBack client) throws RemoteException;
  void createOrder(Order order) throws RemoteException;
}
