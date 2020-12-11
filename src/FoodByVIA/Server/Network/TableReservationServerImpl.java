package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.RegisterUser.RegisterUserServerModel;
import FoodByVIA.Server.Model.TableReservation.TableReservationServerModel;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Network.CallBack.ReserveTableCallBack;
import FoodByVIA.Shared.Network.TableReservation.TableReservationServer;
import FoodByVIA.Shared.TableReservation;

import java.beans.PropertyChangeEvent;
import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;

public class TableReservationServerImpl implements TableReservationServer
{
  private TableReservationServerModel model;
  private ReserveTableCallBack client;

  public TableReservationServerImpl(TableReservationServerModel model, ReserveTableCallBack client)
      throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.model = model;
    this.client = client;
    model.addPropertyChangeListener("AvailableTables", this::addTables);
    model.addPropertyChangeListener("NotAvailableMessage", this::notAvailable);
    model.addPropertyChangeListener("TableBookingConfirmation",this::throwMessage);
  }

  @Override public void reserveTable(TableReservation table)
  {
    model.reserveTable(table);
  }

  @Override public void registerClient(ReserveTableCallBack client)
  {
    this.client = client;
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
  {
    model.search(Capacity,floor,date);
  }

  private void notAvailable(PropertyChangeEvent evt)
  {
    String notAvailableMessage = (String) evt.getNewValue();
    try
    {
      client.getMessage(notAvailableMessage);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  private void addTables(PropertyChangeEvent evt)
  {
    ArrayList<TableReservation> tables = (ArrayList<TableReservation>) evt.getNewValue();
    try
    {
      client.addTables(tables);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
