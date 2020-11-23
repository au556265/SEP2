package FoodByVIA.DAO.Persistance.FoodItem;

import FoodByVIA.Shared.FoodItem;

import java.util.ArrayList;

public interface FoodItemDAO
{
   void addMenu(FoodItem foodItem);
   FoodItem getOneFoodItem( String name);
   void delete(FoodItem foodItem);
   ArrayList<FoodItem> getAllFoodItems();

}
