package FoodByVIA.DAO.Persistance;

import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDAO;
import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDaoManager;
import FoodByVIA.DAO.Persistance.User.UserDAO;
import FoodByVIA.DAO.Persistance.User.UserDAOManager;

public class test2
{
  public static void main(String[] args)
  {
    FoodItemDAO foodItemDAO = new FoodItemDaoManager();
    System.out.println(foodItemDAO.getAllFoodItems());
    UserDAO userDAO = new UserDAOManager();
    System.out.println(userDAO.getAllUsers());
  }
}
