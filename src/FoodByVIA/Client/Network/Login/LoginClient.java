package FoodByVIA.Client.Network.Login;

public interface LoginClient
{
  boolean checkUserInput(String username, String password, String usertype);
  void startClient();
}
