package FoodByVIA.Client.View.addMenu;

import FoodByVIA.Client.Model.AddMenu.AddMenuModel;
import javafx.beans.property.*;

public class AddMenuViewModel
{
  private AddMenuModel model;
  private StringProperty name;
  private StringProperty description;
  private StringProperty message;
  private  DoubleProperty price;

  public AddMenuViewModel(AddMenuModel model){
    name = new SimpleStringProperty();
    description  = new SimpleStringProperty();
    price = new SimpleDoubleProperty();
    message = new SimpleStringProperty();
    this.model=model;
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
      message.setValue("Item Added");
    }
    else
    {
      message.setValue("Name or Price fields cannot be empty");
    }
    clear();
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
}
