package FoodByVIA.Client.Network.RegisterUser;

import FoodByVIA.Shared.User;

public interface RegisterUserClient
{
  void addUser(User user);
  void startClient();
}
