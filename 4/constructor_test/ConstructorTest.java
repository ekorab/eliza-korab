package constructor_test;

import java.util.*;

/**
 * Niniejszy program demonstruje techniki konstrukcji obiekt�w.
 * @version 1.01 2004-02-19
 * @author Cay Horstmann
 */
public class ConstructorTest
{
   public static void main(String[] args)
   {
      // Wstawienie do tablic staff trzech obiekt�w klasy Employee.
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
   private String name = "";   // Inicjacja zmiennej sk�adowej obiektu.
   private double salary;

   // Statyczny blok inicjuj�cy.
   static
   {
      Random generator = new Random();
      // Ustawienie zmiennej nextId na losow� liczb� ca�kowit� z przedzia�u 0 � 9999.
      nextId = generator.nextInt(10000);
   }

   // Blok inicjuj�cy obiekt�w.
   {
      id = nextId;
      nextId++;
   }

   // Trzy konstruktory przeci��one.
   public Employee(String n, double s)
   {
      name = n;
      salary = s;
   }

   public Employee(double s)
   {
      // Wywo�anie konstruktora Employee(String, double).
      this("Employee #" + nextId, s);
   }

   // Konstruktor domy�lny.
   public Employee()
   {
      // Zmienna name zainicjowana warto�ci� "" � patrz ni�ej.
      // Zmienna salary nie jest jawnie ustawiona � inicjacja warto�ci� 0.
      // Zmienna id jest inicjowana w bloku inicjuj�cym.
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