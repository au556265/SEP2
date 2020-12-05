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

  public TableReservation(int numberOfPeople, String zone, MyDate tableDate, User user, String tableID){
    this.tableDate=tableDate;
    this.zone=zone;
    this.user = user;
    this.tableID=tableID;

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
