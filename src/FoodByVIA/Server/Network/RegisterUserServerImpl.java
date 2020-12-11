package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.RegisterUser.RegisterUserServerModel;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Network.RegisterUser.RegisterUserServer;
import FoodByVIA.Shared.User;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class RegisterUserServerImpl implements RegisterUserServer
{
  private RegisterUserServerModel model;
  private MessageCallBack client;

  public RegisterUserServerImpl(RegisterUserServerModel model, MessageCallBack client)
      throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.model = model;
    this.client = client;
    model.addPropertyChangeListener("RegisterMessage", this::throwMessage);
  }

  @Override public void registerClient(MessageCallBack client)
  {
    this.client = client;
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

  @Override public void addUser(User user)
  {
    model.addUser(user);
  }
}
