package FoodByVIA.Server.Model.ManageOrder;


import FoodByVIA.Shared.Util.PropertyChangeSubject;
import java.time.LocalDate;


public interface ManageOrderServerModel extends PropertyChangeSubject
{
  void search(boolean isActive, LocalDate date);
}
