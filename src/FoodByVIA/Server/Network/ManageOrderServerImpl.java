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
    model.addPropertyChangeListener("AllOrders", this::addOrders);
    model.addPropertyChangeListener("CompleteOrder", this::complete);
    model.addPropertyChangeListener("CurrentOrder", this::addOrders);
    model.addPropertyChangeListener("ViewOrderMessage", this::complete);
  }

  @Override public void registerClient(ManageOrderCallBack client)
  {
    this.client = client;
  }

  @Override public void search(boolean isActive, LocalDate date)
  {
    model.search(isActive, date);
  }

  @Override public void completeOrder(Order order)
  {
    model.completeOrder(order);
  }

  private void complete(PropertyChangeEvent evt)
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

  private void addOrders(PropertyChangeEvent evt)
  {
    try
    {
      ArrayList<Order> orders = (ArrayList<Order>) evt.getNewValue();

      client.addOrders(orders);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
