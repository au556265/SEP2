package FoodByVIA.Server;

import FoodByVIA.DAO.Persistance.User.UserDAO;
import FoodByVIA.DAO.Persistance.User.UserDaoManager;
import FoodByVIA.Server.Model.Login.LoginServerModel;
import FoodByVIA.Server.Model.Login.LoginServerModelImpl;
import FoodByVIA.Server.Network.LoginServerImpl;
import FoodByVIA.Shared.Network.Login.LoginServer;

import java.rmi.RemoteException;

public class DummyTest
{
  public static void main(String[] args) throws RemoteException
  {
    UserDAO userDAO = new UserDaoManager();
    LoginServerModel loginServerModel = new LoginServerModelImpl(userDAO);
    LoginServer loginServer = new LoginServerImpl(loginServerModel);

    boolean santosh = loginServer.checkUserInput("sante", "123456", "Employee");
    boolean priyanka = loginServer.checkUserInput("Priyanka", "123456", "Employee");

    System.out.println(santosh + "    " + priyanka);
  }

}