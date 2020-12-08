package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.RegisterUser.RegisterUserServerModel;
import FoodByVIA.Server.Model.TableReservation.TableReservationServerModel;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Network.TableReservation.TableReservationServer;
import FoodByVIA.Shared.TableReservation;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;

public class TableReservationServerImpl implements TableReservationServer
{
  private TableReservationServerModel model;
  private MessageCallBack client;

  public TableReservationServerImpl(TableReservationServerModel model, MessageCallBack client)
      throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.model = model;
    this.client = client;
  }
  @Override public void reserveTable(TableReservation table)
      throws RuntimeException
  {
    model.reserveTable(table);
    model.addPropertyChangeListener("reserveTable",this::throwMessage);
  }

  @Override public void registerClient(MessageCallBack client)
      throws RemoteException
  {
    this.client = client;
    model.addPropertyChangeListener("RegisterMessage",this::throwMessage);
  }
  private void throwMessage(PropertyChangeEvent evt)
  {
    try
    {
      String message = (String) evt.getNewValue();
      client.getMessage(message);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void search(LocalDate date, int Capacity, String floor)
      throws RemoteException
  {
    model.search(Capacity,floor,date);
  }
}
