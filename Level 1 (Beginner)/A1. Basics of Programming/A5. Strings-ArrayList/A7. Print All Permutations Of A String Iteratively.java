Print All Permutations Of A String Iteratively

1. You are given a string. 
2. You have to print all permutations of the given string iteratively.
Input Format
A String
Output Format
All permutations of the given string(one in a line).
 
Constraints
1 <= length of string <= 15
Sample Input
abc
Sample Output
abc
bac
cab
acb
bca
cba

Code:

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
class HelloWorld {
    
    public static String takeInput() {
		Scanner s= new Scanner(System.in);
		String str= s.next();
		return str;
	}
	
	public static void permutations( String str) {
		// sabse pehle n factorial ki value nikalenge
		int n= str.length();
		int nf= 1;
		for( int i=1; i<= n; i++) {
			nf = nf*i;
		}
		
		// ab 0 se nf tak loop chalanyenge
		for( int i=0; i< nf; i++) {
			
			StringBuilder sb= new StringBuilder(str); // mai harbar uss string ko string builder mai store kardeta hu
			
			//divisor ki value n se start aur dividend ki value i se start hoti hai aur loop tabtal chalega jantak div>0 hai
			for( int div =n , dvd =i; div > 0; div--) {
				// ab remainder nikalenge
				int r= dvd % div;
				// ab jo remainder aya uss index wale character ko print karke usko delete bhi kar denge
				System.out.print(sb.charAt(r));
				sb.deleteCharAt(r);
				
				dvd= dvd/ div;
			}
			// jaisehi ek permutation print hoti hai enter lagana hai for the next permutation
			System.out.println();
		}

	}
	
	public static void solution( String str) {
		
		int n= str.length();
		//sabse pehle muje factorial, jitna factorial hai utne permutations honga
		int f= fact(n);
		
		for( int i=0; i< f; i++) { // 0 se loop chalu hoga and f se ek chote tak chalega
			
			//permutations keliye hum orignal string se shuruwat krte hai so string builder mai original string ko pakal lijiye kyuki hume remove karna padega isliye string builder use kare
			StringBuilder sb= new StringBuilder(str);
		   //i hume divide karne mai use hoga so usko temp mai lelo taki bahar wale loop ko takleef na ho
		   int temp= i;
		   
			//ab humara divisor
			// humari diving harbar string ke length se start hogi
			for( int div= n; div >= 1; div--) {
				int q= temp / div; //quotient 
				int r= temp % div; //remainder 
				
				//ab remainder ke hisab se print hoga ki kya print hoga as jo remainder aya usi character ko print krte hai
				
				System.out.print(sb.charAt(r));
				//ab usko delete bhi kar denge coz woh ab original string mai rehna nhi chahiye
				sb.deleteCharAt(r);
				
				//so jo issbar ka quotient hota hai woh agli bar ka number hota hai so agli bar woh temp ban jayega jo issbar quotient aya tha
				temp= q;
			}
			System.out.println();
		}
	}
	
	public static int fact(int n) {
		int fact=1;
		
		for( int i=2; i<= n; i++) {
			fact= fact*i;
		}
		return fact;
	}

	public static void main(String[] args) {
     
       String str= takeInput();
       solution(str);
       
	}
}
