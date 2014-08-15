package sizedFrame;

import java.awt.*;
import javax.swing.*;

/**
 * @version 1.32 2007-04-14
 * @author Cay Horstmann
 */
public class SizedFrameTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new SizedFrame();
               frame.setTitle("SizedFrame");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

class SizedFrame extends JFrame
{
   public SizedFrame()
   {
      // Sprawdzenie wymiar�w ekranu

      Toolkit kit = Toolkit.getDefaultToolkit();
      Dimension screenSize = kit.getScreenSize();
      int screenHeight = screenSize.height;
      int screenWidth = screenSize.width;

      // Ustawienie szeroko�ci i wysoko�ci ramki oraz polecenie systemowi, aby ustali� jej po�o�enie

      setSize(screenWidth / 2, screenHeight / 2);
      setLocationByPlatform(true);

      // Ustawienie ikony i tytu�u

      Image img = new ImageIcon("icon.gif").getImage();
      setIconImage(img);      
   }
}
