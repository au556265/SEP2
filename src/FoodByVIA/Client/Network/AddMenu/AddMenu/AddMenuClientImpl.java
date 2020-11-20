package FoodByVIA.Client.Network.AddMenu.AddMenu;

import FoodByVIA.Client.Network.AddMenu.AddMenu.AddMenuClient;
import FoodByVIA.Shared.FoodItem;

public class AddMenuClientImpl implements AddMenuClient
{
  private ClientRMIHandler rmiHandler;

  public AddMenuClientImpl(ClientRMIHandler rmiHandler)
  {
    this.rmiHandler = rmiHandler;
  }
  @Override public String AddItem(FoodItem createdItem)
  {
    return rmiHandler.createItem(createdItem);
  }

  @Override public boolean testConnection()
  {
    return rmiHandler.testConnection();
  }
}
