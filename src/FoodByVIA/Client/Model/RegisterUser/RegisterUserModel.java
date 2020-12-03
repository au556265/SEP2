package FoodByVIA.Client.Model.RegisterUser;

import FoodByVIA.Shared.User;
import FoodByVIA.Shared.Util.PropertyChangeSubject;

public interface RegisterUserModel extends PropertyChangeSubject
{
  void addUser(User user);
}
