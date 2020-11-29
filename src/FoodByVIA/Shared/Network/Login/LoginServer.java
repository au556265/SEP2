package FoodByVIA.Shared.Network.Login;

public interface LoginServer
{
  boolean checkUserInput(String username, String password, String usertype);
}
