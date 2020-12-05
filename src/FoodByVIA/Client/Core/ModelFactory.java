package FoodByVIA.Client.Core;

import FoodByVIA.Client.Model.AddMenu.AddMenuModel;
import FoodByVIA.Client.Model.AddMenu.AddMenuModelImpl;
import FoodByVIA.Client.Model.Login.LoginModel;
import FoodByVIA.Client.Model.Login.LoginModelImpl;
import FoodByVIA.Client.Model.MakeOrder.MakeOrderModel;
import FoodByVIA.Client.Model.MakeOrder.MakeOrderModelImpl;
import FoodByVIA.Client.Model.RegisterUser.RegisterUserModel;
import FoodByVIA.Client.Model.RegisterUser.RegisterUserModelImpl;

public class ModelFactory
{
  private final ClientFactory cf;
  private AddMenuModel addMenuModel;
  private RegisterUserModel registerUserModel;
  private LoginModel loginModel;
  private MakeOrderModel makeOrderModel;

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
}
