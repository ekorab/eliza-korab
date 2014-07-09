package gridbag;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

/**
 * Ramka zawieraj¹ca komponenty ustawiaj¹ce w³asnoœci czcionki w rozk³adzie GridBagLayout
 */
public class FontFrame extends JFrame
{
   public static final int TEXT_ROWS = 10;
   public static final int TEXT_COLUMNS = 20;

   private JComboBox<String> face;
   private JComboBox<Integer> size;
   private JCheckBox bold;
   private JCheckBox italic;
   private JTextArea sample;

   public FontFrame()
   {
      GridBagLayout layout = new GridBagLayout();
      setLayout(layout);

      ActionListener listener = EventHandler.create(ActionListener.class, this, "updateSample"); 

      // Tworzenie komponentów

      JLabel faceLabel = new JLabel("Face: ");

      face = new JComboBox<String>(new String[] { "Serif", "SansSerif", "Monospaced", "Dialog",
            "DialogInput" });

      face.addActionListener(listener);

      JLabel sizeLabel = new JLabel("Size: ");

      size = new JComboBox<Integer>(new Integer[] { 8, 10, 12, 15, 18, 24, 36, 48 });

      size.addActionListener(listener);

      bold = new JCheckBox("Bold");
      bold.addActionListener(listener);

      italic = new JCheckBox("Italic");
      italic.addActionListener(listener);

      sample = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
      sample.setText("Koñ i ¿ó³w grali w koœci z piêkn¹ æm¹ u Ÿród³a");
      sample.setEditable(false);
      sample.setLineWrap(true);
      sample.setBorder(BorderFactory.createEtchedBorder());

      // Dodawanie komponentów do siatki przy u¿yciu klasy pomocniczej GBC

      add(faceLabel, new GBC(0, 0).setAnchor(GBC.EAST));
      add(face, new GBC(1, 0).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
      add(sizeLabel, new GBC(0, 1).setAnchor(GBC.EAST));
      add(size, new GBC(1, 1).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
      add(bold, new GBC(0, 2, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));
      add(italic, new GBC(0, 3, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));
      add(sample, new GBC(2, 0, 1, 4).setFill(GBC.BOTH).setWeight(100, 100));
      pack();
      updateSample();
   }
   
   public void updateSample()
   {
      String fontFace = (String) face.getSelectedItem();
      int fontStyle = (bold.isSelected() ? Font.BOLD : 0)
            + (italic.isSelected() ? Font.ITALIC : 0);
      int fontSize = size.getItemAt(size.getSelectedIndex());
      Font font = new Font(fontFace, fontStyle, fontSize);
      sample.setFont(font);
      sample.repaint();      
   }
}