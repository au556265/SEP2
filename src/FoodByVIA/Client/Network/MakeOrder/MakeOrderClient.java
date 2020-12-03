package FoodByVIA.Client.Network.MakeOrder;

import FoodByVIA.Shared.Order;

public interface MakeOrderClient
{
  void startClient();
  void createOrder(Order order);
}
