package FoodByVIA.Client.Core;

import FoodByVIA.Client.Model.AddMenu.AddMenuModel;
import FoodByVIA.Client.Model.AddMenu.AddMenuModelImpl;
import FoodByVIA.Client.Model.Login.LoginModel;
import FoodByVIA.Client.Model.Login.LoginModelImpl;
import FoodByVIA.Client.Model.MakeOrder.MakeOrderModel;
import FoodByVIA.Client.Model.MakeOrder.MakeOrderModelImpl;
import FoodByVIA.Client.Model.ManageOrder.ManageOrderModel;
import FoodByVIA.Client.Model.ManageOrder.ManageOrderModelImpl;
import FoodByVIA.Client.Model.RegisterUser.RegisterUserModel;
import FoodByVIA.Client.Model.RegisterUser.RegisterUserModelImpl;
import FoodByVIA.Client.Model.TableReservation.TableReservationModel;
import FoodByVIA.Client.Model.TableReservation.TableReservationModelImpl;

public class ModelFactory
{
  private final ClientFactory cf;

  private AddMenuModel addMenuModel;
  private RegisterUserModel registerUserModel;
  private LoginModel loginModel;
  private MakeOrderModel makeOrderModel;
  private TableReservationModel tableReservationModel;
  private ManageOrderModel manageOrderModel;

  public ModelFactory(ClientFactory cf)
  {
    this.cf = cf;
  }

  public AddMenuModel getAddMenuModel()
  {
    if(addMenuModel == null)
    {
      addMenuModel = new AddMenuModelImpl(cf.getAddMenuClient());
    }
    return addMenuModel;
  }

  public RegisterUserModel getRegisterUserModel()
  {
    if(registerUserModel == null)
    {
      registerUserModel = new RegisterUserModelImpl(cf.getRegisterUserClient());
    }
    return registerUserModel;
  }

  public LoginModel getLoginModel()
  {
    if(loginModel == null)
    {
      loginModel = new LoginModelImpl(cf.getLoginClient());
    }
    return loginModel;
  }

  public MakeOrderModel getMakeOrderModel()
  {
    if(makeOrderModel == null)
    {
      makeOrderModel = new MakeOrderModelImpl(cf.getMakeOrderClient());
    }
    return makeOrderModel;
  }

  public TableReservationModel getTableReservationModel()
  {
    if(tableReservationModel == null)
    {
      tableReservationModel = new TableReservationModelImpl(cf.getTableReservationClient());
    }
    return tableReservationModel;
  }

  public ManageOrderModel getManageOrderModel()
  {
    if (manageOrderModel== null)
    {
      manageOrderModel= new ManageOrderModelImpl(cf.getManageOrderClient());
    }
    return manageOrderModel;
  }

}
