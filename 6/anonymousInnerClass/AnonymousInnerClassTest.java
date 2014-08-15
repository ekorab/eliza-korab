package anonymousInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * Niniejszy program demonstruje zastosowanie anonimowych klas wewn�trznych.
 * @version 1.10 2004-02-27
 * @author Cay Horstmann
 */
public class AnonymousInnerClassTest
{
   public static void main(String[] args)
   {
      TalkingClock clock = new TalkingClock();
      clock.start(1000, true);

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
   /**
    * Tworzy obiekt TalkingClock.
    * @param interval odst�p czasu pomi�dzy kolejnymi komunikatami (w milisekundach)
    * @param beep warto�� true oznacza, �e d�wi�k ma by� odtwarzany
    */
   public void start(int interval, final boolean beep)
   {
      ActionListener listener = new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               Date now = new Date();
               System.out.println("Kiedy us�yszysz d�wi�k, b�dzie godzina " + now);
               if (beep) Toolkit.getDefaultToolkit().beep();
            }
         };
      Timer t = new Timer(interval, listener);
      t.start();
   }
}