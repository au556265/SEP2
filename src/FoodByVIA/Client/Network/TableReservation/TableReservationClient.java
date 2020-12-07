package FoodByVIA.Client.Network.TableReservation;

import FoodByVIA.Shared.TableReservation;
import FoodByVIA.Shared.Util.PropertyChangeSubject;


import java.time.LocalDate;

public interface TableReservationClient extends PropertyChangeSubject
{
  void reserveTable(TableReservation table);
  void search(LocalDate date , int capacity, String floor);
  void startClient();

}
