package FoodByVIA.Server.Core;

import FoodByVIA.Persistance.FoodItem.FoodItemDAO;
import FoodByVIA.Persistance.FoodItem.FoodItemDaoManager;
import FoodByVIA.Persistance.User.UserDAO;
import FoodByVIA.Persistance.User.UserDAOManager;

public class DAOFactory
{
  private FoodItemDAO foodItemDAO;
  private UserDAO userDAO;

  public FoodItemDAO getFoodItemDAO()
  {
    if(foodItemDAO == null)
    {
      foodItemDAO = new FoodItemDaoManager();
    }
    return foodItemDAO;
  }

  public UserDAO getUserDAO()
  {
    if(userDAO == null)
    {
      userDAO = new UserDAOManager();
    }
    return userDAO;
  }
}
