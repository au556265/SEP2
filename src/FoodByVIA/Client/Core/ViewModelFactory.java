package FoodByVIA.Client.Core;

import FoodByVIA.Client.View.RegisterUser.RegisterUserViewModel;
import FoodByVIA.Client.View.addMenu.AddMenuViewModel;

public class ViewModelFactory
{
  private AddMenuViewModel addMenuViewModel;
  private RegisterUserViewModel registerUserViewModel;
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
}
