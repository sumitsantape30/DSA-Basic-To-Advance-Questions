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

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
       int n= scn.nextInt();
		
		int space=0;
		int st= n;
		
		for( int i=0; i<= n; i++) {
			
			for( int j=1; j<=space ; j++) {
				System.out.print("\t");
			}
			
			for( int j= 1; j<= st; j++) {
				System.out.print("*\t");
			}
			
			st--;
			space++;
			System.out.println();
		}
	}
}
