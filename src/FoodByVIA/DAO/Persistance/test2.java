package FoodByVIA.DAO.Persistance;

import FoodByVIA.Shared.FoodItem;

public class test2
{
  public static void main(String[] args)
  {
    FoodItemDAO foodItemDAO = new FoodItemDaoManager();
    System.out.println(foodItemDAO.getAllFoodItems());
  }
}
