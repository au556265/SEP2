package FoodByVIA.DAO.Persistance;

import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDAO;
import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDaoManager;
import FoodByVIA.DAO.Persistance.User.UserDAO;
import FoodByVIA.DAO.Persistance.User.UserDaoManager;
import FoodByVIA.Shared.User;

import java.util.Scanner;

public class test2
{
  public static void main(String[] args)
  {
   User user = new User("","","","","","","");

   user.setUsername("test1");
   user.setPassword("1234");
   user.setName("asdasdasd");
   user.setPhoneNumber("123456789");
   user.setAddress("Somwehre");
   user.setEmail("blabla");
   user.setUserType("customer"); //Make a method in which you can ONLY select between Customer or Employee

    UserDAO daotest = new UserDaoManager();

    //Testing creation of user
    daotest.createUser(user);
    System.out.println("Test user creation: " + user.toString());


    //Testing login credentials of user
    System.out.println(daotest.checkLogin(user.getUsername(), user.getPassword()));
    daotest.checkLogin(user.getUsername(), user.getPassword());

  }
}
