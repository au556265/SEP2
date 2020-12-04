package FoodByVIA.Server.Model.MakeOrder;

import FoodByVIA.Shared.Order;
import FoodByVIA.Shared.Util.PropertyChangeSubject;

public interface MakeOrderServerModel extends PropertyChangeSubject
{
  void createOrder(Order order);
}
