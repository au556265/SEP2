package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.Login.LoginServerModel;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Network.Login.LoginServer;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginServerImpl implements LoginServer
{
  private LoginServerModel model;
  private MessageCallBack client;

  public LoginServerImpl(LoginServerModel model, MessageCallBack client) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.model = model;
    this.client = client;
  }

  @Override public void registerClient(MessageCallBack client)
  {
    this.client = client;
    model.addPropertyChangeListener("LoginMessage", this::throwMessage);
  }

  private void throwMessage(PropertyChangeEvent evt)
  {
    try
    {
      String message = (String) evt.getNewValue();
      client.getMessage(message);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public boolean checkUserInput(String username, String password,
      String usertype)
  {
    return model.checkUserInput(username, password, usertype);
  }
}
