package FoodByVIA.Server.Core;

import FoodByVIA.Server.Model.AddMenu.AddMenuServerModel;
import FoodByVIA.Server.Model.AddMenu.AddMenuServerModelImpl;

public class ServerModelFactory
{
  private AddMenuServerModel addMenuServerModel;

  public ServerModelFactory(){}

  public AddMenuServerModel getAddMenuServerModel()
  {
    if(addMenuServerModel == null)
    {
      addMenuServerModel = new AddMenuServerModelImpl();
    }
    return addMenuServerModel;
  }
}
