package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.RegisterUser.RegisterUserServerModelImpl;
import FoodByVIA.Shared.User;

import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RegisterUserServerImpl
{
 private RegisterUserServerModelImpl userServerModel = new RegisterUserServerModelImpl();

  public void addUser(User user){
    userServerModel.addUser(user);
  }

}
