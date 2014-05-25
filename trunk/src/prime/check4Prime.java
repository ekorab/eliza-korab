package prime;

//Imports
import java.lang.*;

public class check4Prime {

	static final int max = 1000; //górna granica
	static final int min = 0;    //dolna granica
	static int input = 0;		 //domyœlna wartoœæ zmiennej wejœciowej
	
	public static void main(String [] args){
	//inicjowanie obiektu g³ównego
		
check4Prime check = new check4Prime();
	
	try{
		//sprawdŸ poprawnoœæ argumentów i przypisz wartoœæ zmiennej wejœciowej
		check.checkArgs(args);
		
		//sprawdŸ wyst¹pienie wyj¹tku i wypisz komunikat diagnostyczny 
	} catch(Exception e){
		System.out.println("Wywo³anie: check4Prime x");
		System.out.println("    ----gdzie 0 <= x <= 1000");
		System.exit(1);
	}
		
	//sprawdŸ, czy wczytana liczba jest liczb¹ pierwsz¹
	if(check.primeCheck(input))
		System.out.println("Tak! " + input + " jest liczb¹ pierwsz¹");
	else
		System.out.println("Nie! " + input + " nie jest liczb¹ pierwsz¹");
		
	} //koniec funcji main
	
	
//generowanie liczb pierwszych
	public boolean primeCheck (int num){
		double sqroot = Math.sqrt(max); //pierwiastek kwadratowy
		
		//inicjowanie tablicy przechowuj¹cej liczby pierwsze 
		boolean primeBucket [] = new boolean [max + 1];
		
		//nadanie wszystkim elementom pocz¹tkowej wartoœci true, po czym 
		//zmiana na false wartoœci tych elementów, które reprezentuj¹ liczby z³o¿one
		for (int i=2; i<=max; i++){
			primeBucket[i]=true;
		}
		
		//wyeliminuj wszystkie liczby parzyste
		int j=2;
		for(int i=j+j; i<=max; i=i+j){
		//rozpocznij od 2*j,bo 2 jest liczb¹ pierwsz¹
			primeBucket[i]=false; //wyeliminuj wielokrotnoœci	
		}
		
		for(j=3; j<=sqroot; j=j+2){
			//powtarzaj a¿ do pierwiastka
			//uwzglêdnij liczby nieparzyste
			if(primeBucket[j]==true){
				//jesli liczba jest pierwsza
				for(int i=j+j; i<max; i=i+j){
					//wyeliminuj jej wielokrotnoœci
					primeBucket[i]=false;
				}
			}
		}
		
		
		//spawdŸ, czy testowana liczna wystêpuje w tablicy
		if(primeBucket[num]=true){
			return true;
		}else{
			return false;
		}	
			
			
			
		}//koniec primeCheck
		

	//weryfikacja poprawnoœci danych wejœciowych
	public void checkArgs(String [] args) throws Exception{
		//sprawdŸ poprawnoœæ liczby argumentów
		if (args.length !=1){
			throw new Exception();
		}else{
			//przekszta³æ jedyny parametr z postaci znakowej do postaci ca³kowitej
			Integer num = Integer.valueOf(args[0]);
			input = num.intValue();
			if (input<0)
				//jeœli liczba jest ujemna
				throw new Exception();
				//jeœli liczba przekracza doln¹ granicê
			else if (input>max) //jeœli przekracza górn¹ granicê
				throw new Exception();
			}
	}//koniec checkArgs		
			
			
}//koniec check4Prime		


