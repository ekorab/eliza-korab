package fileChooser;

import java.awt.*;
import java.beans.*;
import java.io.*;
import javax.swing.*;

/**
 * Akcesorium wyœwietlaj¹ce podgl¹d obrazów
 */
public class ImagePreviewer extends JLabel
{
   /**
    * Tworzy obiekt ImagePreviewer
    * @param chooser okno wyboru plików, którego w³asnoœæ zmienia siê, powoduje zmianê obrazu 
    * w tym podgl¹dzie

    */
   public ImagePreviewer(JFileChooser chooser)
   {
      setPreferredSize(new Dimension(100, 100));
      setBorder(BorderFactory.createEtchedBorder());

      chooser.addPropertyChangeListener(new PropertyChangeListener()
         {
            public void propertyChange(PropertyChangeEvent event)
            {
               if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
               {
                  // U¿ytkownik wybra³ inny plik
                  File f = (File) event.getNewValue();
                  if (f == null)
                  {
                     setIcon(null);
                     return;
                  }

                  // Wczytanie obrazu jako ikony
                  ImageIcon icon = new ImageIcon(f.getPath());

                  // Skalowanie obrazu, jeœli jest zbyt du¿y na ikonê
                  if (icon.getIconWidth() > getWidth()) icon = new ImageIcon(icon.getImage()
                        .getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));

                  setIcon(icon);
               }
            }
         });
   }
}
