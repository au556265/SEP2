package FoodByVIA.Server.Model.TableReservation;

import FoodByVIA.DAO.Persistance.TableReservation.TableReservationDAO;
import FoodByVIA.Shared.TableReservation;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.util.ArrayList;

public class TableReservationServerModelImpl implements TableReservationServerModel
{
  private TableReservationDAO dao;
  private PropertyChangeSupport support;

  public TableReservationServerModelImpl(TableReservationDAO dao)
  {
    this.dao = dao;
    support = new PropertyChangeSupport(this);
  }

  @Override public void reserveTable(TableReservation table)
  {
    dao.reserveTable(table);
    support.firePropertyChange("TableBookingConfirmation", null,
        "Your table has been booked for the selected date");
  }

  @Override public void search(int capacity, String zone, LocalDate date)
  {
    ArrayList<TableReservation> availableTables = dao.getSelectedIsAvailableTableReservation(capacity, zone, date);
    if(availableTables.size() == 0)
    {
      support.firePropertyChange("NotAvailableMessage", null, "All tables are booked");
    }
    support.firePropertyChange("AvailableTables", null, availableTables);
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
}