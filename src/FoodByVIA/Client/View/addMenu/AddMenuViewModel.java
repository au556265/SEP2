package FoodByVIA.Client.View.addMenu;

import FoodByVIA.Client.Model.AddMenu.AddMenuModel;
import FoodByVIA.Shared.Catalogue;
import FoodByVIA.Shared.User;
import javafx.application.Platform;
import javafx.beans.property.*;

import java.beans.PropertyChangeEvent;

public class AddMenuViewModel
{
  private AddMenuModel model;
  private StringProperty name;
  private StringProperty description;
  private StringProperty message;
  private  DoubleProperty price;
  private StringProperty username;

  private Catalogue catalogue;
  private User user;

  public AddMenuViewModel(AddMenuModel model){
    name = new SimpleStringProperty();
    description  = new SimpleStringProperty();
    price = new SimpleDoubleProperty();
    message = new SimpleStringProperty();
    username = new SimpleStringProperty();
    this.model=model;
    model.addPropertyChangeListener("AddMenuMessage", this::throwMessage);

    catalogue = Catalogue.getInstance();
    user = catalogue.getCurrentUser();
    username.setValue(user.getUsername());
  }

  private void throwMessage(PropertyChangeEvent evt)
  {
    String messageFromServer = (String) evt.getNewValue();
    Platform.runLater(() -> message.setValue(messageFromServer));
  }

  public StringProperty getName()
  {
    return name;
  }
  public StringProperty getDescription()
  {
    return description;
  }
  public DoubleProperty getPrice(){return price;}


  public void addMenu()
  {
    String inputName = name.get();
    String inputDescription = description.get();
    double inputPrice = price.get();

    if ((inputName != null && !"".equals(inputName)) && inputPrice != 0)
    {
      model.addFoodItem(inputName, inputPrice, inputDescription);
    }
    else
    {
      message.setValue("Name or Price fields cannot be empty");
    }
  }

  public void clear(){

    name.set("");
    description.set("");
    price.set(0);
  }

  public StringProperty getMessage()
  {
    return message;
  }

  public StringProperty getUsername()
  {
    return username;
  }

  public void logOut()
  {
    catalogue.removeUser(user);
    username.setValue("");
  }
}
