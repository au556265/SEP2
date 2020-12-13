package FoodByVIA.Client.View.SelectOrder;

import FoodByVIA.Client.Model.MakeOrder.MakeOrderModel;
import FoodByVIA.Shared.*;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MakeOrderViewModel
{
  private StringProperty user;
  private ObservableList<FoodItem> menu;
  private DoubleProperty totalPrice;
  private Double price;

  private Catalogue catalogue;
  private User currentUser;

  private MakeOrderModel makeOrderModel;
  private StringProperty message;

  public MakeOrderViewModel(MakeOrderModel makeOrderModel)
  {
    this.makeOrderModel = makeOrderModel;
    user = new SimpleStringProperty();
    message = new SimpleStringProperty();
    menu = FXCollections.observableArrayList();
    totalPrice = new SimpleDoubleProperty();
    price = 0.0;
    makeOrderModel.addPropertyChangeListener("FoodItems", this::addInMenu);
    makeOrderModel.addPropertyChangeListener("OrderNumber", this::addMessage);

    catalogue = Catalogue.getInstance();
    currentUser = catalogue.getCurrentUser();
    user.setValue(currentUser.getUsername());
  }

  private void addMessage(PropertyChangeEvent evt)
  {
    String orderNumber = (String) evt.getNewValue();
    Platform.runLater(() -> message.setValue(orderNumber));
  }

  private void addInMenu(PropertyChangeEvent evt)
  {
    ArrayList<FoodItem> items = (ArrayList<FoodItem>) evt.getNewValue();
    Platform.runLater(() -> menu.setAll(items));
  }

  public void addToTotalPrice(FoodItem item)
  {
    price += item.getPrice();
    totalPrice.setValue(price);
  }

  public StringProperty getUser()
  {
    return user;
  }

  public ObservableList<FoodItem> getMenu()
  {
    return menu;
  }

  public DoubleProperty getTotalPrice()
  {
    return totalPrice;
  }

  public StringProperty getMessage()
  {
    return message;
  }

  public void createOrder(LocalDate date, List<FoodItem> items)
  {
    Order order = new Order(user.getValue(), price, date);
    for(FoodItem item: items)
    {
      order.addFoodItem(item);
    }
    makeOrderModel.createOrder(order);
  }

  public void logout()
  {
    catalogue.removeUser(currentUser);
    user.setValue("");
  }

  public User getCurrentUser()
  {
    return currentUser;
  }

  public void showMenu()
  {
    makeOrderModel.showMenu();
  }
}
