package fileChooser;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

/**
 * Widok plików wyœwietlaj¹cy ikonê obok wszystkich plików zaakceptowanych przez filtr
 */
public class FileIconView extends FileView
{
   private FileFilter filter;
   private Icon icon;

   /**
    * Tworzy obiekt FileIconView
    * @param aFilter filtr plików — wszystkie pliki zaakceptowane przez ten filtr bêd¹ mia³y ikonê.
    * @param anIcon — ikona wyœwietlana obok wszystkich zaakceptowanych plików
    */
   public FileIconView(FileFilter aFilter, Icon anIcon)
   {
      filter = aFilter;
      icon = anIcon;
   }

   public Icon getIcon(File f)
   {
      if (!f.isDirectory() && filter.accept(f)) return icon;
      else return null;
   }
}
