package FoodByVIA.Client.View.TableReservation;

import FoodByVIA.Client.Core.ViewHandler;
import FoodByVIA.Client.Core.ViewModelFactory;
import FoodByVIA.Client.View.ViewController;
import FoodByVIA.Shared.Catalogue;
import FoodByVIA.Shared.TableReservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class TableReservationViewController implements ViewController
{
  @FXML private DatePicker chosenDate;
  @FXML private Label userName;
  @FXML private ComboBox<Integer> numberOfPeople;
  @FXML private ComboBox<String> floor;

  private TableReservationViewModel viewModel;
  private ViewHandler vh;

  @FXML private void onConfirm(ActionEvent actionEvent)
  {
    //TableReservation tr = new TableReservation(numberOfPeople.getSelectionModel().getSelectedItem(),
        //floor.getSelectionModel().getSelectedItem())
    viewModel.reserveTable();
  }

  @FXML private void onCancel(ActionEvent actionEvent)
  {
    //ToDo figure out what you want to do with cancel
  }

  @FXML private void onSwitchToTakeaway(ActionEvent actionEvent)
  {
    vh.openToSelectOrderScene();
  }

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
   // viewModel = vmf.getTableReservationViewModel();
    userName.textProperty().bindBidirectional(viewModel.getUserName());
    numberOfPeople.getItems().addAll(viewModel.getNumberOfPeople());
    floor.getItems().addAll(viewModel.getFloor());
    chosenDate.getConverter();
  }

  public void onLogout(ActionEvent actionEvent)
  {
    viewModel.logOut();
    vh.openToLoginView();
  }
}
