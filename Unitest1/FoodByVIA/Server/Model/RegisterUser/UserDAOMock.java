package FoodByVIA.Server.Model.RegisterUser;

import FoodByVIA.DAO.Persistance.User.UserDAO;
import FoodByVIA.Shared.User;

import java.util.ArrayList;

public class UserDAOMock implements UserDAO
{

  private ArrayList<User>  users = new ArrayList<>();

  @Override public User createUser(User user)
  {
    users.add(user);
    return user;
  }

  @Override public boolean checkLogin(String username, String password,
      String userType)
  {
    return false;
  }

  @Override public ArrayList<User> getAllUsers()
  {
    return users;
  }

  @Override public User getUser(String username)
  {
    return null;
  }
}
