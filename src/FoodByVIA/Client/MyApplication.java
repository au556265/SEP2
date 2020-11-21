package FoodByVIA.Client;

import FoodByVIA.Client.Core.ClientFactory;
import FoodByVIA.Client.Core.ModelFactory;
import FoodByVIA.Client.Core.ViewHandler;
import FoodByVIA.Client.Core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
  public void start(Stage primaryStage) throws Exception
  {
    ClientFactory clientFactory = new ClientFactory();
    ModelFactory mf = new ModelFactory(clientFactory);
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);

    vh.start();
  }
}
