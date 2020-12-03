package FoodByVIA.Client.Model.Login;

import FoodByVIA.Client.Network.Login.LoginClient;

public class LoginModelImpl implements LoginModel
{
  private LoginClient loginClient;

  public LoginModelImpl(LoginClient loginClient){
    this.loginClient=loginClient;
    loginClient.startClient();
  }

  @Override public boolean checkUserInput(String username, String password,
      String usertype)
  {
    return loginClient.checkUserInput(username, password, usertype);
  }
}
