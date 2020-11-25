package FoodByVIA.Client.Network.RegisterUser;

import FoodByVIA.Client.Network.NetworkConnection;
import FoodByVIA.Shared.Network.RegisterUser.RegisterUserServer;
import FoodByVIA.Shared.User;

import java.rmi.RemoteException;

public class RegisterUserClientImpl implements RegisterUserClient
{
  private NetworkConnection networkConnection;
  private RegisterUserServer registerUserServer;

  public RegisterUserClientImpl()
  {
    networkConnection = NetworkConnection.getInstance();
  }

  @Override public void startClient()
  {
    try
    {
      registerUserServer = networkConnection.getServerInterface().getRegisterUserServerImpl();

    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addUser(User user)
  {
    try
    {
      registerUserServer.addUser(user);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
