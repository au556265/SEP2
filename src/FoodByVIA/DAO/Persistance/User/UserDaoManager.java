package FoodByVIA.DAO.Persistance.User;

import FoodByVIA.Shared.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoManager extends FoodByVIA.DAO.Persistance.Connection implements UserDAO
{
  public java.sql.Connection getConnection() throws SQLException
  {
    return super.getConnection();
  }

  @Override public boolean checkLogin(String username, String password)
  {
    try(java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement = connection.prepareStatement("select exists (select * from Users where username = ? and password = ?)");

      preparedStatement.setString(1,username); // Setting the ? marks
      preparedStatement.setString(2, password);

      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next())
      {
        return resultSet.getBoolean(1);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return false;
  }

  @Override public User createUser(User user)
  {
    try(java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement = connection.prepareStatement("insert into Users (username, password, name, phoneNumber, address, email, userType) values (?,?,?,?,?,?,?)");
      preparedStatement.setString(1,user.getUsername());
      preparedStatement.setString(2,user.getPassword());
      preparedStatement.setString(3,user.getName());
      preparedStatement.setString(4,user.getPhoneNumber());
      preparedStatement.setString(5,user.getAddress());
      preparedStatement.setString(6,user.getEmail());
      preparedStatement.setString(7,user.getUserType());

      preparedStatement.executeUpdate();

    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return user;
  }
}
