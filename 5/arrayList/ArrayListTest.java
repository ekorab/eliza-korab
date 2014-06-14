package arrayList;

import java.util.*;

/**
 * Niniejszy program demonstruje u¿ycie klasy ArrayList.
 * @version 1.11 2012-01-26
 * @author Cay Horstmann
 */
public class ArrayListTest
{
   public static void main(String[] args)
   {
      // Wstawienie do listy staff trzech obiektów klasy Employee.
      ArrayList<Employee> staff = new ArrayList<Employee>();

      staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
      staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
      staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

      // Zwiêkszenie pensji wszystkich pracowników o 5%.
      for (Employee e : staff)
         e.raiseSalary(5);

      // Drukowanie informacji o wszystkich obiektach Employee.
      for (Employee e : staff)
         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay="
               + e.getHireDay());
   }
}