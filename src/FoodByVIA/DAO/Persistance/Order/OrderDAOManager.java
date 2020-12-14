package FoodByVIA.DAO.Persistance.Order;

import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Order;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class OrderDAOManager extends FoodByVIA.DAO.Persistance.Connection
    implements OrderDAO
{
  public java.sql.Connection getConnection() throws SQLException
  {
    return super.getConnection();
  }

  @Override public void createOrder(Order order)
  {
    int ordernumber=0;
    try(Connection connection = getConnection())
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement(
              "insert into Orders(username, dateTo) values(?,?);",Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1,order.getCustomer());
      //preparedStatement.setBoolean(2,order.isActive());
      preparedStatement.setObject(2,order.getDate());
      //execute prepared statement and get ordernumber from it

      preparedStatement.execute();
      ResultSet res = preparedStatement.getGeneratedKeys();
      // add all fooditems and refer them to ordernumber Orders_FoodItems
      while (res.next())
      {
        System.out.println(res.getInt(1));
        ordernumber = res.getInt(1);
      }
      order.setOrderNumber(ordernumber);
    }
    catch(SQLException throwables){
      throwables.printStackTrace();
    }

    if(ordernumber!=0)
    {
      ArrayList<FoodItem> added = new ArrayList<>();
      for (FoodItem foodItem : order.getSelectedFoodItems())
      {
        if(!added.contains(foodItem)){
          int amount = Collections.frequency(order.getSelectedFoodItems(),foodItem);
        createOrderFood(foodItem, ordernumber, amount);
        added.add(foodItem);
        }
      }
    }

  }


  private void createOrderFood(FoodItem foodItem, int ordernumber, int amount){
    try(java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement(
              "insert into Orders_FoodItems(ordernumber, foodItemName,amount) values(?,?,?);");
      preparedStatement.setInt(1,ordernumber);
      preparedStatement.setString(2,foodItem.getName());
      preparedStatement.setInt(3,amount);
      preparedStatement.execute();
    }
    catch(SQLException throwables){
      throwables.printStackTrace();
    }
  }

  @Override public ArrayList<Order> getAllActiveOrders( Boolean isActive, LocalDate localDate1)
  {
    ArrayList<Order> orders = new ArrayList<>();

    try (java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement = connection.prepareStatement(
          "select activeorder, orders.ordernumber, username, dateto, fooditem.fooditemname, amount, fooditemprice, "
              + "fooditemdescription from orders, orders_FoodItems, Fooditem WHERE "
              + "orders.ordernumber = orders_FoodItems.ordernumber and Fooditem.fooditemname = orders_fooditems.fooditemname and activeOrder= ? " + "and dateTo = ?;");
      preparedStatement.setBoolean(1, isActive);
      preparedStatement.setObject(2, localDate1);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next())
      {
        boolean found = false;
        int ordernr = resultSet.getInt("ordernumber");

        for (int i = 0; i < orders.size(); i++)
        {

          if (orders.get(i).getOrdernumber() == ordernr)
          {
            FoodItem foodItem = new FoodItem(resultSet.getString("fooditemname"),
                resultSet.getDouble("fooditemprice"), resultSet.getString("fooditemdescription"));
            orders.get(i).addFoodItem(foodItem);
            orders.get(i).setTotalPrice(orders.get(i).getTotalPrice() + foodItem.getPrice());
            found = true;
            break;

          }
        }

        if (!found)
        {

          Order order = new Order();
          order.setOrderNumber(resultSet.getInt("ordernumber"));
          order.setActive(resultSet.getBoolean("activeOrder"));
          order.setCustomer(resultSet.getString("username"));

          FoodItem foodItem = new FoodItem(resultSet.getString("fooditemname"),
              resultSet.getDouble("fooditemprice"), resultSet.getString("fooditemdescription"));

          order.addFoodItem(foodItem);
          order.setTotalPrice(order.getTotalPrice() + foodItem.getPrice());

          orders.add(order);
        }
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    System.out.println(orders.size());
    return orders;
  }

 @Override public void completeOrder(Order order)
  {
    try(java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement("update orders set activeorder = false where ordernumber = ?;");
      preparedStatement.setInt(1, order.getOrdernumber());
      preparedStatement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
