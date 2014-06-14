package constructor_test;

import java.util.*;

/**
 * Niniejszy program demonstruje techniki konstrukcji obiektów.
 * @version 1.01 2004-02-19
 * @author Cay Horstmann
 */
public class ConstructorTest
{
   public static void main(String[] args)
   {
      // Wstawienie do tablic staff trzech obiektów klasy Employee.
      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Harry", 40000);
      staff[1] = new Employee(60000);
      staff[2] = new Employee();

      // Wydruk informacji o wszystkich obiektach klasy Employee.
      for (Employee e : staff)
         System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
               + e.getSalary());
   }
}

class Employee
{
   private static int nextId;

   private int id;
   private String name = "";   // Inicjacja zmiennej sk³adowej obiektu.
   private double salary;

   // Statyczny blok inicjuj¹cy.
   static
   {
      Random generator = new Random();
      // Ustawienie zmiennej nextId na losow¹ liczbê ca³kowit¹ z przedzia³u 0 – 9999.
      nextId = generator.nextInt(10000);
   }

   // Blok inicjuj¹cy obiektów.
   {
      id = nextId;
      nextId++;
   }

   // Trzy konstruktory przeci¹¿one.
   public Employee(String n, double s)
   {
      name = n;
      salary = s;
   }

   public Employee(double s)
   {
      // Wywo³anie konstruktora Employee(String, double).
      this("Employee #" + nextId, s);
   }

   // Konstruktor domyœlny.
   public Employee()
   {
      // Zmienna name zainicjowana wartoœci¹ "" — patrz ni¿ej.
      // Zmienna salary nie jest jawnie ustawiona — inicjacja wartoœci¹ 0.
      // Zmienna id jest inicjowana w bloku inicjuj¹cym.
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
}