package FoodByVIA.Shared;

import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Catalogue implements Serializable
{
  private static Catalogue instance;
  private static Lock lock;
  private User currentUser;

  private Catalogue()
  {
    lock = new ReentrantLock();
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
    currentUser = user;
  }

  public User getCurrentUser()
  {
    return currentUser;
  }

  public void removeUser(User user)
  {
    currentUser = null;
  }
}
