package FoodByVIA.Client.Model.TableReservation;

import FoodByVIA.Shared.TableReservation;
import FoodByVIA.Shared.Util.PropertyChangeSubject;

import java.time.LocalDate;

public interface TableReservationModel extends PropertyChangeSubject
{
  void reserveTable( TableReservation table);
  void search(LocalDate date, int capacity , String floor);
}
