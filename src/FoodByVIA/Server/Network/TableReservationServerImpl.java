package FoodByVIA.Server.Network;

import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Network.TableReservation.TableReservationServer;
import FoodByVIA.Shared.TableReservation;

import java.rmi.RemoteException;
import java.time.LocalDate;

public class TableReservationServerImpl implements TableReservationServer
{
  @Override public void reserveTable(TableReservation table)
      throws RuntimeException
  {

  }

  @Override public void registerClient(MessageCallBack client)
      throws RemoteException
  {

  }

  @Override public void search(LocalDate date, int Capacity, String floor)
      throws RemoteException
  {

  }
}
