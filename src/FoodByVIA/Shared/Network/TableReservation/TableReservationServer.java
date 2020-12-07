package FoodByVIA.Shared.Network.TableReservation;

import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.TableReservation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

public interface TableReservationServer extends Remote
{
  void reserveTable(TableReservation table) throws RuntimeException;
  void registerClient( MessageCallBack client) throws RemoteException;
  void search(LocalDate date , int Capacity , String floor) throws RemoteException;
}
