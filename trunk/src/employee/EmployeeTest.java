package employee;

import java.util.*;

/**
 * Niniejszy program sprawdza dzia³anie klasy Employee.
 * @version 1.11 2004-02-19
 * @author Cay Horstmann
 */




 
public class EmployeeTest
{
   public static void main(String[] args)
   {
      // Wstawienie trzech obiektów pracowników do tablicy staff.
      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Jaros³aw Rybiñski", 75000, 1987, 12, 15);
      staff[1] = new Employee("Katarzyna Remiszewska ", 50000, 1989, 10, 1);
      staff[2] = new Employee("Krystyna Kuczyñska ", 40000, 1990, 3, 15);

      // Zwiêkszenie pensji wszystkich pracowników o 5%.
      for (Employee e : staff)
         e.raiseSalary(5);

      // Drukowanie informacji o wszystkich obiektach klasy Employee.
      for (Employee e : staff)
         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay="
               + e.getHireDay());
   }
}

class Employee
{
   private String name;
   private double salary;
   private Date hireDay;

   public Employee(String n, double s, int year, int month, int day)
   {
      name = n;
      salary = s;
      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
      // W klasie GregorianCalendar styczeñ ma numer 0.
      hireDay = calendar.getTime();
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public Date getHireDay()
   {
      return hireDay;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }
}


