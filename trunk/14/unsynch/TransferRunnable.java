package unsynch;

/**
 * Obiekt Runnable przelewaj¹cy pieni¹dze z jednego konta bankowego na inne
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 */
public class TransferRunnable implements Runnable
{
   private Bank bank;
   private int fromAccount;
   private double maxAmount;
   private int DELAY = 10;

   /**
    * Tworzy obiekt Runnable do przelewania œrodków
    * @param b bank, na którego kontach wykonywany jest przelew
    * @param from konto, z którego maj¹ byæ przelane pieni¹dze
    * @param max maksymalna suma, jaka mo¿e zostaæ przelana za ka¿dym razem
    */
   public TransferRunnable(Bank b, int from, double max)
   {
      bank = b;
      fromAccount = from;
      maxAmount = max;
   }

   public void run()
   {
      try
      {
         while (true)
         {
            int toAccount = (int) (bank.size() * Math.random());
            double amount = maxAmount * Math.random();
            bank.transfer(fromAccount, toAccount, amount);
            Thread.sleep((int) (DELAY * Math.random()));
         }
      }
      catch (InterruptedException e)
      {
      }
   }
}
