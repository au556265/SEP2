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
  private Scene registerUserScene;
  private Scene loginScene;
  private Scene selectOrderScene;
  private Scene tableReservationScene;

  private Stage mainStage;

  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  public void start()
  {
    mainStage = new Stage();
    openToLoginView();
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

  public void openRegisterUserView()
  {
    if(registerUserScene == null)
    {
      try
      {
        Parent root = loadFXML("../View/RegisterUser/RegisterUser.fxml");

        registerUserScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      mainStage.setTitle("Register User");
    }
    mainStage.setScene(registerUserScene);
    mainStage.show();
  }

  public void openToLoginView()
  {
    if(loginScene == null)
    {
      try
      {
        Parent root = loadFXML("../View/Login/LoginView.fxml");

        loginScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      mainStage.setTitle("Login");
    }
    mainStage.setScene(loginScene);
    mainStage.show();
  }

  public void openToSelectOrderScene()
  {
    if(selectOrderScene == null)
    {
      try
      {
        Parent root = loadFXML("../View/SelectOrder/MakeOrderView.fxml");

        selectOrderScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      mainStage.setTitle("Order");
    }
    mainStage.setScene(selectOrderScene);
    mainStage.show();
  }

  public void openToTableReservation()
  {
    if(tableReservationScene == null)
    {
      try
      {
        Parent root = loadFXML("../View/TableReservation/TableReservationView.fxml");

        tableReservationScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      mainStage.setTitle("Order");
    }
    mainStage.setScene(tableReservationScene);
    mainStage.show();
  }


}
