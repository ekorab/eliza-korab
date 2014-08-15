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
// Powy�szy import ma na celu zapobiec konfliktowi z klas� java.util.Timer.

public class TimerTest
{ 
   public static void main(String[] args)
   { 
      ActionListener listener = new TimePrinter();

      // Konstrukcja zegara wywo�uj�cego obiekt nas�uchuj�cy
      // co dziesi�� sekund.
      Timer t = new Timer(10000, listener);
      t.start();

      JOptionPane.showMessageDialog(null, "Zamkn�� program?");
      System.exit(0);
   }
}

class TimePrinter implements ActionListener
{ 
   public void actionPerformed(ActionEvent event)
   { 
      Date now = new Date();
      System.out.println("Kiedy us�yszysz d�wi�k, b�dzie godzina " + now);
      Toolkit.getDefaultToolkit().beep();
   }
}