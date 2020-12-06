package FoodByVIA.Client.Network.MakeOrder;

import FoodByVIA.Shared.Order;
import FoodByVIA.Shared.Util.PropertyChangeSubject;

public interface MakeOrderClient extends PropertyChangeSubject
{
  void startClient();
  void createOrder(Order order);
  void showMenu();
}
