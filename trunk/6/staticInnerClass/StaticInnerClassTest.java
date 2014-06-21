package staticInnerClass;

/**
 * Niniejszy program demonstruje zastosowanie statycznych klas wewnêtrznych.
 * @version 1.01 2004-02-27
 * @author Cay Horstmann
 */
public class StaticInnerClassTest
{
   public static void main(String[] args)
   {
      double[] d = new double[20];
      for (int i = 0; i < d.length; i++)
         d[i] = 100 * Math.random();
      ArrayAlg.Pair p = ArrayAlg.minmax(d);
      System.out.println("min = " + p.getFirst());
      System.out.println("max = " + p.getSecond());
   }
}

class ArrayAlg
{
   /**
    * Para liczb zmiennoprzecinkowych.
    */
   public static class Pair
   {
      private double first;
      private double second;

      /**
       * Tworzy parê dwóch liczb zmiennoprzecinkowych.
       * @param f pierwsza liczba
       * @param s druga liczba
       */
      public Pair(double f, double s)
      {
         first = f;
         second = s;
      }

      /**
       * Zwraca pierwsz¹ liczbê z pary.
       * @return pierwsza liczba
       */
      public double getFirst()
      {
         return first;
      }

      /**
       * Zwraca drug¹ liczbê z pary.
       * @return druga liczba
       */
      public double getSecond()
      {
         return second;
      }
   }

   /**
    * Znajduje najwiêksz¹ i najmniejsz¹ wartoœæ w tablicy.
    * @param values tablica liczb zmiennoprzecinkowych
    * @return para liczb, w której pierwsza liczba okreœla wartoœæ najmniejsz¹, a druga
    * najwiêksz¹
    */
   public static Pair minmax(double[] values)
   {
      double min = Double.MAX_VALUE;
      double max = Double.MIN_VALUE;
      for (double v : values)
      {
         if (min > v) min = v;
         if (max < v) max = v;
      }
      return new Pair(min, max);
   }
}