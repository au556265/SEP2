package FoodByVIA.Client.Model.MakeOrder;

import FoodByVIA.Shared.Order;
import FoodByVIA.Shared.Util.PropertyChangeSubject;

public interface MakeOrderModel extends PropertyChangeSubject
{
  void createOrder(Order order);

}
