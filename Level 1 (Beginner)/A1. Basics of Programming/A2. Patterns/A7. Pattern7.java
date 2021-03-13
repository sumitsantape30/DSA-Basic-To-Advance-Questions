Constraints
1 <= n <= 100
  
Sample Input
5
Sample Output
*	
	*	
		*	
			*	
				*	
  
 Code:

package Patterns;

import java.util.Scanner;

public class Pattern7 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		for( int i=1; i<= n; i++) {
			for( int j= 1; j<=n; j++) {
				
				if( i == j) { //agar i and j equal hai to space print karenge
					System.out.print("*\t");
				}else { //agar equal nhi hai to bas spaces print karenge
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}

}


