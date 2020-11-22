package FoodByVIA.DAO.Persistance;

import FoodByVIA.Shared.FoodItem;

import java.util.ArrayList;

public interface FoodItemDAO
{
   void addMenu(FoodItem foodItem);
   FoodItem getOneFoodItem( String name);
   void delete(FoodItem foodItem);
   ArrayList<FoodItem> getAllFoodItems();

}
