package colorChooser;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Panel z przyciskami uruchamiaj¹cymi trzy typy okien
 */
public class ColorChooserPanel extends JPanel
{
   public ColorChooserPanel()
   {
      JButton modalButton = new JButton("Modalne");
      modalButton.addActionListener(new ModalListener());
      add(modalButton);

      JButton modelessButton = new JButton("Niemodalne");
      modelessButton.addActionListener(new ModelessListener());
      add(modelessButton);

      JButton immediateButton = new JButton("Bezpoœrednie");
      immediateButton.addActionListener(new ImmediateListener());
      add(immediateButton);
   }

   /**
    * Ten s³uchacz wyœwietla okno modalne.
    */
   private class ModalListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         Color defaultColor = getBackground();
         Color selected = JColorChooser.showDialog(ColorChooserPanel.this, "Ustaw kolor t³a",
               defaultColor);
         if (selected != null) setBackground(selected);
      }
   }

   /**
    * Ten s³uchacz wyœwietla okno niemodalne. Kolor t³a panelu zmienia siê po
    * klikniêciu przycisku OK.
    */
   private class ModelessListener implements ActionListener
   {
      private JDialog dialog;
      private JColorChooser chooser;

      public ModelessListener()
      {
         chooser = new JColorChooser();
         dialog = JColorChooser.createDialog(ColorChooserPanel.this, "Kolor t³a",
               false /* niemodalne */, chooser, new ActionListener()   // S³uchacz przycisku OK
                  {
                     public void actionPerformed(ActionEvent event)
                     {
                        setBackground(chooser.getColor());
                     }
                  }, null /* Brak s³uchacza dla przycisku Cancel. */);
      }

      public void actionPerformed(ActionEvent event)
      {
         chooser.setColor(getBackground());
         dialog.setVisible(true);
      }
   }

   /**
    * Ten s³uchacz wyœwietla okno niemodalne. Kolor t³a panelu zmienia siê bezpoœrednio 
    * po wybraniu przez u¿ytkownika koloru.
    */
   private class ImmediateListener implements ActionListener
   {
      private JDialog dialog;
      private JColorChooser chooser;

      public ImmediateListener()
      {
         chooser = new JColorChooser();
         chooser.getSelectionModel().addChangeListener(new ChangeListener()
            {
               public void stateChanged(ChangeEvent event)
               {
                  setBackground(chooser.getColor());
               }
            });

         dialog = new JDialog((Frame) null, false /* niemodalne */);
         dialog.add(chooser);
         dialog.pack();
      }

      public void actionPerformed(ActionEvent event)
      {
         chooser.setColor(getBackground());
         dialog.setVisible(true);
      }
   }
}