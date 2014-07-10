package anonymousInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * Niniejszy program demonstruje zastosowanie anonimowych klas wewnêtrznych.
 * @version 1.10 2004-02-27
 * @author Cay Horstmann
 */
public class AnonymousInnerClassTest
{
   public static void main(String[] args)
   {
      TalkingClock clock = new TalkingClock();
      clock.start(1000, true);

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
   /**
    * Tworzy obiekt TalkingClock.
    * @param interval odstêp czasu pomiêdzy kolejnymi komunikatami (w milisekundach)
    * @param beep wartoœæ true oznacza, ¿e dŸwiêk ma byæ odtwarzany
    */
   public void start(int interval, final boolean beep)
   {
      ActionListener listener = new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               Date now = new Date();
               System.out.println("Kiedy us³yszysz dŸwiêk, bêdzie godzina " + now);
               if (beep) Toolkit.getDefaultToolkit().beep();
            }
         };
      Timer t = new Timer(interval, listener);
      t.start();
   }
}