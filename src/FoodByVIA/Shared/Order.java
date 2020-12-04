package FoodByVIA.Shared;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Order implements Serializable
{
  private double totalPrice;
  private int orderNumber;
  private boolean active;
  private User customer;
  private ArrayList<FoodItem> foodItems = new ArrayList<>();
  private MyDate orderDate;


  // add date
  public Order(User customer, double totalPrice, boolean active, MyDate orderDate){
    this.customer=customer;
    this.totalPrice=totalPrice;
    this.active=active;
    this.orderDate = orderDate;
  }


  public MyDate getDate(){
    return orderDate;
  }




  public void addFoodItem(FoodItem foodItem){
    foodItems.add(foodItem);
  }


  public void setDate( int year, int month, int day){
     orderDate.set(year,month,day);
  }

  public User getCustomerInformation(){
    return customer;
  }

  public String getCustomer(){
    return customer.getUsername();
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

  public int getOrdernumber()
  {
    return orderNumber;
  }
}
