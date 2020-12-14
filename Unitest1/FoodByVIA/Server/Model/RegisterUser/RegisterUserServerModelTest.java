package FoodByVIA.Server.Model.RegisterUser;

import FoodByVIA.DAO.Persistance.User.UserDAO;
import FoodByVIA.Shared.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserServerModelTest
{



  private UserDAO userdao;
  private RegisterUserServerModelImpl registerUserServerModel;

  @BeforeEach
  public void testPreparations(){
    userdao = new UserDAOMock();
    registerUserServerModel = new RegisterUserServerModelImpl(userdao);
  }

  @Test
  public void testIfUserIsRegistered(){
    User user = new User("fatema","Fasanvej 16", "87654321","f@hotmail.com","fatema","123456","Customer");
    registerUserServerModel.addUser(user);
    userdao.getAllUsers();
    assertTrue(userdao.getAllUsers().contains(user));
  }

  @Test
  public void testThatYouCantRegisterTheSameUserTwice(){
    User user = new User("fatema","Fasanvej 16", "87654321","f@hotmail.com","fatema","123456","Customer");
    User user1 = new User("fatema","Fasanvej 16", "87654321","f@hotmail.com","fatema","123456","Customer");

    registerUserServerModel.addUser(user);
    registerUserServerModel.addUser(user1);
    userdao.getAllUsers();
    assertFalse(userdao.getAllUsers().contains(user1));
  }

  @Test
  public void testIfWeCanRegisterMultipleDifferentUsers(){
    User user = new User("fatema","Fasanvej 16", "87654321","f@hotmail.com","fatema","123456","Customer");
    User user1 = new User("sara","bellisvej 10", "12345678","s@hotmail.com","sara","123456","Customer");

    registerUserServerModel.addUser(user);
    registerUserServerModel.addUser(user1);
    userdao.getAllUsers();
    assertTrue(userdao.getAllUsers().contains(user1));
    assertTrue(userdao.getAllUsers().contains(user));
  }





}