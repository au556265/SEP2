package FoodByVIA.Client.Core;

import FoodByVIA.Client.View.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Scene addMenuScene;
  private Stage mainStage;

  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  public void start()
  {
    mainStage = new Stage();
    openAddMenuView();
  }

  private Parent loadFXML(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController ctrl = loader.getController();
    ctrl.init(this, vmf);
    return root;
  }


  public void openAddMenuView() {
    if(addMenuScene == null)
    {
      try
      {
        Parent root = loadFXML("../View/addMenu/addMenuView.fxml");

        addMenuScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      mainStage.setTitle("Add Menu");
    }
    mainStage.setScene(addMenuScene);
    mainStage.show();
  }

}
