package FoodByVIA.Client.Network.TableReservation;

import FoodByVIA.Client.Network.NetworkConnection;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Network.CallBack.ReserveTableCallBack;
import FoodByVIA.Shared.Network.TableReservation.TableReservationServer;
import FoodByVIA.Shared.TableReservation;
import FoodByVIA.Shared.Util.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;

public class TableReservationClientImpl implements TableReservationClient ,
    ReserveTableCallBack
{
  private NetworkConnection networkConnection;
  private TableReservationServer tableReservationServer;
  private PropertyChangeSupport support;

  public TableReservationClientImpl()
  {
    networkConnection = NetworkConnection.getInstance();
    support = new PropertyChangeSupport(this);
  }
  @Override public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this,0);
      tableReservationServer = networkConnection.getServerInterface().getTableReservationServerImpl();
      tableReservationServer.registerClient(this);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error");
    }
  }

  @Override public void reserveTable(TableReservation table)
  {
    try
    {
      tableReservationServer.reserveTable(table);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void search(LocalDate date, int capacity, String floor)
  {
    try
    {
      tableReservationServer.search(date, capacity, floor);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void getMessage(String message) throws RemoteException
  {
    support.firePropertyChange("TableBookingConfirmation", null, message);
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
   support.addPropertyChangeListener(name, listener);
  }

  @Override public void removerPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  @Override public void addTables(ArrayList<TableReservation> tables)
  {
    support.firePropertyChange("AvailableTables", null, tables);
  }
}
