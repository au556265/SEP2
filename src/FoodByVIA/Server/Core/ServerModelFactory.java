package FoodByVIA.Server.Core;

import FoodByVIA.Server.Model.AddMenu.AddMenuServerModel;
import FoodByVIA.Server.Model.AddMenu.AddMenuServerModelImpl;
import FoodByVIA.Server.Model.Login.LoginServerModel;
import FoodByVIA.Server.Model.Login.LoginServerModelImpl;
import FoodByVIA.Server.Model.MakeOrder.MakeOrderServerModel;
import FoodByVIA.Server.Model.MakeOrder.MakeOrderServerModelImpl;
import FoodByVIA.Server.Model.RegisterUser.RegisterUserServerModel;
import FoodByVIA.Server.Model.RegisterUser.RegisterUserServerModelImpl;

public class ServerModelFactory
{
  private AddMenuServerModel addMenuServerModel;
  private RegisterUserServerModel registerUserServerModel;
  private LoginServerModel loginServerModel;
  private MakeOrderServerModel makeOrderServerModel;

  private DAOFactory daoFactory;

  public ServerModelFactory(DAOFactory daoFactory)
  {
    this.daoFactory = daoFactory;
  }

  public AddMenuServerModel getAddMenuServerModel()
  {
    if(addMenuServerModel == null)
    {
      addMenuServerModel = new AddMenuServerModelImpl(daoFactory.getFoodItemDAO());
    }
    return addMenuServerModel;
  }

  public RegisterUserServerModel getRegisterUserServerModel()
  {
    if(registerUserServerModel == null)
    {
      registerUserServerModel = new RegisterUserServerModelImpl(daoFactory.getUserDAO());
    }
    return registerUserServerModel;
  }

  public LoginServerModel getLoginServerModel()
  {
    if(loginServerModel == null)
    {
      loginServerModel = new LoginServerModelImpl(daoFactory.getUserDAO());
    }
    return loginServerModel;
  }

  public MakeOrderServerModel getMakeOrderServerModel()
  {
    if(makeOrderServerModel == null)
    {
      makeOrderServerModel = new MakeOrderServerModelImpl(daoFactory.getOrderDAO(), daoFactory.getFoodItemDAO());
    }
    return makeOrderServerModel;
  }
}
