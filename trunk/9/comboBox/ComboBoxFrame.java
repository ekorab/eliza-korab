package comboBox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Ramka z przyk³adow¹ etykiet¹ tekstow¹ i list¹ rozwijaln¹ umo¿liwiaj¹c¹ wybór kroju czcionki.
 */
public class ComboBoxFrame extends JFrame
{
   private JComboBox<String> faceCombo;
   private JLabel label;
   private static final int DEFAULT_SIZE = 24;

   public ComboBoxFrame()
   {
      // Dodanie tekstu etykiety

      label = new JLabel("Koñ i ¿ó³w grali w koœci z piêkn¹ æm¹ u Ÿród³a.");
      label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
      add(label, BorderLayout.CENTER);

      // Tworzenie listy rozwijalnej i dodawanie nazw czcionek

      faceCombo = new JComboBox<String>();
      faceCombo.addItem("Serif");
      faceCombo.addItem("SansSerif");
      faceCombo.addItem("Monospaced");
      faceCombo.addItem("Dialog");
      faceCombo.addItem("DialogInput");

      // S³uchacz listy rozwijalnej zmienia krój pisma etykiety na czcionkê wybran¹ przez u¿ytkownika

      faceCombo.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()), Font.PLAIN,
                     DEFAULT_SIZE));
            }
         });

      // Dodanie listy rozwijalnej do panelu znajduj¹cego siê przy po³udniowej krawêdzi ramki

      JPanel comboPanel = new JPanel();
      comboPanel.add(faceCombo);
      add(comboPanel, BorderLayout.SOUTH);
      pack();
   }
}
