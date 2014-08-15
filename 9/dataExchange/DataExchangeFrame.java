package dataExchange;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Ramka z menu, którego akcja Plik->Po³¹cz wyœwietla okno dialogowe z polem has³a
 */
public class DataExchangeFrame extends JFrame
{
   public static final int TEXT_ROWS = 20;
   public static final int TEXT_COLUMNS = 40;
   private PasswordChooser dialog = null;
   private JTextArea textArea;

   public DataExchangeFrame()
   {
      // Tworzenie menu Plik

      JMenuBar mbar = new JMenuBar();
      setJMenuBar(mbar);
      JMenu fileMenu = new JMenu("Plik");
      mbar.add(fileMenu);

      // Tworzenie elementów menu Po³¹cz i Zamknij

      JMenuItem connectItem = new JMenuItem("Po³¹cz");
      connectItem.addActionListener(new ConnectAction());
      fileMenu.add(connectItem);

      // Opcja Zamknij zamyka program

      JMenuItem exitItem = new JMenuItem("Zamknij");
      exitItem.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });
      fileMenu.add(exitItem);

      textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
      add(new JScrollPane(textArea), BorderLayout.CENTER);
      pack();
   }

   /**
    * Akcja Connect wyœwietla okno dialogowe z polem has³a
    */

   private class ConnectAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         // Jeœli jest to pierwszy raz, tworzy okno dialogowe

         if (dialog == null) dialog = new PasswordChooser();

         // Ustawianie wartoœci domyœlnych
         dialog.setUser(new User("yourname", null));

         // Wyœwietlenie okna dialogowego
         if (dialog.showDialog(DataExchangeFrame.this, "Connect"))
         {
            // Pobranie danych u¿ytkownika w przypadku zatwierdzenia
            User u = dialog.getUser();
            textArea.append("nazwa u¿ytkownika = " + u.getName() + ", has³o = "
                  + (new String(u.getPassword())) + "\n");
         }
      }
   }
}