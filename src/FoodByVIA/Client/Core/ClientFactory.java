package FoodByVIA.Client.Core;

import FoodByVIA.Client.Network.AddMenu.AddMenu.AddMenuClient;
import FoodByVIA.Client.Network.AddMenu.AddMenu.AddMenuClientImpl;

public class ClientFactory
{
  private AddMenuClient client;

  @SuppressWarnings("WeakerAccess") public AddMenuClient getAddMenuClient()
  {
    if(client == null)
    {
      client = new AddMenuClientImpl();
    }
    return client;
  }
}
