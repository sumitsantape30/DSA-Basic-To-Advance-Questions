Constraints
1 <= n <= 100
 Also, n is odd.
  
Sample Input
5
Sample Output
*				*	
	*		*		
		*			
	*		*		
*				*	
  
Code:
package Patterns;

import java.util.Scanner;

public class Pattern9 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		for( int i=1; i<=n; i++) {
			for( int j=1; j<= n; j++) {
				
				if( i==j || i+j == n+1) { //yeh condition true hui tabhi star print karenge nhito space print karenge
					System.out.print("*\t");
				}else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}

}
