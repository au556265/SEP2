package FoodByVIA.Shared;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Order implements Serializable
{
  private double totalPrice;
  private int orderNumber;
  private boolean active;
  private String  customer;
  private List<FoodItem> foodItems;
  private LocalDate orderDate;


  /*
  public Order(User customer, double totalPrice, boolean active, MyDate orderDate){
    this.customer=customer;
    this.totalPrice=totalPrice;
    this.orderDate = orderDate;
    this.active=active;
  }
   */

  public Order(String  customer, double totalPrice, LocalDate orderDate, List<FoodItem> items){
    this.customer=customer;
    this.totalPrice=totalPrice;
    this.orderDate = orderDate;
    foodItems = items;
  }


  public LocalDate getDate(){
    return orderDate;
  }

  public void addFoodItem(FoodItem foodItem){
    foodItems.add(foodItem);
  }

  public String  getCustomerInformation(){
    return customer;
  }

  public String getCustomer(){
    return customer;
  }

  public List<FoodItem> getSelectedFoodItems(){
    return foodItems;
  }

  public boolean isActive()
  {
    return active;
  }



  @Override public String toString()
  {
    return customer + " " + orderNumber + " " + foodItems + " " + totalPrice  + " " + active;
    // add is active and date
  }

  public int getOrdernumber()
  {
    return orderNumber;
  }
}
