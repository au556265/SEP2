package FoodByVIA.Shared;

public class TestForCatalouge
{
  public static void main(String[] args)
  {
    Catalogue catalogue = Catalogue.getInstance();
    System.out.println(catalogue.getCurrentUser());
  }
}
