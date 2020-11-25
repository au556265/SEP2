package FoodByVIA.Client.Model.RegisterUser;

import FoodByVIA.Client.Network.RegisterUser.RegisterUserClient;
import FoodByVIA.Shared.User;

public class RegisterUserModelImpl implements RegisterUserModel
{
  private RegisterUserClient client;

  public RegisterUserModelImpl(RegisterUserClient client)
  {
    this.client = client;
    client.startClient();
  }

  @Override public void addUser(User user)
  {
    client.addUser(user);
  }
}
