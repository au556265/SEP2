package FoodByVIA.DAO.Persistance.TableReservation;

import FoodByVIA.Shared.TableReservation;

import java.util.ArrayList;

public interface TableReservationDAO
{
  void reserveTable(TableReservation reservation);
  /*
  boolean checkReservation(String tableID);
  void freeTable(String tableID);
  ArrayList<TableReservation> getAllTableReservations();
  TableReservation getSelectedTableReservation(String username,String tableID);

   */
}
