package FoodByVIA.Client.Network.ManageOrder;

import FoodByVIA.Shared.Util.PropertyChangeSubject;

import java.time.LocalDate;

public interface ManageOrderClient extends PropertyChangeSubject
{
  void startClient();
  void search(boolean isActive, LocalDate date);
}
