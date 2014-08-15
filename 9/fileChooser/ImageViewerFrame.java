package fileChooser;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
 * Ramka z menu zawieraj¹cym opcjê Otwórz i obszarem do prezentacji otwartych obrazów
 */
public class ImageViewerFrame extends JFrame
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 400;
   private JLabel label;
   private JFileChooser chooser;

   public ImageViewerFrame()
   {      
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // pasek menu
      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);

      JMenu menu = new JMenu("Plik");
      menuBar.add(menu);

      JMenuItem openItem = new JMenuItem("Otwórz");
      menu.add(openItem);
      openItem.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               chooser.setCurrentDirectory(new File("."));
   
               // okno wyboru plików
               int result = chooser.showOpenDialog(ImageViewerFrame.this);
   
               // Jeœli plik obrazu zostanie zaakceptowany, ustaw go jako ikonê etykiety
               if (result == JFileChooser.APPROVE_OPTION)
               {
                  String name = chooser.getSelectedFile().getPath();
                  label.setIcon(new ImageIcon(name));
                  pack();
               }
            }
         });

      JMenuItem exitItem = new JMenuItem("Zamknij");
      menu.add(exitItem);
      exitItem.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });

      // Etykieta do wyœwietlania obrazów
      label = new JLabel();
      add(label);

      // set up file chooser
      chooser = new JFileChooser();

      // Akceptuje wszystkie pliki obrazów z rozszerzeniem .jpg, .jpeg, .gif
      /*
      final ExtensionFileFilter filter = new ExtensionFileFilter();
      filter.addExtension("jpg");
      filter.addExtension("jpeg");
      filter.addExtension("gif");
      filter.setDescription("Pliki obrazów");
      */
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki obrazów", "jpg", "jpeg", "gif");
      chooser.setFileFilter(filter);

      chooser.setAccessory(new ImagePreviewer(chooser));

      chooser.setFileView(new FileIconView(filter, new ImageIcon("palette.gif")));
   }
}