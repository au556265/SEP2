package FoodByVIA.Client.Network.ManageOrder;

import FoodByVIA.Client.Network.NetworkConnection;
import FoodByVIA.Shared.Catalogue;
import FoodByVIA.Shared.Network.CallBack.ManageOrderCallBack;
import FoodByVIA.Shared.Network.MakeOrder.MakeOrderServer;
import FoodByVIA.Shared.Network.ManageOrder.ManageOrderServer;
import FoodByVIA.Shared.Order;
import FoodByVIA.Shared.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManageOrderClientImpl implements ManageOrderClient,
    ManageOrderCallBack
{
  private PropertyChangeSupport support;
  private ManageOrderServer server;
  private NetworkConnection connection;
  private Catalogue catalogue;
  private User user;

  public ManageOrderClientImpl()
  {
    connection = NetworkConnection.getInstance();
    support = new PropertyChangeSupport(this);
    catalogue = Catalogue.getInstance();
    user = catalogue.getCurrentUser();
  }

  @Override public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      server = connection.getServerInterface().getManageOrderServerImpl();
      if(user.getUserType().equalsIgnoreCase("Employee") || user.getUserType()
          .equalsIgnoreCase("Administrator"))
      {
        server.registerClient(this);
      }
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error");
    }
  }

    @Override public void search(boolean isActive, LocalDate date)
  {
    try
    {
      server.search(isActive, date);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void completeOrder(Order order)
  {
    try
    {
      server.completeOrder(order);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void removerPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  @Override public void addOrders(ArrayList<Order> orders)
  {
    support.firePropertyChange("RequiredOrder", null, orders);
  }

  @Override public void getMessage(String message)
  {
    support.firePropertyChange("CompleteOrder", null, message);
  }
}
