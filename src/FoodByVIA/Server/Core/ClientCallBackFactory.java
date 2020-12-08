package FoodByVIA.Server.Core;

import FoodByVIA.Client.Network.AddMenu.AddMenuClientImpl;
import FoodByVIA.Client.Network.MakeOrder.MakeOrderClientImpl;
import FoodByVIA.Client.Network.TableReservation.TableReservationClientImpl;
import FoodByVIA.Shared.Network.CallBack.MakeOrderCallBack;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;
import FoodByVIA.Shared.Network.CallBack.ReserveTableCallBack;

public class ClientCallBackFactory
{
  private MessageCallBack messageCallBack;
  private MakeOrderCallBack makeOrderCallBack;
  private ReserveTableCallBack reserveTableCallBack;

  public MessageCallBack getMessageCallBack()
  {
    if(messageCallBack == null)
    {
      messageCallBack = new AddMenuClientImpl();
    }
    return messageCallBack;
  }

  public MakeOrderCallBack getMakeOrderCallBack()
  {
    if(makeOrderCallBack == null)
    {
      makeOrderCallBack = new MakeOrderClientImpl();
    }
    return makeOrderCallBack;
  }

  public ReserveTableCallBack getReserveTableCallBack()
  {
    if(reserveTableCallBack == null)
    {
      reserveTableCallBack = new TableReservationClientImpl();
    }
    return reserveTableCallBack;
  }
}
