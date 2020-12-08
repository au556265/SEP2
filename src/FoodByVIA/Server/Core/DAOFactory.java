package FoodByVIA.Server.Core;

import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDAO;
import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDaoManager;
import FoodByVIA.DAO.Persistance.Order.OrderDAO;
import FoodByVIA.DAO.Persistance.Order.OrderDAOManager;
import FoodByVIA.DAO.Persistance.TableReservation.TableReservationDAO;
import FoodByVIA.DAO.Persistance.TableReservation.TableReservationDAOManager;
import FoodByVIA.DAO.Persistance.User.UserDAO;
import FoodByVIA.DAO.Persistance.User.UserDaoManager;

public class DAOFactory
{
  private FoodItemDAO foodItemDAO;
  private UserDAO userDAO;
  private OrderDAO orderDAO;
  private TableReservationDAO tableReservationDAO;

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
      userDAO = new UserDaoManager();
    }
    return userDAO;
  }

  public OrderDAO getOrderDAO()
  {
    if(orderDAO == null)
    {
      orderDAO = new OrderDAOManager();
    }
    return orderDAO;
  }

  public TableReservationDAO getTableReservationDAO()
  {
    if (tableReservationDAO == null)
    {
      tableReservationDAO = new TableReservationDAOManager();
    }
    return tableReservationDAO;
  }
}
