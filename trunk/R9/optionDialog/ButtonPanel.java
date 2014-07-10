package optionDialog;

import javax.swing.*;

/**
 * Panel z prze³¹cznikami w ramce z tytu³em
 */
public class ButtonPanel extends JPanel
{
   private ButtonGroup group;

   /**
    * Tworzy panel przycisków
    * @param title Tytu³ wyœwietlany w obramowaniu
    * @param options Tablica etykiet prze³¹czników
    */
   public ButtonPanel(String title, String... options)
   {
      setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      group = new ButtonGroup();

      // Utworzenie po jednym prze³¹czniku dla ka¿dej opcji
      for (String option : options)
      {
         JRadioButton b = new JRadioButton(option);
         b.setActionCommand(option);
         add(b);
         group.add(b);
         b.setSelected(option == options[0]);
      }
   }

   /**
    * Pobiera aktualnie wybran¹ opcjê
    * @return Zwraca etykietê aktualnie wybranego prze³¹cznika
    */
   public String getSelection()
   {
      return group.getSelection().getActionCommand();
   }
}

