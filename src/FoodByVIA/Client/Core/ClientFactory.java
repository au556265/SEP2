package FoodByVIA.Client.Core;

import FoodByVIA.Client.Network.AddMenu.AddMenu.AddMenuClient;
import FoodByVIA.Client.Network.AddMenu.AddMenu.AddMenuClientImpl;

public class ClientFactory
{
  private AddMenuClient addMenuclient;

 public AddMenuClient getAddMenuClient()
  {
    if(addMenuclient == null)
    {
      addMenuclient = new AddMenuClientImpl();
    }
    return addMenuclient;
  }
}
