package FoodByVIA.Shared;

import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Catalogue implements Serializable
{
  private static Catalogue instance;
  private User currentUser;
  private static Lock lock = new ReentrantLock();

  private Catalogue() {
  }

  public static Catalogue getInstance()
  {
    if (instance == null)
    {
      synchronized (lock)
      {
        if(instance == null)
        {
          instance = new Catalogue();
        }
      }
    }
    return instance;
  }

  public void saveCurrentUser(User user)
  {
    if(currentUser != null)
    {
      currentUser = null;
    }
    this.currentUser = user;
  }

  public User getCurrentUser()
  {
    return currentUser;
  }

  public void removeUser(User user)
  {
    if(currentUser == user)
    {
      currentUser = null;
    }
  }
}
