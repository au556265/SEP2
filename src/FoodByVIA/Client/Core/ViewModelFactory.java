package FoodByVIA.Client.Core;

import FoodByVIA.Client.Model.MakeOrder.MakeOrderModel;
import FoodByVIA.Client.View.Login.LoginViewModel;
import FoodByVIA.Client.View.ManageOrder.ManageOrderViewModel;
import FoodByVIA.Client.View.RegisterUser.RegisterUserViewModel;
import FoodByVIA.Client.View.SelectOrder.MakeOrderViewModel;
import FoodByVIA.Client.View.TableReservation.TableReservationViewModel;
import FoodByVIA.Client.View.addMenu.AddMenuViewModel;

public class ViewModelFactory
{
  private AddMenuViewModel addMenuViewModel;
  private RegisterUserViewModel registerUserViewModel;
  private LoginViewModel loginViewModel;
  private MakeOrderViewModel selectOrderViewModel;
  private TableReservationViewModel tableReservationViewModel;
  private ManageOrderViewModel manageOrderViewModel;
  private ModelFactory mf;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public AddMenuViewModel getAddMenuViewModel() {
    if(addMenuViewModel == null) {
      addMenuViewModel = new AddMenuViewModel(mf.getAddMenuModel());
    }
    return addMenuViewModel;
  }

  public RegisterUserViewModel getRegisterUserViewModel()
  {
    if(registerUserViewModel == null)
    {
      registerUserViewModel = new RegisterUserViewModel(mf.getRegisterUserModel());
    }
    return registerUserViewModel;
  }

  public LoginViewModel getLoginViewModel()
  {
    if(loginViewModel == null)
    {
      loginViewModel = new LoginViewModel(mf.getLoginModel());
    }
    return loginViewModel;
  }

  public MakeOrderViewModel getSelectOrderViewModel()
  {
    if(selectOrderViewModel == null)
    {
      selectOrderViewModel = new MakeOrderViewModel(mf.getMakeOrderModel());
    }
    return selectOrderViewModel;
  }

  public TableReservationViewModel getTableReservationViewModel()
  {
    if(tableReservationViewModel == null)
    {
      tableReservationViewModel = new TableReservationViewModel(mf.getTableReservationModel());
    }
    return tableReservationViewModel;
  }
  public ManageOrderViewModel getManageOrderViewModel()
  {
    if (manageOrderViewModel == null)
    {
      new ManageOrderViewModel(mf.getManageOrderModel());
    }
    return manageOrderViewModel;
  }
}
