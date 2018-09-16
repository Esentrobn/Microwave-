import java.util.*;
public class DoorClosedState extends MicrowaveState {
  private static DoorClosedState instance;
  static {
    instance = new DoorClosedState();
  }
  public static DoorClosedState instance() {
    return instance;
  }
  public void processDoorOpen() {
    display.doorOpened();
    display.turnLightOn();
    context.changeCurrentState(DoorOpenedState.instance());
  }
  public void processCookRequest() {
    display.displayTimeRemaining(10);
    context.setTimeRemaining(10);
    context.changeCurrentState(CookingState.instance());
  }
  public void run() {
    display.doorClosed();
    display.turnLightOff();
    display.notCooking();
    display.displayTimeRemaining(0);
    context.setTimeRemaining(0);
  }
}