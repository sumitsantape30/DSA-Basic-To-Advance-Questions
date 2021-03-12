Constraints
1 <= n <= 100
  
Sample Input
5

Sample Output
*	*	*	*	*	
	*	*	*	*	
		*	*	*	
			*	*	
				*
        
 Code:
package Patterns;

import java.util.Scanner;

public class Pattern4 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int space=0;
		int st= n;
		
		for( int i=0; i<= n; i++) {
			
			for( int j=0; j<=space ; j++) {
				System.out.print("\t");
			}
			
			for( int j= 0; j<= st; j++) {
				System.out.print("*\t");
			}
			
			st--;
			space++;
			System.out.println();
		}
	}
}
