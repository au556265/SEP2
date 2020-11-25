package FoodByVIA.Shared.Network.RegisterUser;

import FoodByVIA.Shared.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RegisterUserServer extends Remote
{
  void addUser(User user) throws RemoteException;
}
