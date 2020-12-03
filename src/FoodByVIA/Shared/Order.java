package FoodByVIA.Shared;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Order implements Serializable
{
  private double totalPrice;
  private int orderNumber;
  private boolean active;
  private User customer;
  private ArrayList<FoodItem> foodItems = new ArrayList<>();
  private GregorianCalendar currentDate = new GregorianCalendar();

  // add date
  public Order(User customer, double totalPrice, boolean active){
    this.customer=customer;
    this.totalPrice=totalPrice;
    this.active=active;
  }

  /*
  public String getDate(){
    return " " + currentDate.get(GregorianCalendar.DATE) + " " + (currentDate.get(GregorianCalendar.MONTH)+1) +  " "+ currentDate.get(GregorianCalendar.YEAR);
  }
   */

  public void addFoodItem(FoodItem foodItem){
    foodItems.add(foodItem);
  }



  public User getCustomerInformation(){
    return customer;
  }

  public ArrayList<FoodItem> getFoodItems(){
    return foodItems;
  }

  public boolean isActive()
  {
    return active;
  }


  @Override public String toString()
  {
    return customer.getName() + " " + orderNumber + " " + foodItems + " " + totalPrice  + " " + active;
    // add is active and date
  }
}
