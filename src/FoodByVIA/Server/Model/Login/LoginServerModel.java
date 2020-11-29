package FoodByVIA.Server.Model.Login;

import FoodByVIA.Shared.Util.PropertyChangeSubject;

import java.beans.PropertyChangeListener;

public interface LoginServerModel extends PropertyChangeSubject
{
  boolean checkUserInput(String username, String password, String usertype);
}
