package innerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * Niniejszy program demonstruje sposób u¿ycia klas wewnêtrznych.
 * @version 1.10 2004-02-27
 * @author Cay Horstmann
 */
public class InnerClassTest
{
   public static void main(String[] args)
   {
      TalkingClock clock = new TalkingClock(1000, true);
      clock.start();

      // Niech program dzia³a, dopóki u¿ytkownik nie wciœnie przycisku OK.
      JOptionPane.showMessageDialog(null, "Zamkn¹æ program?");
      System.exit(0);
   }
}

/**
 * Zegar drukuj¹cy informacje o czasie w równych odstêpach czasu.
 */
class TalkingClock
{
   private int interval;
   private boolean beep;

   /**
    * Tworzy obiekt TalkingClock.
    * @param interval odstêp czasu pomiêdzy kolejnymi komunikatami (w milisekundach)
    * @param beep wartoœæ true oznacza, ¿e dŸwiêk ma byæ odtwarzany
    */
   public TalkingClock(int interval, boolean beep)
   {
      this.interval = interval;
      this.beep = beep;
   }

   /**
    * W³¹czanie zegara.
    */
   public void start()
   {
      ActionListener listener = new TimePrinter();
      Timer t = new Timer(interval, listener);
      t.start();
   }

   public class TimePrinter implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         Date now = new Date();
         System.out.println("Kiedy us³yszysz dŸwiêk, bêdzie godzina " + now);
         if (beep) Toolkit.getDefaultToolkit().beep();
      }
   }
}