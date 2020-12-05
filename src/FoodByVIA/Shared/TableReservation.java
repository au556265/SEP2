package FoodByVIA.Shared;

import java.io.Serializable;

public class TableReservation implements Serializable
{
  private String tableID;
  private int numberOfPeople;
  private String zone;

  public TableReservation(int numberOfPeople, String zone){
    this.numberOfPeople=numberOfPeople;
    this.zone=zone;
  }

  public int getNumberOfPeople(){
    return numberOfPeople;
  }

  public String getZone(){
    return zone;
  }

  public String getTableID()
  {
    return tableID;
  }
}
