import java.util.*;
public abstract class MicrowaveDisplay extends Observable {
  protected static MicrowaveContext context;
  protected static MicrowaveDisplay instance;
  protected MicrowaveDisplay() {
    instance = this;
    context = MicrowaveContext.instance();
  }
  public static MicrowaveDisplay instance() {
    return instance;
  }
  public void initialize() {
    context.initialize();
  }
  public abstract void displayTimeRemaining(int time);
  public abstract void turnLightOn();
  public abstract void turnLightOff();
  public abstract void doorClosed();
  public abstract void doorOpened();
  public abstract void startCooking();
  public abstract void notCooking();
}