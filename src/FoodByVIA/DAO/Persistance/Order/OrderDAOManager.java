package FoodByVIA.DAO.Persistance.Order;

import FoodByVIA.Shared.FoodItem;
import FoodByVIA.Shared.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    try(java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement(
              "insert into Orders(username,dateTo) values(?,?);",Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1,order.getCustomer());
      preparedStatement.setObject(2,order.getDate().getLocaldate());
      //execute prepared statement and get ordernumber from it

      preparedStatement.execute();
      ResultSet res = preparedStatement.getGeneratedKeys();
      // add all fooditems and refer them to ordernumber Orders_FoodItems
      while (res.next())
      {
        System.out.println(res.getInt(1));
        ordernumber = res.getInt(1);
      }

    }
    catch(SQLException throwables){
      throwables.printStackTrace();
    }

    if(ordernumber!=0)
    {
      for (FoodItem foodItem : order.getSelectedFoodItems())
      {
        createOrderFood(foodItem, ordernumber);
      }

    }

  }

  private void createOrderFood(FoodItem foodItem, int ordernumber){
    try(java.sql.Connection connection = getConnection())
    {
      PreparedStatement preparedStatement =
          connection.prepareStatement(
              "insert into Orders_FoodItems(ordernumber, foodItemName,amount) values(?,?,?);");
      preparedStatement.setInt(1,ordernumber);
      preparedStatement.setString(2,foodItem.getName());
      preparedStatement.setInt(3,1);
      preparedStatement.execute();


    }
    catch(SQLException throwables){
      throwables.printStackTrace();
    }
  }

/*

  @Override public Order getOrder(int ordernumber)
  {
    try(java.sql.Connection connection = getConnection())
    {
      Order order = new Order(null,0.0,false,null);
      // make a join of the tables order and order_fooditem where ordernumber matches the ordernumber thats passed here.
      // create a new object order

      return order;
    }
    catch(SQLException throwables){

    }
    return null;
  }

  @Override public ArrayList<Order> getAllActiveOrders()
  {
    try(java.sql.Connection connection = getConnection())
    {
      // make a join of the tables order and order_fooditem where active is true
      // itterate through resultset, create order from every resultset row.
      // add order into arraylist and return arraylist.

    }
    catch(SQLException throwables){

    }

    return null;
  }

 */
}
