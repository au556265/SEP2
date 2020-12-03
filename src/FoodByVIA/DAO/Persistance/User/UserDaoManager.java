package FoodByVIA.DAO.Persistance.User;

import FoodByVIA.DAO.Persistance.Connection;
import FoodByVIA.Shared.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoManager extends Connection implements UserDAO
{


  public java.sql.Connection getConnection() throws SQLException
  {
    return super.getConnection();
  }

  @Override public boolean checkLogin(String username, String password, String userType)
  {
    try(java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement = connection.prepareStatement("select exists (select * from Users where username = ? and password = ? and userType = ?)");

      preparedStatement.setString(1,username); // Setting the ? marks
      preparedStatement.setString(2, password);
      preparedStatement.setString(3, userType);

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
  

  @Override public ArrayList<User> getAllUsers()
  {
    ArrayList<User> users = new ArrayList<>();

    try(java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement("select * from users");
      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()){
        String name = resultSet.getString("name");
        String address = resultSet.getString("address");
        String phoneNumber  = resultSet.getString("phoneNumber");
        String emailAddress = resultSet.getString("email");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String userType = resultSet.getString("userType");
        User user = new User(name, address, phoneNumber, emailAddress, username, password, userType);

        users.add(user);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    return users;
  }
}
