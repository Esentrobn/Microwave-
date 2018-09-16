import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class GUIDisplay extends MicrowaveDisplay implements ActionListener {
  private static SimpleDisplay frame;
  private GUIDisplay() {
    frame = new SimpleDisplay();
    initialize();
  }
  private class SimpleDisplay extends JFrame {
    private JButton doorCloser = new JButton("close door");
    private JButton doorOpener = new JButton("open door");
    private JButton cookButton = new JButton("cook");
    private JLabel doorStatus = new JLabel("Door Closed");
    private JLabel timerValue = new JLabel("            ");
    private JLabel lightStatus = new JLabel("Light Off");
    private JLabel cookingStatus = new JLabel("Not cooking");
    private SimpleDisplay() {
      super("Microwave");
      getContentPane().setLayout(new FlowLayout());
      getContentPane().add(doorStatus);
      getContentPane().add(lightStatus);
      getContentPane().add(timerValue);
      getContentPane().add(cookingStatus);
      getContentPane().add(doorCloser);
      getContentPane().add(doorOpener);
      getContentPane().add(cookButton);
      doorCloser.addActionListener(GUIDisplay.this);
      doorOpener.addActionListener(GUIDisplay.this);
      cookButton.addActionListener(GUIDisplay.this);
      pack();
      setVisible(true);
    }
  }
  public void actionPerformed(ActionEvent event) {
    if (event.getSource().equals(frame.doorCloser)) {
      MicrowaveContext.instance().processDoorClose();
    } else if (event.getSource().equals(frame.doorOpener)) {
      MicrowaveContext.instance().processDoorOpen();
    } else if (event.getSource().equals(frame.cookButton)) {
      MicrowaveContext.instance().processCookRequest();
    }
  }
  public void turnLightOn() {
    frame.lightStatus.setText("Light On");
  }
  public void turnLightOff() {
    frame.lightStatus.setText("Light Off");
  }
  public void doorClosed() {
    frame.doorStatus.setText("Door Closed");
  }
  public void doorOpened() {
    frame.doorStatus.setText("Door Opened");
  }
  public void displayTimeRemaining(int value) {
    frame.timerValue.setText(" " + value);
  }
  public void startCooking() {
    frame.cookingStatus.setText("Cooking");
  }
  public void notCooking() {
    frame.cookingStatus.setText("Not cooking");
  }
  public static void main(String[] s) {
    Clock.instance();
    MicrowaveDisplay display = new GUIDisplay();
  }
}