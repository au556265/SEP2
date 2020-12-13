package FoodByVIA.Client.Core;

import FoodByVIA.Client.Network.AddMenu.AddMenuClient;
import FoodByVIA.Client.Network.AddMenu.AddMenuClientImpl;
import FoodByVIA.Client.Network.Login.LoginClient;
import FoodByVIA.Client.Network.Login.LoginClientImpl;
import FoodByVIA.Client.Network.MakeOrder.MakeOrderClient;
import FoodByVIA.Client.Network.MakeOrder.MakeOrderClientImpl;
import FoodByVIA.Client.Network.ManageOrder.ManageOrderClient;
import FoodByVIA.Client.Network.ManageOrder.ManageOrderClientImpl;
import FoodByVIA.Client.Network.RegisterUser.RegisterUserClient;
import FoodByVIA.Client.Network.RegisterUser.RegisterUserClientImpl;
import FoodByVIA.Client.Network.TableReservation.TableReservationClient;
import FoodByVIA.Client.Network.TableReservation.TableReservationClientImpl;

public class ClientFactory
{
  private AddMenuClient addMenuclient;
  private RegisterUserClient registerUserClient;
  private LoginClient loginClient;
  private MakeOrderClient makeOrderClient;
  private TableReservationClient tableReservationClient;
  private ManageOrderClient manageOrderClient;

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

  public LoginClient getLoginClient()
  {
    if(loginClient == null)
    {
      loginClient = new LoginClientImpl();
    }
    return loginClient;
  }

  public MakeOrderClient getMakeOrderClient()
  {
    if(makeOrderClient == null)
    {
      makeOrderClient = new MakeOrderClientImpl();
    }
    return makeOrderClient;
  }

  public TableReservationClient getTableReservationClient()
  {
    if(tableReservationClient == null)
    {
      tableReservationClient = new TableReservationClientImpl();
    }
    return tableReservationClient;
  }

  public ManageOrderClient getManageOrderClient()
  {
    if(manageOrderClient == null)
    {
      manageOrderClient = new ManageOrderClientImpl();
    }
    return manageOrderClient;
  }
}
