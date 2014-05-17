package calculations;

public class multiplication {
	
		private int a,b;
		public multiplication(int pierwsza, int druga){//konstruktor
		a = pierwsza;
		b = druga;
		}
		public int mnozenie(){
		int c = a * b;
		return c;
		}
		public int division(){
		if(b==0){return 0;}
		int c = a / b;
		return c;
		}
		}


