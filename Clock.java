import java.util.*;
public class Clock extends Observable implements Runnable {
  private Thread thread = new Thread(this);
  private static Clock instance;
  public enum Events {CLOCK_TICKED_EVENT};
  private Clock(){
    thread.start();
  }
  public static Clock instance() {
    if (instance == null) {
      instance = new Clock();
    }
    return instance;
  }
  public void run(){
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ie) {
    }
    try{
      while (true) {
        Thread.sleep(1000);
        setChanged();
        MicrowaveContext.instance().processClockTick();
      }
    } catch (InterruptedException ie) {
    }
  }
}
