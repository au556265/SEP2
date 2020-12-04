package FoodByVIA.DAO.Persistance.User;

import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.User;

import java.util.ArrayList;

public interface UserDAO
{
  User createUser(User user);
  boolean checkLogin(String username, String password, String userType);
  ArrayList<User> getAllUsers();
  User getUser(String username);
}
