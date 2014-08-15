package dataExchange;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Elementy s³u¿¹ce do podania has³a, które widaæ w oknie dialogowym
 */
public class PasswordChooser extends JPanel
{
   private JTextField username;
   private JPasswordField password;
   private JButton okButton;
   private boolean ok;
   private JDialog dialog;

   public PasswordChooser()
   {
      setLayout(new BorderLayout());

      // Utworzenie panelu z polami nazwy u¿ytkownika i has³a

      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(2, 2));
      panel.add(new JLabel("User name:"));
      panel.add(username = new JTextField(""));
      panel.add(new JLabel("Password:"));
      panel.add(password = new JPasswordField(""));
      add(panel, BorderLayout.CENTER);

      // Utworzenie przycisków OK i Anuluj, które zamykaj¹ okno dialogowe

      okButton = new JButton("Ok");
      okButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               ok = true;
               dialog.setVisible(false);
            }
         });

      JButton cancelButton = new JButton("Cancel");
      cancelButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               dialog.setVisible(false);
            }
         });

      // Dodawanie przycisków w pobli¿u po³udniowej krawêdzi

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(okButton);
      buttonPanel.add(cancelButton);
      add(buttonPanel, BorderLayout.SOUTH);
   }

   /**
    * Ustawia wartoœci domyœlne okna dialogowego
    * @param u domyœlne informacje u¿ytkownika
    */
   public void setUser(User u)
   {
      username.setText(u.getName());
   }

   /**
    * Pobiera dane podane w oknie dialogowym
    * @return a obiekt typu User, którego stan reprezentuje dane wprowadzone w oknie dialogowym
    */
   public User getUser()
   {
      return new User(username.getText(), password.getPassword());
   }

   /**
    * Wyœwietla panel z elementami przyjmuj¹cymi dane od u¿ytkownika w oknie dialogowym
    * @param parent komponent w ramce nadrzêdnej lub wartoœæ null
    * @param title tytu³ okna dialogowego
    */
   public boolean showDialog(Component parent, String title)
   {
      ok = false;

      // Lokalizacja ramki nadrzêdnej

      Frame owner = null;
      if (parent instanceof Frame) owner = (Frame) parent;
      else owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);

      // Jeœli jest to pierwszy raz lub zmieni³ siê u¿ytkownik, utworzenie nowego okna dialogowego

      if (dialog == null || dialog.getOwner() != owner)
      {
         dialog = new JDialog(owner, true);
         dialog.add(this);
         dialog.getRootPane().setDefaultButton(okButton);
         dialog.pack();
      }

      // Ustawienie tytu³u i wyœwietlenie okna dialogowego

      dialog.setTitle(title);
      dialog.setVisible(true);
      return ok;
   }
}
