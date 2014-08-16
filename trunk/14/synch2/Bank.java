package synch2;

/**
 * Bank z kilkoma kontami, wykorzystuj¹cy synchronizacjê
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 */
public class Bank
{
   private final double[] accounts;

   /**
    * Tworzy bank.
    * @param n liczba kont
    * @param initialBalance saldo pocz¹tkowe na ka¿dym koncie
    */

   public Bank(int n, double initialBalance)
   {
      accounts = new double[n];
      for (int i = 0; i < accounts.length; i++)
         accounts[i] = initialBalance;
   }

   /**
    * Przelewa pieni¹dze pomiêdzy kontami.
    * @param from konto, z którego ma nast¹piæ przelew
    * @param to konto, na które maj¹ zostaæ przelane œrodki
    * @param amount kwota do przelania
    */

   public synchronized void transfer(int from, int to, double amount) throws InterruptedException
   {
      while (accounts[from] < amount)
         wait();
      System.out.print(Thread.currentThread());
      accounts[from] -= amount;
      System.out.printf(" %10.2f z %d na %d", amount, from, to);
      accounts[to] += amount;
      System.out.printf(" Saldo ogólne: %10.2f%n", getTotalBalance());
      notifyAll();
   }

   /**
    * Zwraca sumê sald wszystkich kont.
    * @return saldo ogólne
    */

   public synchronized double getTotalBalance()
   {
      double sum = 0;

      for (double a : accounts)
         sum += a;

      return sum;
   }

   /**
    * Zwraca liczbê kont w banku.
    * @return liczba kont
    */

   public int size()
   {
      return accounts.length;
   }
}
