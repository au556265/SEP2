package FoodByVIA.Server.Model.RegisterUser;

import FoodByVIA.Shared.User;
import FoodByVIA.Shared.Util.PropertyChangeSubject;

public interface RegisterUserServerModel extends PropertyChangeSubject
{
  void addUser(User user);
}
