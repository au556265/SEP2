package FoodByVIA.DAO.Persistance.Order;

import FoodByVIA.Shared.Order;

import java.time.LocalDate;
import java.util.ArrayList;

public interface OrderDAO
{
  void createOrder(Order order);
  ArrayList<Order> getAllActiveOrders(Boolean isActive, LocalDate localDate1);
  void completeOrder(Order order);
}
