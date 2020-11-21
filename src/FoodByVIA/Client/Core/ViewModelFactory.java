package FoodByVIA.Client.Core;

import FoodByVIA.Client.View.addMenu.AddMenuViewModel;

public class ViewModelFactory
{
  private AddMenuViewModel addMenuViewModel;
  private ModelFactory mf;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public AddMenuViewModel getAddMenuViewModel() {
    if(addMenuViewModel == null) {
      addMenuViewModel = new AddMenuViewModel(mf.getClientModel());
    }
    return addMenuViewModel;
  }

}
