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
    * Porównuje pracowników wed³ug wysokoœci pensji.
    * @param other inny obiekt klasy Employee
    * @return wartoœæ ujemna, jeœli pracownik ma ni¿sz¹ pensjê ni¿ inny (other) pracownik,
    * 0, jeœli pensje s¹ równe, liczba dodatnia w przeciwnym razie
    */
   public int compareTo(Employee other)
   {
      return Double.compare(salary, other.salary);
   }
}
