package FoodByVIA.Client.View.ManageOrder;

import FoodByVIA.Client.Model.ManageOrder.ManageOrderModel;
import FoodByVIA.Shared.Catalogue;
import FoodByVIA.Shared.Order;
import FoodByVIA.Shared.User;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManageOrderViewModel
{
  private ObservableList<Order> orders;
  private StringProperty username;
  private StringProperty message;

  private Catalogue catalogue;
  private User user;

  private ManageOrderModel model;

  public ManageOrderViewModel(ManageOrderModel model)
  {
    this.model=model;

    orders = FXCollections.observableArrayList();
    username = new SimpleStringProperty();
    message = new SimpleStringProperty();

    catalogue = Catalogue.getInstance();
    user = catalogue.getCurrentUser();
    username.setValue(user.getUsername());

    model.addPropertyChangeListener("RequiredOrder", this::addOrders);
    model.addPropertyChangeListener("CompleteOrder", this::completed);
  }

  private void completed(PropertyChangeEvent evt)
  {
    String str = (String) evt.getNewValue();
    Platform.runLater(() -> message.setValue(str));
  }

  private void addOrders(PropertyChangeEvent evt)
  {
    ArrayList<Order> order = (ArrayList<Order>) evt.getNewValue();

    Platform.runLater(() ->
        {
          clear();
          orders.addAll(order);
        }
    );
  }

  public ObservableList<Order> getOrders()
  {
    return orders;
  }

  public StringProperty getusername()
  {
    return username;
  }

  public StringProperty getMessage()
  {
    return message;
  }

  public void logout()
  {
    catalogue.removeUser(user);
    username.setValue("");
    clear();
  }

  public void clear()
  {
    orders.clear();
  }

  public void search(boolean isActive, LocalDate date)
  {
    message.set("");
    clear();
    model.search(isActive, date);
  }

  public void completeOrder(Order order)
  {
    model.completeOrder(order);
    orders.remove(order);
  }
}
