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
      PreparedStatement preparedStatement = connection.prepareStatement("UPDATE TableList SET username = ?, "
          + "for_date = ?, is_available = ? WHERE capacity = ? and for_zone = ?;" );
      preparedStatement.setString(1,reservation.getUsername());
      preparedStatement.setObject(2,reservation.getDate().getLocaldate());
      preparedStatement.setBoolean(3,false);
      preparedStatement.setInt(4,reservation.getNumberOfPeople());
      preparedStatement.setString(5,reservation.getZone());

      preparedStatement.executeUpdate();
      System.out.println(preparedStatement);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }


}
