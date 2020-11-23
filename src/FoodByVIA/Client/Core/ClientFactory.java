package FoodByVIA.Client.Core;

import FoodByVIA.Client.Network.AddMenu.AddMenu.AddMenuClient;
import FoodByVIA.Client.Network.AddMenu.AddMenu.AddMenuClientImpl;
import FoodByVIA.Client.Network.RegisterUser.RegisterUserClient;
import FoodByVIA.Client.Network.RegisterUser.RegisterUserClientImpl;

public class ClientFactory
{
  private AddMenuClient addMenuclient;
  private RegisterUserClient registerUserClient;

 public AddMenuClient getAddMenuClient()
  {
    if(addMenuclient == null)
    {
      addMenuclient = new AddMenuClientImpl();
    }
    return addMenuclient;
  }

  public RegisterUserClient getRegisterUserClient()
  {
    if(registerUserClient == null)
    {
      registerUserClient = new RegisterUserClientImpl();
    }
    return registerUserClient;
  }
}
