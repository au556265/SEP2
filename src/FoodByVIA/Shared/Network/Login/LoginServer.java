package FoodByVIA.Shared.Network.Login;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginServer extends Remote
{
  boolean checkUserInput(String username, String password, String usertype) throws
      RemoteException;
}
