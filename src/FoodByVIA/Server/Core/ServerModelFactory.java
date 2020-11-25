package FoodByVIA.Server.Core;

import FoodByVIA.Server.Model.AddMenu.AddMenuServerModel;
import FoodByVIA.Server.Model.AddMenu.AddMenuServerModelImpl;
import FoodByVIA.Server.Model.RegisterUser.RegisterUserServerModel;
import FoodByVIA.Server.Model.RegisterUser.RegisterUserServerModelImpl;

public class ServerModelFactory
{
  private AddMenuServerModel addMenuServerModel;
  private RegisterUserServerModel registerUserServerModel;

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
}
