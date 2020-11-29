package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.Login.LoginServerModel;
import FoodByVIA.Shared.Network.Login.LoginServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginServerImpl implements LoginServer
{
  private LoginServerModel model;

  public LoginServerImpl(LoginServerModel model) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.model = model;
  }

  @Override public boolean checkUserInput(String username, String password,
      String usertype)
  {
    return model.checkUserInput(username, password, usertype);
  }
}
