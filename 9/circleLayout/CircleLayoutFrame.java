package circleLayout;

import javax.swing.*;

/**
 * Ramka zawieraj¹ca przyciski u³o¿one na obwodzie okrêgu
 */
public class CircleLayoutFrame extends JFrame
{
   public CircleLayoutFrame()
   {
      setLayout(new CircleLayout());
      add(new JButton("Yellow"));
      add(new JButton("Blue"));
      add(new JButton("Red"));
      add(new JButton("Green"));
      add(new JButton("Orange"));
      add(new JButton("Fuchsia"));
      add(new JButton("Indigo"));
      pack();
   }
}
