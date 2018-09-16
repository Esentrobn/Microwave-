public abstract class MicrowaveState {
  protected static MicrowaveContext context;
  protected static MicrowaveDisplay display;
  protected MicrowaveState() {
    context = MicrowaveContext.instance();
    display = context.getDisplay();
  }
  public abstract void run();
  public  void processDoorClose() {
  }
  public  void processDoorOpen() {
  }
  public  void processCookRequest() {
  }
  public  void processClockTick() {
  }
}
