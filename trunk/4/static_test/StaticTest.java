package static_test;

/**
 * Niniejszy program demonstruje u¿ycie metod statycznych.
 * @version 1.01 2004-02-19
 * @author Cay Horstmann
 */
public class StaticTest
{
   public static void main(String[] args)
   {
      // Wstawienie do tablicy staff trzech obiektów reprezentuj¹cych pracowników.
      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Tomasz", 40000);
      staff[1] = new Employee("Dariusz", 60000);
      staff[2] = new Employee("Grzegorz", 65000);

      // Drukowanie informacji o wszystkich obiektach klasy Employee.
      for (Employee e : staff)
      {
         e.setId();
         System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
               + e.getSalary());
      }

      int n = Employee.getNextId();   // Wywo³anie metody statycznej.
      System.out.println("Next available id=" + n);
   }
}

class Employee
{
   private static int nextId = 1;

   private String name;
   private double salary;
   private int id;
   
   public Employee(String n, double s)
   {
      name = n;
      salary = s;
      id = 0;
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public int getId()
   {
      return id;
   }

   public void setId()
   {
      id = nextId;                        // Ustawienie identyfikatora na kolejny dostêpny numer.
      nextId++;
   }

   public static int getNextId()
   {
      return nextId;                      // Zwrócenie pola statycznego.
   }

   public static void main(String[] args) // test jednostkowy
   {
      Employee e = new Employee("Grzegorz", 50000);
      System.out.println(e.getName() + " " + e.getSalary());
   }
}
