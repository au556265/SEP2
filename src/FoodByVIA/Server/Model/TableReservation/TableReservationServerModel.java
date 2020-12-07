package FoodByVIA.Server.Model.TableReservation;

import FoodByVIA.Shared.TableReservation;
import FoodByVIA.Shared.Util.PropertyChangeSubject;

import java.time.LocalDate;

public interface TableReservationServerModel extends PropertyChangeSubject
{
  void reserveTable(TableReservation table);
  void search(int capacity, String zone, LocalDate date);
}
