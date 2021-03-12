Pattern 3

Constraints
1 <= n <= 10
  
Sample Input
5
Sample Output
				*	
			*	*	
		*	*	*	
	*	*	*	*	
*	*	*	*	*	
  
Code:

package Patterns;

import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		//space and star ka variable banyenge
		int space= n-1; // pehle row mai n-1 spaces rahenge and ek star rahega
		int st= 1;
		
		for( int i=1; i<=n; i++) {
			
			for( int j=1; j<= space; j++) { //jitni space variable ki value hogi yeh loop utni bar chalega  
				System.out.print("\t");
				
			}
			
			for(int j= 1; j <= st; j++) { //jitni value star ki hogi yeh loop utni bar chalega and utne * print krta hai
				System.out.print("*\t"); //pehli row mai star ki value 1 hai to yeh ek * print karega
			}
			
			//so actually mai humne space and st ko print nhi kiya maine utne loop chalaye
			
			space--;
			st++; 
			System.out.println();
		}
	}

}

 
