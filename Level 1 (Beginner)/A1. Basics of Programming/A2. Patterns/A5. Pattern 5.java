Constraints
1 <= n <= 100
 Also, n is odd.
  
Sample Input
5
Sample Output
		*	
	*	*	*	
*	*	*	*	*	
	*	*	*	
		*	
  
Code:

package Patterns;

import java.util.Scanner;

public class Pattern5 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt(); //hume input humesha odd milega
		
		int sp= n/2; //starting mai spaces n/2 hai, 5 line keliye 2 space ek star
		int st= 1;
		
		for( int i=1; i<= n; i++) {
			
			for( int j=1; j<= sp; j++) {
				System.out.print("\t");
			}
			
			for( int j=1; j<= st; j++) {
				System.out.print("*\t");
			}
			
			if( i <= n/2) {
				sp--;
				st += 2; // pehle row mai 1 star that dusre row mai 2 star hai isliye +2 kiye
			}else {
				sp++;
				st -= 2; //  n/2 ke bad wale mai starts kam ho rhe by 2
			}
			System.out.println();
		}
	}

}
