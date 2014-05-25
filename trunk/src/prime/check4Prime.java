package prime;

//Imports
import java.lang.*;

public class check4Prime {

	static final int max = 1000; //g�rna granica
	static final int min = 0;    //dolna granica
	static int input = 0;		 //domy�lna warto�� zmiennej wej�ciowej
	
	public static void main(String [] args){
	//inicjowanie obiektu g��wnego
		
check4Prime check = new check4Prime();
	
	try{
		//sprawd� poprawno�� argument�w i przypisz warto�� zmiennej wej�ciowej
		check.checkArgs(args);
		
		//sprawd� wyst�pienie wyj�tku i wypisz komunikat diagnostyczny 
	} catch(Exception e){
		System.out.println("Wywo�anie: check4Prime x");
		System.out.println("    ----gdzie 0 <= x <= 1000");
		System.exit(1);
	}
		
	//sprawd�, czy wczytana liczba jest liczb� pierwsz�
	if(check.primeCheck(input))
		System.out.println("Tak! " + input + " jest liczb� pierwsz�");
	else
		System.out.println("Nie! " + input + " nie jest liczb� pierwsz�");
		
	} //koniec funcji main
	
	
//generowanie liczb pierwszych
	public boolean primeCheck (int num){
		double sqroot = Math.sqrt(max); //pierwiastek kwadratowy
		
		//inicjowanie tablicy przechowuj�cej liczby pierwsze 
		boolean primeBucket [] = new boolean [max + 1];
		
		//nadanie wszystkim elementom pocz�tkowej warto�ci true, po czym 
		//zmiana na false warto�ci tych element�w, kt�re reprezentuj� liczby z�o�one
		for (int i=2; i<=max; i++){
			primeBucket[i]=true;
		}
		
		//wyeliminuj wszystkie liczby parzyste
		int j=2;
		for(int i=j+j; i<=max; i=i+j){
		//rozpocznij od 2*j,bo 2 jest liczb� pierwsz�
			primeBucket[i]=false; //wyeliminuj wielokrotno�ci	
		}
		
		for(j=3; j<=sqroot; j=j+2){
			//powtarzaj a� do pierwiastka
			//uwzgl�dnij liczby nieparzyste
			if(primeBucket[j]==true){
				//jesli liczba jest pierwsza
				for(int i=j+j; i<max; i=i+j){
					//wyeliminuj jej wielokrotno�ci
					primeBucket[i]=false;
				}
			}
		}
		
		
		//spawd�, czy testowana liczna wyst�puje w tablicy
		if(primeBucket[num]=true){
			return true;
		}else{
			return false;
		}	
			
			
			
		}//koniec primeCheck
		

	//weryfikacja poprawno�ci danych wej�ciowych
	public void checkArgs(String [] args) throws Exception{
		//sprawd� poprawno�� liczby argument�w
		if (args.length !=1){
			throw new Exception();
		}else{
			//przekszta�� jedyny parametr z postaci znakowej do postaci ca�kowitej
			Integer num = Integer.valueOf(args[0]);
			input = num.intValue();
			if (input<0)
				//je�li liczba jest ujemna
				throw new Exception();
				//je�li liczba przekracza doln� granic�
			else if (input>max) //je�li przekracza g�rn� granic�
				throw new Exception();
			}
	}//koniec checkArgs		
			
			
}//koniec check4Prime		


