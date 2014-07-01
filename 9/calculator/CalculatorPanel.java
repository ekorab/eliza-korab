package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Panel z przyciskami kalkulatora i wyœwietlaczem wyniku.
*/
public class CalculatorPanel extends JPanel
{
   private JButton display;
   private JPanel panel;
   private double result;
   private String lastCommand;
   private boolean start;

   public CalculatorPanel()
   {
      setLayout(new BorderLayout());

      result = 0;
      lastCommand = "=";
      start = true;

      // Dodanie wyœwietlacza

      display = new JButton("0");
      display.setEnabled(false);
      add(display, BorderLayout.NORTH);

      ActionListener insert = new InsertAction();
      ActionListener command = new CommandAction();

      // Wstawienie przycisków na siatkê 4×4

      panel = new JPanel();
      panel.setLayout(new GridLayout(4, 4));

      addButton("7", insert);
      addButton("8", insert);
      addButton("9", insert);
      addButton("/", command);

      addButton("4", insert);
      addButton("5", insert);
      addButton("6", insert);
      addButton("*", command);

      addButton("1", insert);
      addButton("2", insert);
      addButton("3", insert);
      addButton("-", command);

      addButton("0", insert);
      addButton(".", insert);
      addButton("=", command);
      addButton("+", command);

      add(panel, BorderLayout.CENTER);
   }

   /**
    * Dodaje przycisk do panelu centralnego.
    * @param label etykieta przycisku
    * @param listener s³uchacz przycisków
    */

   private void addButton(String label, ActionListener listener)
   {
      JButton button = new JButton(label);
      button.addActionListener(listener);
      panel.add(button);
   }

   /**
    * Niniejsza akcja wstawia ³añcuch akcji przycisku na koñcu tekstu do wyœwietlenia.
    */

   private class InsertAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         String input = event.getActionCommand();
         if (start)
         {
            display.setText("");
            start = false;
         }
         display.setText(display.getText() + input);
      }
   }

   /**
    * Niniejsza akcja wykonuje polecenia okreœlone przez akcjê przycisku.
    */

   private class CommandAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         String command = event.getActionCommand();

         if (start)
         {
            if (command.equals("-"))
            {
               display.setText(command);
               start = false;
            }
            else lastCommand = command;
         }
         else
         {
            calculate(Double.parseDouble(display.getText()));
            lastCommand = command;
            start = true;
         }
      }
   }

   /**
    * Wykonuje oczekuj¹ce dzia³ania.
    * @param x wartoœæ, która ma byæ po³¹czona z poprzednim wynikiem.
    */

   public void calculate(double x)
   {
      if (lastCommand.equals("+")) result += x;
      else if (lastCommand.equals("-")) result -= x;
      else if (lastCommand.equals("*")) result *= x;
      else if (lastCommand.equals("/")) result /= x;
      else if (lastCommand.equals("=")) result = x;
      display.setText("" + result);
   }
}
