package FoodByVIA.Shared;

import java.io.Serializable;

public class Catalogue implements Serializable
{
  private static Catalogue instance;
  private User currentUser;

  private Catalogue()
  {
  }

  public static synchronized Catalogue getInstance()
  {
    if (instance == null)
    {
      instance = new Catalogue();
    }
    return instance;
  }

  public void saveCurrentUser(User user)
  {
    this.currentUser = user;
  }

  public User getCurrentUser()
  {
    return currentUser;
  }

  public void removeUser(User user)
  {
    this.currentUser = null;
  }
}
