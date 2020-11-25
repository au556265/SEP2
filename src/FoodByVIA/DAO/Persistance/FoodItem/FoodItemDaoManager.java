package FoodByVIA.DAO.Persistance.FoodItem;

import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDAO;
import FoodByVIA.Shared.FoodItem;

import java.sql.*;
import java.util.ArrayList;

public class FoodItemDaoManager extends FoodByVIA.DAO.Persistance.Connection
    implements FoodItemDAO
{
  public java.sql.Connection getConnection() throws SQLException
  {
    return super.getConnection();
  }


  @Override public void addMenu(FoodItem foodItem)
  {
    try(java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement(
              "insert into FoodItem(foodItemName, foodItemPrice, foodItemDescription) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1,foodItem.getName());
      preparedStatement.setDouble(2,foodItem.getPrice());
      preparedStatement.setString(3,foodItem.getDescription());

      preparedStatement.executeUpdate();

    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }

  }

  @Override public FoodItem getOneFoodItem(String name)
  {
    try(java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement("select * from FoodItem where foodItemName = ?");
      preparedStatement.setString(1,name);

      ResultSet resultSet = preparedStatement.executeQuery();

      if(resultSet.next()){
        String foodItemName = resultSet.getString("foodItemName");
        double foodItemPrice = resultSet.getDouble("foodItemPrice");
        String foodItemDescription  = resultSet.getString("foodItemDescription");
        FoodItem foodItem= new FoodItem(foodItemName,foodItemPrice,foodItemDescription);

        return foodItem;
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void delete(FoodItem foodItem)
  {
    try(java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement("delete from FoodItem where foodItemName = ?");
      preparedStatement.setString(1,foodItem.getName());
      preparedStatement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }

  @Override public ArrayList<FoodItem> getAllFoodItems()
  {
    ArrayList<FoodItem> foodItems = new ArrayList<>();

    try(java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement("select * from fooditem");
      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()){
        String foodItemName = resultSet.getString("foodItemName");
        double foodItemPrice = resultSet.getDouble("foodItemPrice");
        String foodItemDescription  = resultSet.getString("foodItemDescription");
        FoodItem foodItem= new FoodItem(foodItemName,foodItemPrice,foodItemDescription);

        foodItems.add(foodItem);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    return foodItems;
  }


}
