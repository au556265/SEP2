package FoodByVIA.Client.View.TableReservation;

import FoodByVIA.Client.Model.MakeOrder.MakeOrderModel;
import FoodByVIA.Shared.Catalogue;
import FoodByVIA.Shared.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TableReservationViewModel
{
  private List<Integer> numberOfPeople;
  private List<String> floor;
  private StringProperty username;
  private Date date;

  private MakeOrderModel model;
  private Catalogue catalogue;
  private User user;

  public TableReservationViewModel(MakeOrderModel model)
  {
    this.model = model;
    numberOfPeople = new ArrayList<>();
    floor = new ArrayList<>();
    username = new SimpleStringProperty();

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
    username.setValue(username.getName());
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

  public Date getDate()
  {
    return date;
  }

  public void logOut()
  {
    catalogue.removeUser(user);
    username.setValue("");
  }

  public void reserveTable()
  {
    //TODO add a model and call a method from the model
  }
}
