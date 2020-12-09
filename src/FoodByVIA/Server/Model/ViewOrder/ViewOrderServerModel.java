package FoodByVIA.Server.Model.ViewOrder;


import FoodByVIA.Shared.Util.PropertyChangeSubject;
import java.time.LocalDate;


public interface ViewOrderServerModel extends PropertyChangeSubject
{
  void getAllOrders(Boolean isActive, LocalDate localDate);
}
