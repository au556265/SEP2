package FoodByVIA.Client.Core;

import FoodByVIA.Client.Model.AddMenu.AddMenuModel;
import FoodByVIA.Client.Model.AddMenu.AddMenuModelImpl;

public class ModelFactory
{
  private final ClientFactory cf;
  private AddMenuModel clientModel;

  public ModelFactory(ClientFactory cf)
  {
    this.cf = cf;
  }

  @SuppressWarnings("WeakerAccess") public AddMenuModel getClientModel()
  {
    if(clientModel == null)
    {
      clientModel = new AddMenuModelImpl(cf. getAddMenuClient());
    }
    return clientModel;
  }
}
