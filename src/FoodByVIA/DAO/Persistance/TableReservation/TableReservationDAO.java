package FoodByVIA.DAO.Persistance.TableReservation;

import FoodByVIA.Shared.TableReservation;

import java.time.LocalDate;
import java.util.ArrayList;

public interface TableReservationDAO
{
  void reserveTable(TableReservation reservation);

  ArrayList<TableReservation> getSelectedIsAvailableTableReservation(int capacity1, String zone1, LocalDate localDate1);
  /*
  boolean checkReservation(String tableID);
  void freeTable(String tableID);
  ArrayList<TableReservation> getAllTableReservations();


   */
}
