package FoodByVIA.Server.Core;

import FoodByVIA.Client.Network.AddMenu.AddMenuClientImpl;
import FoodByVIA.Shared.Network.CallBack.MessageCallBack;

public class ClientCallBackFactory
{
  private MessageCallBack messageCallBack;

  public MessageCallBack getMessageCallBack()
  {
    if(messageCallBack == null)
    {
      messageCallBack = new AddMenuClientImpl();
    }
    return messageCallBack;
  }
}
