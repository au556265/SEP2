package FoodByVIA.Server.Network;

import FoodByVIA.Shared.Network.Login.LoginServer;

public class LoginServerImpl implements LoginServer
{
  @Override public boolean checkUserInput(String username, String password,
      String usertype)
  {
    return false;
  }
}
