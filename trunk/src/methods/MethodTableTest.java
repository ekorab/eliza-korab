package methods;

import java.lang.reflect.*;

/**
 * Niniejszy program demonstruje spos�b wywo�ywania metod poprzez refleksj�.
 * @version 1.2 2012-05-04
 * @author Cay Horstmann
 */
public class MethodTableTest
{
   public static void main(String[] args) throws Exception
   {
      // Pobranie wska�nik�w do metod square i sqrt.
      Method square = MethodTableTest.class.getMethod("square", double.class);
      Method sqrt = Math.class.getMethod("sqrt", double.class);

      // Drukowanie tabel warto�ci x i y.

      printTable(1, 10, 10, square);
      printTable(1, 10, 10, sqrt);
   }

   /**
    * Zwraca kwadrat liczby.
    * @param x liczba
    * @return x podniesione do kwadratu
    */
   public static double square(double x)
   {
      return x * x;
   }

   /**
    * Drukuje tablic� warto�ci x i y dla danej metody.
    * @param od dolnej granicy warto�ci x
    * @param do g�rnej granicy warto�ci x
    * @param n liczba wierszy w tabeli
    * @param f metoda z parametrem i typem zwrotnym typu double
    */
   public static void printTable(double from, double to, int n, Method f)
   {
      // Drukowanie metody jako nag��wka tabeli.
      System.out.println(f);

      double dx = (to - from) / (n - 1);

      for (double x = from; x <= to; x += dx)
      {
         try
         {
            double y = (Double) f.invoke(null, x);
            System.out.printf("%10.4f | %10.4f%n", x, y);
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
   }
}
