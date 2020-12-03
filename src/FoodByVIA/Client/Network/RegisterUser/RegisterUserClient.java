package FoodByVIA.Client.Network.RegisterUser;

import FoodByVIA.Shared.User;
import FoodByVIA.Shared.Util.PropertyChangeSubject;

public interface RegisterUserClient extends PropertyChangeSubject
{
  void addUser(User user);
  void startClient();
}
