package FoodByVIA.Client.Network.Login;

import FoodByVIA.Client.Network.NetworkConnection;
import FoodByVIA.Shared.Network.Login.LoginServer;

import java.rmi.RemoteException;

public class LoginClientImpl implements LoginClient
{
  private LoginServer loginServer;
  private NetworkConnection networkConnection;

  public LoginClientImpl()
  {
    networkConnection = NetworkConnection.getInstance();
  }

  @Override public void startClient()
  {
    try
    {
      loginServer = networkConnection.getServerInterface().getLoginServerImpl();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public boolean checkUserInput(String username, String password,
      String usertype)
  {
    try
    {
      return loginServer.checkUserInput(username,password,usertype);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not contact to Server");
    }
  }
}
