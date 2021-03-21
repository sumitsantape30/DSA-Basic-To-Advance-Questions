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

public class Pattern8 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		//pehle stars ka square print karenge and jo diagonal ki condition hai uss jagah pe stars print karenge
		for( int i=1; i<= n; i++) {
			for( int j=1 ; j<= n; j++) {
				
				if( i+j == n + 1) { //jaha yeh condition true hoti hai waha stars print karenge and baki jagah sirf spaces print karenge
					System.out.print("*\t");
				}else {
					System.out.print("\t"); 
				}
			}
			
			System.out.println();
		}
		
	}

}
