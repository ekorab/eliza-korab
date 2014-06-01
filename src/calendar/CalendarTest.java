package calendar;

import java.text.DateFormatSymbols;
import java.util.*;

/**
 * @version 1.4 2007-04-07
 * @author Cay Horstmann
 */

public class CalendarTest
{
   public static void main(String[] args)
   {
	   //Locale.setDefault(Locale.ENGLISH);
      // Konstrukcja i ustawienie obiektu d oraz jego inicjacja aktualn¹ dat¹.
      GregorianCalendar d = new GregorianCalendar();

      int today = d.get(Calendar.DAY_OF_MONTH);
      int month = d.get(Calendar.MONTH);

      // Ustawienie d na pocz¹tek miesi¹ca.
      d.set(Calendar.DAY_OF_MONTH, 1);

      int weekday = d.get(Calendar.DAY_OF_WEEK);

      // Pobranie pierwszego dnia tygodnia (poniedzia³ek w Polsce).
      int firstDayOfWeek = d.getFirstDayOfWeek();

      // Okreœlenie odpowiedniego wciêcia pierwszego wiersza.
      int indent = 0;
      while (weekday != firstDayOfWeek)
      {
         indent++;
         d.add(Calendar.DAY_OF_MONTH, -1);
         weekday = d.get(Calendar.DAY_OF_WEEK);
      }

      // Drukowanie nazw dni tygodnia.
      String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
      do
      {
         System.out.printf("%4s", weekdayNames[weekday]);
         d.add(Calendar.DAY_OF_MONTH, 1);
         weekday = d.get(Calendar.DAY_OF_WEEK);
      }
      while (weekday != firstDayOfWeek);
      System.out.println();

      for (int i = 1; i <= indent; i++)
         System.out.print("    ");

      d.set(Calendar.DAY_OF_MONTH, 1);
      do
      {
         // Drukowanie dnia.
         int day = d.get(Calendar.DAY_OF_MONTH);
         System.out.printf("%3d", day);

         // Oznaczenie bie¿¹cego dnia znakiem *.
         if (day == today) System.out.print("*");
         else System.out.print(" ");

         // Ustawienie d na kolejny dzieñ.
         d.add(Calendar.DAY_OF_MONTH, 1);
         weekday = d.get(Calendar.DAY_OF_WEEK);

         // Rozpoczêcie nowego wiersza na pocz¹tku tygodnia.
         if (weekday == firstDayOfWeek) System.out.println();
      }
      while (d.get(Calendar.MONTH) == month);
      // Pêtla koñczy dzia³anie, jeœli d jest pierwszym dniem nastêpnego miesi¹ca.

      // Wydruk koñcowego znaku nowego wiersza w razie potrzeby.
      if (weekday != firstDayOfWeek) System.out.println();
   }
}