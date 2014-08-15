package slider;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Ramka zawieraj¹ca kilka suwaków oraz pole tekstowe pokazuj¹ce wartoœci ustawiane za ich pomoc¹
 */
public class SliderFrame extends JFrame
{
   private JPanel sliderPanel;
   private JTextField textField;
   private ChangeListener listener;

   public SliderFrame()
   {
      sliderPanel = new JPanel();
      sliderPanel.setLayout(new GridBagLayout());      

      // Wspólny s³uchacz wszystkich suwaków
      listener = new ChangeListener()
         {
            public void stateChanged(ChangeEvent event)
            {
               // Aktualizacja pola tekstowego w odpowiedzi na zmianê wartoœci suwaka
               JSlider source = (JSlider) event.getSource();
               textField.setText("" + source.getValue());
            }
         };

      // Zwyk³y suwak

      JSlider slider = new JSlider();
      addSlider(slider, "Plain");

      // Suwak z podzia³k¹

      slider = new JSlider();
      slider.setPaintTicks(true);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(5);
      addSlider(slider, "Ticks");

      // Suwak z dosuwaniem ga³ki do najbli¿szej kreski

      slider = new JSlider();
      slider.setPaintTicks(true);
      slider.setSnapToTicks(true);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(5);
      addSlider(slider, "Snap to ticks");

      // Suwak bez prowadnicy

      slider = new JSlider();
      slider.setPaintTicks(true);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(5);
      slider.setPaintTrack(false);
      addSlider(slider, "No track");

      // Suwak o odwróconym dzia³aniu

      slider = new JSlider();
      slider.setPaintTicks(true);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(5);
      slider.setInverted(true);
      addSlider(slider, "Inverted");

      // Suwak z etykietami liczbowymi

      slider = new JSlider();
      slider.setPaintTicks(true);
      slider.setPaintLabels(true);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(5);
      addSlider(slider, "Labels");

      // Suwak z etykietami literowymi

      slider = new JSlider();
      slider.setPaintLabels(true);
      slider.setPaintTicks(true);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(5);

      Dictionary<Integer, Component> labelTable = new Hashtable<Integer, Component>();
      labelTable.put(0, new JLabel("A"));
      labelTable.put(20, new JLabel("B"));
      labelTable.put(40, new JLabel("C"));
      labelTable.put(60, new JLabel("D"));
      labelTable.put(80, new JLabel("E"));
      labelTable.put(100, new JLabel("F"));

      slider.setLabelTable(labelTable);
      addSlider(slider, "Custom labels");

      // Suwak z etykietami ikonowymi

      slider = new JSlider();
      slider.setPaintTicks(true);
      slider.setPaintLabels(true);
      slider.setSnapToTicks(true);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(20);

      labelTable = new Hashtable<Integer, Component>();

      // Dodawanie obrazów kart

      labelTable.put(0, new JLabel(new ImageIcon("nine.gif")));
      labelTable.put(20, new JLabel(new ImageIcon("ten.gif")));
      labelTable.put(40, new JLabel(new ImageIcon("jack.gif")));
      labelTable.put(60, new JLabel(new ImageIcon("queen.gif")));
      labelTable.put(80, new JLabel(new ImageIcon("king.gif")));
      labelTable.put(100, new JLabel(new ImageIcon("ace.gif")));

      slider.setLabelTable(labelTable);
      addSlider(slider, "Icon labels");

      // Dodawanie pola tekstowego, które wyœwietla wartoœæ ustawion¹ na suwaku

      textField = new JTextField();
      add(sliderPanel, BorderLayout.CENTER);
      add(textField, BorderLayout.SOUTH);
      pack();
   }

   /**
    * Dodaje suwak do panelu suwaków i wi¹¿e s³uchacza.
    * @param s suwak
    * @param description opis suwaka
    */

   public void addSlider(JSlider s, String description)
   {
      s.addChangeListener(listener);
      JPanel panel = new JPanel();      
      panel.add(s);
      panel.add(new JLabel(description));
      panel.setAlignmentX(Component.LEFT_ALIGNMENT);
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridy = sliderPanel.getComponentCount();
      gbc.anchor = GridBagConstraints.WEST;
      sliderPanel.add(panel, gbc);      
   }
}