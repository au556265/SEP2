package FoodByVIA.DAO.Persistance.TableReservation;

import FoodByVIA.Shared.TableReservation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TableReservationDAOManager extends FoodByVIA.DAO.Persistance.Connection implements TableReservationDAO
{
  public java.sql.Connection getConnection() throws SQLException
  {
    return super.getConnection();
  }

  @Override public void reserveTable(TableReservation reservation)
  {
    try (java.sql.Connection connection = getConnection())
    {

      PreparedStatement preparedStatement = connection.prepareStatement(
          "Insert into TableReservations(username, for_date, tableID) values (?,?,?);");
      preparedStatement.setString(1, reservation.getUsername());
      preparedStatement.setObject(2, reservation.getLocalDate());
      preparedStatement.setString(3, reservation.getTableID());

      preparedStatement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public ArrayList<TableReservation> getSelectedIsAvailableTableReservation(
      int capacity1, String zone1, LocalDate localDate1)
  {
    ArrayList<TableReservation> tables1 = new ArrayList<>();

    try(java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement("select * from tablelist WHERE capacity >= ? AND for_zone = ? "
              + "and NOT EXISTS(Select 1 from TableReservations "
              + "WHERE tablelist.tableid = tableReservations.tableid AND for_date = ?);" );

      preparedStatement.setInt(1,capacity1);
      preparedStatement.setString(2, zone1);
      preparedStatement.setObject(3,localDate1);


      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()){

        TableReservation table1 = new TableReservation();
        table1.setTableID( resultSet.getString("tableID"));
        table1.setNumberOfPeople(resultSet.getInt("capacity"));
        table1.setZone(resultSet.getString("for_zone"));

        tables1.add(table1);
      }
      return tables1;

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

}
