package FoodByVIA.Server;

import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDAO;
import FoodByVIA.DAO.Persistance.FoodItem.FoodItemDaoManager;
import FoodByVIA.Server.Model.AddMenu.AddMenuServerModelImpl;
import FoodByVIA.Server.Network.AddMenuServerImpl;

import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args)
      throws RemoteException
  {
    FoodItemDAO foodItemDAO = new FoodItemDaoManager();
    AddMenuServerImpl addMenuServer = new AddMenuServerImpl(new AddMenuServerModelImpl(foodItemDAO));
    addMenuServer.start();
  }
}
