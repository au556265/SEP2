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


  /*
  public Order(User customer, double totalPrice, boolean active, MyDate orderDate){
    this.customer=customer;
    this.totalPrice=totalPrice;
    this.orderDate = orderDate;
    this.active=active;
  }
   */

  public Order(User customer, double totalPrice, MyDate orderDate){
    this.customer=customer;
    this.totalPrice=totalPrice;
    this.orderDate = orderDate;
  }


  public MyDate getDate(){
    return orderDate;
  }

  public void addFoodItem(FoodItem foodItem){
    foodItems.add(foodItem);
  }

  public User getCustomerInformation(){
    return customer;
  }

  public String getCustomer(){
    return customer.getUsername();
  }

  public ArrayList<FoodItem> getSelectedFoodItems(){
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
