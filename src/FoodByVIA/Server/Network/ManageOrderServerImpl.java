package FoodByVIA.Server.Network;

import FoodByVIA.Server.Model.ManageOrder.ManageOrderServerModel;
import FoodByVIA.Shared.Network.CallBack.ManageOrderCallBack;
import FoodByVIA.Shared.Network.ManageOrder.ManageOrderServer;
import FoodByVIA.Shared.Order;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManageOrderServerImpl implements ManageOrderServer
{
  private ManageOrderServerModel model;
  private ManageOrderCallBack client;

  public ManageOrderServerImpl(ManageOrderServerModel model, ManageOrderCallBack client)
      throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.model = model;
    this.client = client;
  }

 /* @Override public void getAllOrders(Boolean isActive,LocalDate localDate)
  {
    model.getAllOrders(isActive,localDate);
  }*/

  @Override public void registerClient(ManageOrderCallBack client)
  {
    this.client = client;
  }

  @Override public void search(boolean isActive, LocalDate date)
  {
    model.search(isActive, date);
    model.addPropertyChangeListener("RequiredOrder", this::addOrders);
  }

  private void addOrders(PropertyChangeEvent evt)
  {
    ArrayList<Order> orders = (ArrayList<Order>) evt.getNewValue();
    try
    {
      client.addOrders(orders);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
