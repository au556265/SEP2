package FoodByVIA.DAO.Persistance.User;

import FoodByVIA.Shared.User;

public interface UserDAO
{
  User createUser(User user);
  boolean checkLogin(String username, String password);

}
