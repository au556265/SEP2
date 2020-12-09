package FoodByVIA.Shared.Network.ViewOrder;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;


public interface ViewOrderServer extends Remote
{
  void getAllOrders(Boolean isActive,LocalDate localDate) throws RemoteException;
}
