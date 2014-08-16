package swing;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Program udowadniaj¹cy, ¿e w¹tek dzia³aj¹cy równolegle z w¹tkiem dystrybucji zdarzeñ mo¿e powodowaæ b³êdy w komponentach Swing

 * cause errors in Swing components.
 * @version 1.23 2007-05-17
 * @author Cay Horstmann
 */
public class SwingThreadTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new SwingThreadFrame();
               frame.setTitle("SwingThreadTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * Ramka maj¹ca dwa przyciski s³u¿¹ce do zape³niania listy w osobnym w¹tku. Przycisk Dobry wykorzystuje
 * kolejkê zdarzeñ, a Z³y modyfikuje listê bezpoœrednio.
 */

class SwingThreadFrame extends JFrame
{
   public SwingThreadFrame()
   {
      final JComboBox<Integer> combo = new JComboBox<>();
      combo.insertItemAt(Integer.MAX_VALUE, 0);
      combo.setPrototypeDisplayValue(combo.getItemAt(0));
      combo.setSelectedIndex(0);

      JPanel panel = new JPanel();

      JButton goodButton = new JButton("Dobry");
      goodButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               new Thread(new GoodWorkerRunnable(combo)).start();
            }
         });
      panel.add(goodButton);
      JButton badButton = new JButton("Z³y");
      badButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               new Thread(new BadWorkerRunnable(combo)).start();
            }
         });
      panel.add(badButton);

      panel.add(combo);
      add(panel);
      pack();
   }
}

/**
 * Klasa modyfikuj¹ca listê rozwijan¹, dodaj¹c do niej i usuwaj¹c z niej losowe liczby. Mo¿e to spowodowaæ b³êdy,
 * poniewa¿ metody listy rozwijalnej nie s¹ synchronizowane, przez co w¹tek roboczy i w¹tek dystrybucji zdarzeñ
 * uzyskuj¹ dostêp do tej listy.
 */

class BadWorkerRunnable implements Runnable
{
   private JComboBox<Integer> combo;
   private Random generator;

   public BadWorkerRunnable(JComboBox<Integer> aCombo)
   {
      combo = aCombo;
      generator = new Random();
   }

   public void run()
   {
      try
      {
         while (true)
         {
            int i = Math.abs(generator.nextInt());
            if (i % 2 == 0) combo.insertItemAt(i, 0);
            else if (combo.getItemCount() > 0) combo.removeItemAt(i % combo.getItemCount());
            Thread.sleep(1);
         }
      }
      catch (InterruptedException e)
      {
      }
   }
}

/**
 * Klasa modyfikuj¹ca listê rozwijan¹, dodaj¹c do niej i usuwaj¹c z niej losowe liczby. Aby unikn¹æ
 * uszkodzenia tej listy, operacje edycji s¹ przesy³ane do w¹tku dystrybucji zdarzeñ.
 */
class GoodWorkerRunnable implements Runnable
{
   private JComboBox<Integer> combo;
   private Random generator;

   public GoodWorkerRunnable(JComboBox<Integer> aCombo)
   {
      combo = aCombo;
      generator = new Random();
   }

   public void run()
   {
      try
      {
         while (true)
         {
            EventQueue.invokeLater(new Runnable()
               {
                  public void run()
                  {
                     int i = Math.abs(generator.nextInt());
                     if (i % 2 == 0) combo.insertItemAt(i, 0);
                     else if (combo.getItemCount() > 0) combo.removeItemAt(i
                           % combo.getItemCount());
                  }
               });
            Thread.sleep(1);
         }
      }
      catch (InterruptedException e)
      {
      }
   }
}
