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


  public Order(String  customer, double totalPrice, LocalDate orderDate)
  {
    this.customer = customer;
    this.totalPrice = totalPrice;
    this.orderDate = orderDate;
    foodItems = new ArrayList<>();
  }

  public Order()
  {
    foodItems = new ArrayList<>();
  }

  public double getTotalPrice()
  {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice)
  {
    this.totalPrice = totalPrice;
  }

  public void setActive(boolean active)
  {
    this.active = active;
  }

  public void setCustomer(String customer)
  {
    this.customer = customer;
  }

  public void setFoodItems(List<FoodItem> foodItems)
  {
    this.foodItems = foodItems;
  }

  public void setOrderDate(LocalDate orderDate)
  {
    this.orderDate = orderDate;
  }

  public LocalDate getDate(){
    return orderDate;
  }

  public void addFoodItem(FoodItem foodItem){
    foodItems.add(foodItem);
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

  public void setOrderNumber(int ordernumber)
  {
    this.orderNumber = ordernumber;
  }
}
