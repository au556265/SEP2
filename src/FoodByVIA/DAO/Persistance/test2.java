package FoodByVIA.DAO.Persistance;

import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDAO;
import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDaoManager;
import FoodByVIA.DAO.Persistance.Order.OrderDAO;
import FoodByVIA.DAO.Persistance.Order.OrderDAOManager;
import FoodByVIA.DAO.Persistance.TableReservation.TableReservationDAO;
import FoodByVIA.DAO.Persistance.TableReservation.TableReservationDAOManager;
import FoodByVIA.DAO.Persistance.User.UserDAO;
import FoodByVIA.DAO.Persistance.User.UserDaoManager;
import FoodByVIA.Shared.*;

public class test2
{
  public static void main(String[] args)
  {
    /*
    FoodItemDAO foodItemDAO = new FoodItemDaoManager();
    System.out.println(foodItemDAO.getAllFoodItems());
    UserDAO userDAO = new UserDaoManager();
    System.out.println(userDAO.getAllUsers());
    userDAO.checkLogin("Chris", "1234", "customer");
    System.out.println(userDAO.checkLogin("Chris", "12345", "customer"));
    System.out.println(userDAO.checkLogin("Chris", "1234", "employee"));

     */

/*    MyDate myDate = new MyDate(2020,12,24);
    User user = new User("Fatema","bellisvej10","25885212","sare@hotmail.com","sara","123456","Customer");
    FoodItem foodItem = new FoodItem("pizza",60, null);
    FoodItem foodItem1 = new FoodItem("lasagna",60, null);
    Order order = new Order(user,0,myDate);
    order.addFoodItem(foodItem1);
    order.addFoodItem(foodItem);
    OrderDAO orderDAO = new OrderDAOManager();
    orderDAO.createOrder(order);

 */

    MyDate myDate = new MyDate(2020,12,26);
    User user = new User("sara","bellisvej","12345678", "sare@hotmail.com","sara","123456","Customer");
    TableReservation tableReservation = new TableReservation(user,myDate,2,"Couple Zone");
    TableReservationDAO tableReservationDAO = new TableReservationDAOManager();
    tableReservationDAO.reserveTable(tableReservation);


  }
}
