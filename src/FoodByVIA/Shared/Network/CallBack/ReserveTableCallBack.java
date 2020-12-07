package FoodByVIA.Shared.Network.CallBack;

import FoodByVIA.Shared.TableReservation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ReserveTableCallBack extends Remote, MessageCallBack
{
  void addTables(ArrayList<TableReservation> tables) throws RemoteException;
}
