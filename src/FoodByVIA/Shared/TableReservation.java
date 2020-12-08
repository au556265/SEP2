package FoodByVIA.Shared;

import java.io.Serializable;
import java.time.LocalDate;

public class TableReservation implements Serializable
{
  private String tableID;
  private int numberOfPeople;
  private String zone;
  private String username;
  private LocalDate localDate;
  private boolean isAvailable;
  private int day, month, year;


  public TableReservation(String user, LocalDate localDate, int numberOfPeople, String zone, String tableID){
    this.localDate=localDate;
    this.zone=zone;
    this.numberOfPeople=numberOfPeople;
    username = user;
    this.tableID=tableID;
  }

  public TableReservation()
  {

  }

  public void setTableID(String tableID)
  {
    this.tableID = tableID;
  }

  public void setNumberOfPeople(int numberOfPeople)
  {
    this.numberOfPeople = numberOfPeople;
  }

  public void setZone(String zone)
  {
    this.zone = zone;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public void setLocalDate(LocalDate localDate)
  {
    this.localDate = localDate;
  }



  public LocalDate getLocalDate()
  {
    return localDate;
  }

  public int getNumberOfPeople(){
    return numberOfPeople;
  }

  public String getUsername(){
    return username;
  }

  public String getZone(){
    return zone;
  }

  public String getTableID()
  {
    return tableID;
  }

  @Override public String toString()
  {
    return "tableID: " + tableID + " number of people: " + numberOfPeople +
        " zone: " + zone + " Date: " + localDate;
  }
}
