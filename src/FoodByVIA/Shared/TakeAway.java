package FoodByVIA.Shared;

public class TakeAway extends Order
{
  public TakeAway(User customer, double totalPrice, boolean active)
  {
    super(customer, totalPrice, active);
  }

  @Override public String toString()
  {
    return super.toString();
  }
}
