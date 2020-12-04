package FoodByVIA.Shared;

public class MyDate
{
  private int day;
  private int month;
  private int year;

  public MyDate(int year, int month, int day){
    this.day=day;
    this.month=month;
    this.year=year;
  }

  @SuppressWarnings("WeakerAccess") public void set(int year, int month, int day){
    this.day=day;
    this.month=month;
    this.year=year;
  }

  public int getDay()
  {
    return day;
  }

  public int getYear()
  {
    return year;
  }

  public int getMonth()
  {
    return month;
  }

  public String toString(){
    String s;
    s= year +"-" +  month + "-" +day;
    return s;
  }
}
