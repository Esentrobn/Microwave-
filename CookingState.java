import java.util.*;
public class CookingState extends MicrowaveState {
  private static CookingState instance;
  static {
    instance = new CookingState();
  }
  public static CookingState instance() {
    return instance;
  }
  public void processCookRequest() {
    context.setTimeRemaining(context.getTimeRemaining() + 10);
    display.displayTimeRemaining(context.getTimeRemaining());
  }
  public void processDoorOpen() {
    display.doorOpened();
    context.changeCurrentState(DoorOpenedState.instance());
  }
  public void processClockTick() {
    context.setTimeRemaining(context.getTimeRemaining() - 1);
    display.displayTimeRemaining(context.getTimeRemaining());
    if (context.getTimeRemaining() == 0) {
      context.changeCurrentState(DoorClosedState.instance());
    }
  }
  public void run() {
    display.turnLightOn();
    context.setTimeRemaining(10);
    display.startCooking();
    display.displayTimeRemaining(context.getTimeRemaining());
  }
}