package FoodByVIA.DAO.Persistance;

import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDAO;
import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDaoManager;
import FoodByVIA.DAO.Persistance.User.UserDAO;
import FoodByVIA.DAO.Persistance.User.UserDaoManager;

public class test2
{
  public static void main(String[] args)
  {
    FoodItemDAO foodItemDAO = new FoodItemDaoManager();
    System.out.println(foodItemDAO.getAllFoodItems());
    UserDAO userDAO = new UserDaoManager();
    System.out.println(userDAO.getAllUsers());
    userDAO.checkLogin("Chris", "1234", "customer");
    System.out.println(userDAO.checkLogin("Chris", "12345", "customer"));
    System.out.println(userDAO.checkLogin("Chris", "1234", "employee"));
  }
}
