package FoodByVIA.Shared;

public class DineIn extends Order
{
  private String tableID;
  public DineIn(User customer, double totalPrice, boolean active)
  {
    super(customer, totalPrice, active);
  }

  public void setTableID(String tableID){
    this.tableID=tableID;
  }

  public String getTableID()
  {
    return tableID;
  }

  public String toString(){
    return super.toString() + " " + tableID;
  }
}
