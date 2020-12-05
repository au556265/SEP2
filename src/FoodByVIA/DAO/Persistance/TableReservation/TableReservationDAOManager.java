package FoodByVIA.DAO.Persistance.TableReservation;

import FoodByVIA.Shared.TableReservation;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableReservationDAOManager extends FoodByVIA.DAO.Persistance.Connection implements TableReservationDAO
{
  public java.sql.Connection getConnection() throws SQLException
  {
    return super.getConnection();
  }


  @Override public void reserveTable(TableReservation reservation)
  {
    try(java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement = connection.prepareStatement("UPDATE TableList SET username = ?, for_date = ? WHERE tableID=?" );
      preparedStatement.setString(1,reservation.getUsername());
      preparedStatement.setObject(2,reservation.getDate().getLocaldate());
      preparedStatement.setString(3,reservation.getTableID());


      preparedStatement.executeUpdate();

    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

}
