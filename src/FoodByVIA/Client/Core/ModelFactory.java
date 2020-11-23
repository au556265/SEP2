package FoodByVIA.Client.Core;

import FoodByVIA.Client.Model.AddMenu.AddMenuModel;
import FoodByVIA.Client.Model.AddMenu.AddMenuModelImpl;

public class ModelFactory
{
  private final ClientFactory cf;
  private AddMenuModel addMenuModel;

  public ModelFactory(ClientFactory cf)
  {
    this.cf = cf;
  }

  public AddMenuModel getAddMenuModel()
  {
    if(addMenuModel == null)
    {
      addMenuModel = new AddMenuModelImpl(cf. getAddMenuClient());
    }
    return addMenuModel;
  }
}
