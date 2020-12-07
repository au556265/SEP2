package FoodByVIA.Client.Model.TableReservation;

import FoodByVIA.Client.Network.TableReservation.TableReservationClient;
import FoodByVIA.Shared.TableReservation;
import FoodByVIA.Shared.Util.PropertyChangeSubject;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;

public class TableReservationModelImpl implements TableReservationModel
{
  private PropertyChangeSupport support;
  private TableReservationClient client;

  public TableReservationModelImpl(TableReservationClient client)
  {
    this.client = client;
    client.startClient();
    support = new PropertyChangeSupport(this);
    client.addPropertyChangeListener("TableBookingConfirmation",this::bookingConfirmation);
    client.addPropertyChangeListener("AvailableTables", this::addTables);
  }

  private void addTables(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }

  private void bookingConfirmation(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }

  @Override public void reserveTable(TableReservation table)
  {
    client.reserveTable(table);
  }

  @Override public void search(LocalDate date, int capacity, String floor)
  {
    client.search(date,capacity,floor);
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
   support.addPropertyChangeListener(name,listener);
  }

  @Override public void removerPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name,listener);
  }
}
