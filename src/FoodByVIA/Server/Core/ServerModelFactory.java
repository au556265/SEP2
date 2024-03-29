package FoodByVIA.Server.Core;

import FoodByVIA.Server.Model.AddMenu.AddMenuServerModel;
import FoodByVIA.Server.Model.AddMenu.AddMenuServerModelImpl;
import FoodByVIA.Server.Model.Login.LoginServerModel;
import FoodByVIA.Server.Model.Login.LoginServerModelImpl;
import FoodByVIA.Server.Model.MakeOrder.MakeOrderServerModel;
import FoodByVIA.Server.Model.MakeOrder.MakeOrderServerModelImpl;
import FoodByVIA.Server.Model.ManageOrder.ManageOrderServerModel;
import FoodByVIA.Server.Model.ManageOrder.ManageOrderServerModelImpl;
import FoodByVIA.Server.Model.RegisterUser.RegisterUserServerModel;
import FoodByVIA.Server.Model.RegisterUser.RegisterUserServerModelImpl;
import FoodByVIA.Server.Model.TableReservation.TableReservationServerModel;
import FoodByVIA.Server.Model.TableReservation.TableReservationServerModelImpl;

public class ServerModelFactory
{
  private ManageOrderServerModel manageOrderServerModel;
  private AddMenuServerModel addMenuServerModel;
  private RegisterUserServerModel registerUserServerModel;
  private LoginServerModel loginServerModel;
  private MakeOrderServerModel makeOrderServerModel;
  private TableReservationServerModel tableReservationServerModel;

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

  public TableReservationServerModel getTableReservationServerModel()
  {if (tableReservationServerModel == null)
  {
    tableReservationServerModel = new TableReservationServerModelImpl(daoFactory.getTableReservationDAO());
  }
    return tableReservationServerModel;
  }

  public ManageOrderServerModel getManageOrderServerModel()
  {
    if(manageOrderServerModel == null)
    {
      manageOrderServerModel = new ManageOrderServerModelImpl(daoFactory.getOrderDAO());
    }
    return manageOrderServerModel;
  }
}
