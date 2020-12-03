package FoodByVIA.Client.Network.Login;

import FoodByVIA.Shared.Util.PropertyChangeSubject;

public interface LoginClient extends PropertyChangeSubject
{
  boolean checkUserInput(String username, String password, String usertype);
  void startClient();
}
