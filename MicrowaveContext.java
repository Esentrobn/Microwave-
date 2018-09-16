import java.awt.event.*;
import java.util.*;
public class MicrowaveContext {
  private static MicrowaveDisplay microwaveDisplay;
  private int timeRemaining;
  private MicrowaveState currentState;
  private static MicrowaveContext instance;
  static {
    instance = new MicrowaveContext();
    microwaveDisplay = MicrowaveDisplay.instance();
  }
  private MicrowaveContext() {
  }
  public static MicrowaveContext instance() {
    if (instance == null) {
      instance = new MicrowaveContext();
    }
    return instance;
  }
  public void initialize() {
    instance.changeCurrentState(DoorClosedState.instance());
  }
  public void processClockTick() {
    currentState.processClockTick();
  }
  public void processDoorClose() {
    currentState.processDoorClose();
  }
  public void processDoorOpen() {
    currentState.processDoorOpen();
  }
  public void processCookRequest() {
    currentState.processCookRequest();
  }
  public void changeCurrentState(MicrowaveState nextState) {
    currentState = nextState;
    nextState.run();
  }
  public MicrowaveDisplay getDisplay() {
    return microwaveDisplay;
  }
  public int getTimeRemaining() {
    return timeRemaining;
  }
  public void setTimeRemaining(int timeRemaining) {
    this.timeRemaining = timeRemaining;
  }
}