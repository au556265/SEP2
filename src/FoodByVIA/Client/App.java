package FoodByVIA.Client;

import FoodByVIA.Client.Core.ClientFactory;
import FoodByVIA.Client.Core.ModelFactory;
import FoodByVIA.Client.Core.ViewHandler;
import FoodByVIA.Client.Core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    ClientFactory cf = new ClientFactory();
    ModelFactory mf = new ModelFactory(cf);
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);

    vh.start();
  }
}
