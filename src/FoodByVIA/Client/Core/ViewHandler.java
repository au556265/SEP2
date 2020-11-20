package FoodByVIA.Client.Core;

import FoodByVIA.Client.View.addMenu.AddMenuViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Scene AddMenuScene;
  private Stage mainStage;

  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
    mainStage = new Stage();

  }

  public void start()
  {
    openAddMenuView();
    mainStage.show();
  }

  @SuppressWarnings("WeakerAccess") public void openAddMenuView() {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("FoodByVIA.Client.View.addMenu.AddMenuViewController"));
    try {
      Parent root = loader.load();
      AddMenuViewController ctrl = loader.getController();
      ctrl.init(this, vmf.getAddMenuViewModel());
      mainStage.setTitle("Add Menu");
      Scene addMenuScene = new Scene(root);
      mainStage.setScene(addMenuScene);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
