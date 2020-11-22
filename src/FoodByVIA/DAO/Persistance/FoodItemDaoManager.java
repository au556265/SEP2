package FoodByVIA.DAO.Persistance;

import FoodByVIA.DAO.Persistance.Login.LoginDBS;
import FoodByVIA.Shared.FoodItem;

import java.sql.*;
import java.util.ArrayList;

public class FoodItemDaoManager implements FoodItemDAO
{
  public Connection getConnection(){
    Connection connection = null;
    Statement statement = null;
    try
    {
      return connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=sep",
          LoginDBS.username, LoginDBS.password);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    System.out.println("DBS connection failed");
    return null;
  }


  @Override public void addMenu(FoodItem foodItem)
  {
    Connection connection = getConnection();
    try
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement("INSERT INTO fooditem_table(fooditemname, fooditemprice, fooditemdescription) VALUES(?,?,?)");
      preparedStatement.setString(1,foodItem.getName());
      preparedStatement.setDouble(2,foodItem.getPrice());
      preparedStatement.setString(3,foodItem.getDescription());
      preparedStatement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }

  @Override public FoodItem getOneFoodItem(String name)
  {
    Connection connection = getConnection();
    try
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement("SELECT * FROM fooditem_table where fooditemname = ?");
      preparedStatement.setString(1,name);

      ResultSet resultSet = preparedStatement.executeQuery();

      if(resultSet.next()){
        String foodItemName = resultSet.getString("fooditemname");
        double foodItemPrice = resultSet.getDouble("fooditemprice");
        String foodItemDescription  = resultSet.getString("fooditemdescription");
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
    Connection connection = getConnection();
    try
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement("delete from fooditem_table where fooditemname = ?");
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
    Connection connection = getConnection();
    ArrayList<FoodItem> foodItems = new ArrayList<>();

    try
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement("select * from fooditem_table");
      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()){
        String foodItemName = resultSet.getString("fooditemname");
        double foodItemPrice = resultSet.getDouble("fooditemprice");
        String foodItemDescription  = resultSet.getString("fooditemdescription");
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
