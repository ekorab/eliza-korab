package radioButton;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Ramka z przyk³adow¹ etykiet¹ tekstow¹ i prze³¹cznikami s³u¿¹cymi do wyboru rozmiaru czcionki
 */
public class RadioButtonFrame extends JFrame
{
   private JPanel buttonPanel;
   private ButtonGroup group;
   private JLabel label;
   private static final int DEFAULT_SIZE = 36;

   public RadioButtonFrame()
   {      
      // Dodanie przyk³adowej etykiety tekstowej

      label = new JLabel("Koñ i ¿ó³w grali w koœci z piêkn¹ æm¹ u Ÿród³a.");
      label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
      add(label, BorderLayout.CENTER);

      // Dodanie prze³¹czników

      buttonPanel = new JPanel();
      group = new ButtonGroup();

      addRadioButton("Ma³a", 8);
      addRadioButton("Œrednia", 12);
      addRadioButton("Du¿a", 18);
      addRadioButton("Bardzo du¿a", 36);

      add(buttonPanel, BorderLayout.SOUTH);
      pack();
   }

   /**
    * Tworzy prze³¹cznik ustawiaj¹cy rozmiar czcionki przyk³adowego tekstu.
    * @param name ³añcuch identyfikuj¹cy prze³¹cznik
    * @param size rozmiar czcionki ustawiany przez ten prze³¹cznik
    */

   public void addRadioButton(String name, final int size)
   {
      boolean selected = size == DEFAULT_SIZE;
      JRadioButton button = new JRadioButton(name, selected);
      group.add(button);
      buttonPanel.add(button);

      // Niniejszy s³uchacz ustawia rozmiar czcionki etykiety

      ActionListener listener = new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               // Parametr size odwo³uje siê do ostatniego parametru metody addRadioButton
               label.setFont(new Font("Serif", Font.PLAIN, size));
            }
         };

      button.addActionListener(listener);
   }
}