package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.RegisterUser.RegisterUserServerModel;
import FoodByVIA.Shared.Network.RegisterUser.RegisterUserServer;
import FoodByVIA.Shared.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class RegisterUserServerImpl implements RegisterUserServer
{
  private RegisterUserServerModel registerUserServerModel;

  public RegisterUserServerImpl(RegisterUserServerModel registerUserServerModel)
      throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.registerUserServerModel = registerUserServerModel;
  }

  @Override public void addUser(User user)
  {
    registerUserServerModel.addUser(user);
  }
}
