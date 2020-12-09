package FoodByVIA.Client.View.TableReservation;

import FoodByVIA.Client.Core.ViewHandler;
import FoodByVIA.Client.Core.ViewModelFactory;
import FoodByVIA.Client.View.ViewController;
import FoodByVIA.Shared.Catalogue;
import FoodByVIA.Shared.TableReservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.Calendar;

public class TableReservationViewController implements ViewController
{
  @FXML private ListView<TableReservation> availableTabel;
  @FXML private Label messegeLabel;
  @FXML private DatePicker chosenDate;
  @FXML private Label userName;
  @FXML private ComboBox<Integer> numberOfPeople;
  @FXML private ComboBox<String> floor;

  private TableReservationViewModel viewModel;
  private ViewHandler vh;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    viewModel = vmf.getTableReservationViewModel();

    userName.textProperty().bindBidirectional(viewModel.getUserName());
    numberOfPeople.getItems().addAll(viewModel.getNumberOfPeople());
    floor.getItems().addAll(viewModel.getFloor());
    availableTabel.setItems(viewModel.getAvailableTable());
    messegeLabel.textProperty().bindBidirectional(viewModel.getMessage());
  }

  @FXML private void onConfirm(ActionEvent actionEvent)
  {
    TableReservation id = availableTabel.getSelectionModel().getSelectedItem();
    if(id == null)
    {
      messegeLabel.setText("Please select the table first");
    }
    else
    {
      viewModel.reserveTable(chosenDate.getValue(),
          numberOfPeople.getSelectionModel().getSelectedItem(),
          floor.getSelectionModel().getSelectedItem(), id.getTableID());
    }
  }

  @FXML private void onCancel(ActionEvent actionEvent)
  {
    viewModel.clear();
  }

  @FXML private void onSwitchToTakeaway(ActionEvent actionEvent)
  {
    viewModel.clear();
    vh.openToSelectOrderScene();
  }

  public void onLogout(ActionEvent actionEvent)
  {
    viewModel.logOut();
    vh.openToLoginView();
  }

  public void searchButton(ActionEvent actionEvent)
  {
    LocalDate currentDate = LocalDate.now();
    if(chosenDate.getValue().isBefore(currentDate) || chosenDate.getValue().isEqual(currentDate))
    {
      messegeLabel.setText("Please choose a valid date. (You cannot book a table for today or before.)");
    }
    else if(numberOfPeople.getSelectionModel().getSelectedItem() == null || floor.getSelectionModel().getSelectedItem() == null)
    {
      messegeLabel.setText("Please choose the zone and number of people.");
    }
    else
    {
      viewModel.search(chosenDate.getValue(),
          numberOfPeople.getSelectionModel().getSelectedItem(),
          floor.getSelectionModel().getSelectedItem());
    }
  }
}
