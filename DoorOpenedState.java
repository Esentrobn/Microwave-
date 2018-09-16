import java.util.*;
public class DoorOpenedState extends MicrowaveState {
  private static DoorOpenedState instance;
  static {
    instance = new DoorOpenedState();
  }
  public static DoorOpenedState instance() {
    return instance;
  }
  public void processDoorClose() {
    display.turnLightOff();
    display.doorClosed();
    context.changeCurrentState(DoorClosedState.instance());
  }
  public void run() {
    display.turnLightOn();
    display.notCooking();
    display.doorOpened();
    display.displayTimeRemaining(0);
  }
}