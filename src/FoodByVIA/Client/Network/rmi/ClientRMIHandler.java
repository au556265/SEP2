package FoodByVIA.Client.Network.rmi;

import FoodByVIA.Shared.FoodItem;

import java.beans.PropertyChangeSupport;
import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
//import java.util.ArrayList
/*public class ClientRMIHandler implements RemoteSender
{

  private RemoteCommandList rml;
  private PropertyChangeSupport newOrderSupport = new PropertyChangeSupport(this);
  private PropertyChangeSupport orderUpdateSupport = new PropertyChangeSupport(this);

  public ClientRMIHandler() throws RemoteException, NotBoundException {
    try{
      Registry reg = LocateRegistry.getRegistry("localhost", 1099);
      UnicastRemoteObject.exportObject(this, 0);
      rml = (RemoteCommandList)reg.lookup("point of sales");
    }catch (ConnectException e){
      System.out.println("Connection failed");
    }
  }

  @Override
  public void newOrder(){
    newOrderSupport.firePropertyChange("New Order", null, null);
  }

  @Override
  public void newOrderOrStatusUpdate(){
    orderUpdateSupport.firePropertyChange("Updated order list", null, null);
  }
  public String createItem(FoodItem createdItem) {
    try {
      return rml.createItem(createdItem);
    } catch (RemoteException e) {
      try {
        retryConnection();
        return rml.createItem(createdItem);
      }catch (Exception i){
        i.printStackTrace();
        return "Failed to connect";
      }
    }
  }
}*/
