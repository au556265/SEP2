package FoodByVIA.Client.Network.RegisterUser;

import FoodByVIA.Client.Network.NetworkConnection;
import FoodByVIA.Shared.User;

import java.rmi.RemoteException;

public class RegisterUserClientImpl implements RegisterUserClient
{
  private RegisterUserServer registerUserServer;
  private NetworkConnection connection;

  public RegisterUserClientImpl(){
    connection = NetworkConnection.getInstance();
  }

  @Override public void startClient()
  {
    try
    {
      //UnicastRemoteObject.exportObject(this, 0);
      registerUserServer = connection.getServerInterface().getRegisterUserServerImpl;
      System.out.println("Server Connected");
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
