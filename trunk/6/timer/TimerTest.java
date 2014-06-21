package timer;

/**
/**
   @version 1.00 2000-04-13
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
// Powy¿szy import ma na celu zapobiec konfliktowi z klas¹ java.util.Timer.

public class TimerTest
{ 
   public static void main(String[] args)
   { 
      ActionListener listener = new TimePrinter();

      // Konstrukcja zegara wywo³uj¹cego obiekt nas³uchuj¹cy
      // co dziesiêæ sekund.
      Timer t = new Timer(10000, listener);
      t.start();

      JOptionPane.showMessageDialog(null, "Zamkn¹æ program?");
      System.exit(0);
   }
}

class TimePrinter implements ActionListener
{ 
   public void actionPerformed(ActionEvent event)
   { 
      Date now = new Date();
      System.out.println("Kiedy us³yszysz dŸwiêk, bêdzie godzina " + now);
      Toolkit.getDefaultToolkit().beep();
   }
}