package clone;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable
{
   private String name;
   private double salary;
   private Date hireDay;

   public Employee(String n, double s)
   {
      name = n;
      salary = s;
      hireDay = new Date();
   }

   public Employee clone() throws CloneNotSupportedException
   {
      // Wywo³anie metody Object.clone().
      Employee cloned = (Employee) super.clone();

      // Klonowanie pól zmienialnych.
      cloned.hireDay = (Date) hireDay.clone();

      return cloned;
   }

   /**
    * Ustawia datê zatrudnienia na podany dzieñ.
    * @param year rok zatrudnienia
    * @param month miesi¹c zatrudnienia
    * @param day dzieñ zatrudnienia
    */
   public void setHireDay(int year, int month, int day)
   {
      Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
      // Przyk³ad zmiany pola obiektowego.
      hireDay.setTime(newHireDay.getTime());
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }

   public String toString()
   {
      return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
   }
}