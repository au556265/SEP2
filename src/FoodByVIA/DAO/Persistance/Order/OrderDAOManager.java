package FoodByVIA.DAO.Persistance.Order;

import java.sql.SQLException;

public class OrderDAOManager extends FoodByVIA.DAO.Persistance.Connection
    implements OrderDAO
{

  public java.sql.Connection getConnection() throws SQLException
  {
    return super.getConnection();
  }


  @Override public void registerOrder()
  {

  }
}
