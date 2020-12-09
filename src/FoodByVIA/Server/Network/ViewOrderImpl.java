package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.ViewOrder.ViewOrderServerModel;
import FoodByVIA.Shared.Network.CallBack.ViewOrderCallBack;
import FoodByVIA.Shared.Network.ViewOrder.ViewOrderServer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;

public class ViewOrderImpl implements ViewOrderServer
{
  private ViewOrderServerModel model;
  private ViewOrderCallBack client;

  public ViewOrderImpl(ViewOrderServerModel model, ViewOrderCallBack client)
      throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.model = model;
    this.client = client;
  }

  @Override public void getAllOrders(Boolean isActive,LocalDate localDate)
  {
    model.getAllOrders(isActive,localDate);
  }
}
