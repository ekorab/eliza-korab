package prime; 
import junit.framework.*;

public class check4PrimeTest extends TestCase {

	//zainicjowanie klasy
	private check4Prime check4prime = new check4Prime();
	
	//konstruktor
	public check4PrimeTest (String name) {
		super(name);
		}

	//g³owny punkt wejœcia
	public static void main(String[] args){
		System.out.println("Pocz¹tek testu...");
		junit.textui.TestRunner.run(suite());
		System.out.println("Test zakoñczony.");
	}//koniec main()
	
	
	
	//przypadek testowy 1
	public void testCheckPrime_true(){
		assertTrue(check4prime.primeCheck(3));
	}
	
	
	
	//przypadek testowy 2 i 3
		public void testCheckPrime_false(){
			assertTrue(check4prime.primeCheck(0));
			assertTrue(check4prime.primeCheck(1000));
		}
		
		
	//przypadek testowy 7
		public void testCheckPrime_checkArgs_char_input(){
			try{
				String [] args = new String[1];
				args[0]="a";
				check4prime.checkArgs(args);
				fail("Powinien wyst¹piæ wyj¹tek.");
				} catch (Exception success){
					//test zaliczony
				}
		}//koniec testCheck4Prime_ckeckArgs_char_input()
		
		
	//przypadek testowy 5
		public void testCheckPrime_checkArgs_above_upper_bound(){
			try{
				String [] args = new String[1];
				args[0]="1001";
				check4prime.checkArgs(args);
				fail("Powinien wyst¹piæ wyj¹tek.");
				} catch (Exception success){
					//test zaliczony
				}
		}//koniec testCheckPrime_checkArgs_above_upper_bound()
		
	//przypadek testowy 4
		public void testCheckPrime_checkArgs_neg_input(){
				try{
					String [] args = new String[1];
					args[0]="-1";
					check4prime.checkArgs(args);
					fail("Powinien wyst¹piæ wyj¹tek.");
					} catch (Exception success){
						//test zaliczony
					}
		}//koniec testCheckPrime_checkArgs_neg_input()		
		
	//przypadek testowy 6
		public void testCheckPrime_checkArgs_2_inputs(){
				try{
					String [] args = new String[2];
					args[0]="5";
					args[0]="99";
					check4prime.checkArgs(args);
					fail("Powinien wyst¹piæ wyj¹tek.");
					} catch (Exception success){
						//test zaliczony
					}
		}//koniec testCheckPrime_checkArgs_2_inputs()	
		
		
	 //przypadek testowy 8
		public void testCheckPrime_checkArgs_0_inputs(){
				try{
					String [] args = new String[0];
					check4prime.checkArgs(args);
					fail("Powinien wyst¹piæ wyj¹tek.");
					} catch (Exception success){
						//test zaliczony
					}
		}//koniec testCheckPrime_checkArgs_0_inputs()	
		//metoda wymagan przez JUnit
		public static Test suite(){
			TestSuite suite =new
		TestSuite(check4PrimeTest.class);
			return suite;
		}
}
