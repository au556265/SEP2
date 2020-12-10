package FoodByVIA.Client.Model.ManageOrder;

import FoodByVIA.Shared.Order;
import FoodByVIA.Shared.Util.PropertyChangeSubject;

import java.beans.PropertyChangeSupport;
import java.time.LocalDate;

public interface ManageOrderModel extends PropertyChangeSubject
{
  void search(boolean isActive, LocalDate date);

  void completeOrder(Order order);
}
