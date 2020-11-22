package FoodByVIA.Shared;

import java.io.Serializable;

public class FoodItem implements Serializable
{
  private String name;
  private double price;
  private String description;

  public FoodItem(String name, double price, String description)
  {
    this.name = name;
    this.price = price;
    this.description = description;
  }

  public void setPrice(double price)
  {
    this.price= price;
  }

  public String getName()
  {
    return name;
  }

  public double getPrice()
  {
    return price;
  }

  public String getDescription()
  {
    return description;
  }

  public String toString()
  {
    return name + " " + price + " " + description;
  }
}
