package interfaces;


public class Employee implements Comparable<Employee>
{
   private String name;
   private double salary;

   public Employee(String n, double s)
   {
      name = n;
      salary = s;
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }

   /**
    * Por�wnuje pracownik�w wed�ug wysoko�ci pensji.
    * @param other inny obiekt klasy Employee
    * @return warto�� ujemna, je�li pracownik ma ni�sz� pensj� ni� inny (other) pracownik,
    * 0, je�li pensje s� r�wne, liczba dodatnia w przeciwnym razie
    */
   public int compareTo(Employee other)
   {
      return Double.compare(salary, other.salary);
   }
}
