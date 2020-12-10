package FoodByVIA.Client.View.ManageOrder;

import FoodByVIA.Client.Core.ViewHandler;
import FoodByVIA.Client.Core.ViewModelFactory;
import FoodByVIA.Client.View.ViewController;

public class ManageOrderViewController implements ViewController
{
  private ManageOrderViewModel viewModel;
  private ViewHandler vh;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;

  }
}
