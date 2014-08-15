package abstractClasses;

import java.util.*;

/**
 * Niniejszy program demonstruje klasy abstrakcyjne.
 * @version 1.01 2004-02-21
 * @author Cay Horstmann
 */
public class PersonTest
{
   public static void main(String[] args)
   {
      Person[] people = new Person[2];

      // Wstawienie do tablicy people obiektów Student i Employee.
      people[0] = new Employee("Henryk Kwiatek", 50000, 1989, 10, 1);
      people[1] = new Student("Maria Mrozowska", "informatyka");

      // Drukowanie imion i nazwisk oraz opisów wszystkich obiektów klasy Person.
      for (Person p : people)
         System.out.println(p.getName() + ", " + p.getDescription());
   }
}