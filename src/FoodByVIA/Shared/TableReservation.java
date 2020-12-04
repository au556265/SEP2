package FoodByVIA.Shared;

public class TableReservation
{
  private String tableID;
  private int numberOfPeople;
  private String zone;



  public TableReservation(int numberOfPeople, String zone, String tableID){
    this.numberOfPeople=numberOfPeople;
    this.zone=zone;
    this.tableID=tableID;
  }
  public void setNumberOfPeople(int numberOfPeople){
    this.numberOfPeople=numberOfPeople;
  }

  public int getNumberOfPeople(){
    return numberOfPeople;
  }

  public void setZone(String zone){
    this.zone=zone;
  }

  public String setZone(){
    return zone;
  }

  public void setTableID( String tableID){

    this.tableID=tableID;
  }

  public String getTableID()
  {

    return tableID;
  }


}
