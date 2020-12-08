package FoodByVIA.Client.View.TableReservation;

import FoodByVIA.Client.Model.MakeOrder.MakeOrderModel;
import FoodByVIA.Client.Model.TableReservation.TableReservationModel;
import FoodByVIA.Shared.Catalogue;
import FoodByVIA.Shared.TableReservation;
import FoodByVIA.Shared.User;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TableReservationViewModel
{
  private List<Integer> numberOfPeople;
  private List<String> floor;
  private StringProperty username;
  private ObservableList<TableReservation> tables;
  private StringProperty message;

  private TableReservationModel model;
  private Catalogue catalogue;
  private User user;

  public TableReservationViewModel(TableReservationModel model)
  {
    this.model = model;
    numberOfPeople = new ArrayList<>();
    floor = new ArrayList<>();
    username = new SimpleStringProperty();
    tables = FXCollections.observableArrayList();
    message = new SimpleStringProperty();

    numberOfPeople.add(1);
    numberOfPeople.add(2);
    numberOfPeople.add(4);
    numberOfPeople.add(6);
    numberOfPeople.add(8);
    floor.add("Live Music");
    floor.add("Kids Zone");
    floor.add("Family Zone");
    floor.add("Couple Zone");

    catalogue = Catalogue.getInstance();
    user = catalogue.getCurrentUser();
    username.setValue(user.getUsername());

    model.addPropertyChangeListener("TableBookingConfirmation", this::bookingConfirmation);
    model.addPropertyChangeListener("AvailableTables", this::addTables);
  }

  private void bookingConfirmation(PropertyChangeEvent evt)
  {
    String confirmation = (String) evt.getNewValue();
    Platform.runLater(() -> message.setValue(confirmation));
  }

  private void addTables(PropertyChangeEvent evt)
  {
    ArrayList<TableReservation> tableList = (ArrayList<TableReservation>) evt.getNewValue();
    Platform.runLater(() -> tables.setAll(tableList));
  }

  public List<Integer> getNumberOfPeople()
  {
    return numberOfPeople;
  }

  public List<String> getFloor()
  {
    return floor;
  }

  public StringProperty getUserName()
  {
    return username;
  }

  public void logOut()
  {
    catalogue.removeUser(user);
    username.setValue("");
  }

  public void reserveTable(LocalDate date, int capacity, String zone, String tableId)
  {
    TableReservation table = new TableReservation(username.getValue(), date, capacity, zone, tableId);
    model.reserveTable(table);
  }

  public void clear()
  {
    tables.removeAll();
  }

  public void search(LocalDate date, int capacity, String floor)
  {
    model.search(date, capacity, floor);
  }

  public ObservableList<TableReservation> getAvailableTable()
  {
    return tables;
  }

  public StringProperty getMessage()
  {
    return message;
  }
}
