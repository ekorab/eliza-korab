package dialog;

import java.awt.event.*;
import javax.swing.*;

/**
 * Ramka z menu, którego akcja Plik->O programie wyœwietla okno dialogowe
 */
public class DialogFrame extends JFrame
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;
   private AboutDialog dialog;

   public DialogFrame()
   {      
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // Tworzenie menu Plik

      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);
      JMenu fileMenu = new JMenu("Plik");
      menuBar.add(fileMenu);

      // Tworzenie elementów O programie i Zamknij

      // Element O programie wyœwietla okno dialogowe O programie

      JMenuItem aboutItem = new JMenuItem("O programie");
      aboutItem.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               if (dialog == null) // pierwszy raz
               dialog = new AboutDialog(DialogFrame.this);
               dialog.setVisible(true); // wyskakuj¹ce okno dialogowe
            }
         });
      fileMenu.add(aboutItem);

      // Element Zamknij powoduje zamkniêcie programu

      JMenuItem exitItem = new JMenuItem("Zamknij");
      exitItem.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });
      fileMenu.add(exitItem);
   }
}
