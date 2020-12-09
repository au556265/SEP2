package FoodByVIA.DAO.Persistance;

import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Connection
{
  public Connection()
  {
    try
    {
      DriverManager.registerDriver(new org.postgresql.Driver());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  // remember to change the localhot to your own and the password
  public java.sql.Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/postgres?currentSchema=sep",
        "postgres", "bakaVeki95");
  }
}
