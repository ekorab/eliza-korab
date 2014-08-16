package threadPool;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * @version 1.01 2012-01-26
 * @author Cay Horstmann
 */
public class ThreadPoolTest
{
   public static void main(String[] args) throws Exception
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Podaj katalog bazowy (np. /usr/local/jdk1.6.0/src): ");
      String directory = in.nextLine();
      System.out.print("Podaj s³owo kluczowe (np. volatile): ");
      String keyword = in.nextLine();

      ExecutorService pool = Executors.newCachedThreadPool();

      MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
      Future<Integer> result = pool.submit(counter);

      try
      {
         System.out.println(result.get() + " matching files.");
      }
      catch (ExecutionException e)
      {
         e.printStackTrace();
      }
      catch (InterruptedException e)
      {
      }
      pool.shutdown();

      int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
      System.out.println("largest pool size=" + largestPoolSize);
   }
}

/**
 * Zadanie licz¹ce pliki w katalogu i jego podkatalogach, zawieraj¹ce dane s³owo kluczowe
 */
class MatchCounter implements Callable<Integer>
{
   private File directory;
   private String keyword;
   private ExecutorService pool;
   private int count;

   /**
    * Tworzy obiekt typu MatchCounter.
    * @param directory katalog, od którego ma zacz¹æ siê szukanie
    * @param keyword s³owo kluczowe do znalezienia
    * @param pool pula w¹tków, do której wysy³ane s¹ zadania
    */
   public MatchCounter(File directory, String keyword, ExecutorService pool)
   {
      this.directory = directory;
      this.keyword = keyword;
      this.pool = pool;
   }

   public Integer call()
   {
      count = 0;
      try
      {
         File[] files = directory.listFiles();
         List<Future<Integer>> results = new ArrayList<>();

         for (File file : files)
            if (file.isDirectory())
            {
               MatchCounter counter = new MatchCounter(file, keyword, pool);
               Future<Integer> result = pool.submit(counter);
               results.add(result);
            }
            else
            {
               if (search(file)) count++;
            }

         for (Future<Integer> result : results)
            try
            {
               count += result.get();
            }
            catch (ExecutionException e)
            {
               e.printStackTrace();
            }
      }
      catch (InterruptedException e)
      {
      }
      return count;
   }

   /**
    * Przeszukuje plik w celu znalezienia danego s³owa kluczowego.
    * @param file plik do przeszukania
    * @return wartoœæ true, jeœli plik zawiera s³owo kluczowe
    */

   public boolean search(File file)
   {
      try
      {
         try (Scanner in = new Scanner(file))
         {
            boolean found = false;
            while (!found && in.hasNextLine())
            {
               String line = in.nextLine();
               if (line.contains(keyword)) found = true;
            }         
            return found;
         }
      }
      catch (IOException e)
      {
         return false;
      }
   }
}
