package inheritance;

class Manager extends Employee
{
   private double bonus;
   /**
    * @param n imi� i nazwisko pracownika
    * @param s pensja
    * @param year rok przyj�cia do pracy
    * @param month miesi�c przyj�cia do pracy
    * @param day dzie� przyj�cia do pracy
    */
   public Manager(String n, double s, int year, int month, int day)
   {
      super(n, s, year, month, day);
      bonus = 0;
   }

   public double getSalary()
   {
      double baseSalary = super.getSalary();
      return baseSalary + bonus;
   }

   public void setBonus(double b)
   {
      bonus = b;
   }
}