package enums;

import java.util.*;

/**
 * Niniejszy program demonstruje typy wyliczeniowe.
 * @version 1.0 2004-05-24
 * @author Cay Horstmann
 */
public class EnumTest
{ 
   public static void main(String[] args)
   { 
      Scanner in = new Scanner(System.in);
      System.out.print("Podaj rozmiar: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
      String input = in.next().toUpperCase();
      Size size = Enum.valueOf(Size.class, input);
      System.out.println("rozmiar=" + size);
      System.out.println("skr�t=" + size.getAbbreviation());
      if (size == Size.EXTRA_LARGE)
         System.out.println("Dobra robota -- nie pomin��e� znaku podkre�lenia _.");
   }
}	

enum Size
{
   SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

   private Size(String abbreviation) { this.abbreviation = abbreviation; }
   public String getAbbreviation() { return abbreviation; }

   private String abbreviation;
}
