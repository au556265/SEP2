package FoodByVIA.Client.Model.Login;

import FoodByVIA.Shared.Util.PropertyChangeSubject;

public interface LoginModel extends PropertyChangeSubject
{
  boolean checkUserInput(String username, String password, String usertype);
}
