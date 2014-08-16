package unsynch;

/**
 * Bank z kilkoma kontami
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
   public void transfer(int from, int to, double amount)
   {
      if (accounts[from] < amount) return;
      System.out.print(Thread.currentThread());
      accounts[from] -= amount;
      System.out.printf(" %10.2f z %d na %d", amount, from, to);
      accounts[to] += amount;
      System.out.printf(" Saldo ogólne: %10.2f%n", getTotalBalance());
   }

   /**
    * Zwraca sumê sald wszystkich kont.
    * @return saldo ogólne
    */
   public double getTotalBalance()
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
