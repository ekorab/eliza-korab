package colorChooser;

import javax.swing.*;

/**
 * Ramka z panelem wyboru koloru
 */
public class ColorChooserFrame extends JFrame
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;

   public ColorChooserFrame()
   {      
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // Dodanie panelu wyboru koloru do ramki

      ColorChooserPanel panel = new ColorChooserPanel();
      add(panel);
   }
}