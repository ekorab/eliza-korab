package plaf;

import java.awt.event.*;
import javax.swing.*;

/**
 * Ramka z panelem zawieraj¹cym przyciski zmieniaj¹ce styl.
 */
public class PlafFrame extends JFrame
{
   private JPanel buttonPanel;
   public PlafFrame()
   {
      buttonPanel = new JPanel();
      
      UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
      for (UIManager.LookAndFeelInfo info : infos)
         makeButton(info.getName(), info.getClassName());
      
      add(buttonPanel);
      pack();
   }

   /**
    * Tworzy przycisk zmieniaj¹cy styl.
    * @param name nazwa przycisku
    * @param plafName nazwa klasy stylu
    */
   void makeButton(String name, final String plafName)
   {
      // Dodanie przycisku do panelu

      JButton button = new JButton(name);
      buttonPanel.add(button);

      // Ustawienie akcji przycisku

      button.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               // Akcja przycisku — prze³¹czenie na nowy styl
               try
               {
                  UIManager.setLookAndFeel(plafName);
                  SwingUtilities.updateComponentTreeUI(PlafFrame.this);
                  pack();
               }
               catch (Exception e)
               {
                  e.printStackTrace();
               }
            }
         });
   }  
}
