package staticInnerClass;

/**
 * Niniejszy program demonstruje zastosowanie statycznych klas wewn�trznych.
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
       * Tworzy par� dw�ch liczb zmiennoprzecinkowych.
       * @param f pierwsza liczba
       * @param s druga liczba
       */
      public Pair(double f, double s)
      {
         first = f;
         second = s;
      }

      /**
       * Zwraca pierwsz� liczb� z pary.
       * @return pierwsza liczba
       */
      public double getFirst()
      {
         return first;
      }

      /**
       * Zwraca drug� liczb� z pary.
       * @return druga liczba
       */
      public double getSecond()
      {
         return second;
      }
   }

   /**
    * Znajduje najwi�ksz� i najmniejsz� warto�� w tablicy.
    * @param values tablica liczb zmiennoprzecinkowych
    * @return para liczb, w kt�rej pierwsza liczba okre�la warto�� najmniejsz�, a druga
    * najwi�ksz�
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