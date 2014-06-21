package innerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * Niniejszy program demonstruje spos�b u�ycia klas wewn�trznych.
 * @version 1.10 2004-02-27
 * @author Cay Horstmann
 */
public class InnerClassTest
{
   public static void main(String[] args)
   {
      TalkingClock clock = new TalkingClock(1000, true);
      clock.start();

      // Niech program dzia�a, dop�ki u�ytkownik nie wci�nie przycisku OK.
      JOptionPane.showMessageDialog(null, "Zamkn�� program?");
      System.exit(0);
   }
}

/**
 * Zegar drukuj�cy informacje o czasie w r�wnych odst�pach czasu.
 */
class TalkingClock
{
   private int interval;
   private boolean beep;

   /**
    * Tworzy obiekt TalkingClock.
    * @param interval odst�p czasu pomi�dzy kolejnymi komunikatami (w milisekundach)
    * @param beep warto�� true oznacza, �e d�wi�k ma by� odtwarzany
    */
   public TalkingClock(int interval, boolean beep)
   {
      this.interval = interval;
      this.beep = beep;
   }

   /**
    * W��czanie zegara.
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
         System.out.println("Kiedy us�yszysz d�wi�k, b�dzie godzina " + now);
         if (beep) Toolkit.getDefaultToolkit().beep();
      }
   }
}