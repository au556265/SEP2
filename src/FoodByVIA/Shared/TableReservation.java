package FoodByVIA.Shared;

import java.io.Serializable;

public class TableReservation implements Serializable
{
  private String tableID;
  private int numberOfPeople;
  private String zone;
  private boolean tableReserved;
  private User user;
  private MyDate tableDate;

  //where capazity and zone
  public TableReservation( User user, MyDate tableDate, int numberOfPeople, String zone){
    this.tableDate=tableDate;
    this.zone=zone;
    this.numberOfPeople=numberOfPeople;
    this.user = user;

  }

  public boolean isTableReserved()
  {
    return tableReserved;
  }

  public MyDate getDate(){
    return tableDate;
  }
  public int getNumberOfPeople(){
    return numberOfPeople;
  }

  public String getUsername(){
    return user.getUsername();
  }

  public String getZone(){
    return zone;
  }

  public String getTableID()
  {
    return tableID;
  }
}
