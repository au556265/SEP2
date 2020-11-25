package FoodByVIA.Server.Model.RegisterUser;

import FoodByVIA.DAO.Persistance.User.UserDaoManager;
import FoodByVIA.Server.Network.RegisterUserServerImpl;
import FoodByVIA.Shared.User;

public class RegisterUserServerModelImpl
{
  UserDaoManager userDAO = new UserDaoManager();

  public void addUser(User user)
  {
    userDAO.createUser(user);
  }
}
