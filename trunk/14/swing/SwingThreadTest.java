package swing;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Program udowadniaj�cy, �e w�tek dzia�aj�cy r�wnolegle z w�tkiem dystrybucji zdarze� mo�e powodowa� b��dy w komponentach Swing

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
 * Ramka maj�ca dwa przyciski s�u��ce do zape�niania listy w osobnym w�tku. Przycisk Dobry wykorzystuje
 * kolejk� zdarze�, a Z�y modyfikuje list� bezpo�rednio.
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
      JButton badButton = new JButton("Z�y");
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
 * Klasa modyfikuj�ca list� rozwijan�, dodaj�c do niej i usuwaj�c z niej losowe liczby. Mo�e to spowodowa� b��dy,
 * poniewa� metody listy rozwijalnej nie s� synchronizowane, przez co w�tek roboczy i w�tek dystrybucji zdarze�
 * uzyskuj� dost�p do tej listy.
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
 * Klasa modyfikuj�ca list� rozwijan�, dodaj�c do niej i usuwaj�c z niej losowe liczby. Aby unikn��
 * uszkodzenia tej listy, operacje edycji s� przesy�ane do w�tku dystrybucji zdarze�.
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
