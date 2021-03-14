Constraints
1 <= n <= 10
 Also, n is odd.
  
Sample Input
5

Sample Output
		*	
		*	*	
*	*	*	*	*	
		*	*
		*	
  
Code:

package Patterns;

import java.util.Scanner;

public class Pattern17 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int sp= n/2;
		int st= 1;
		
		for( int i= 1; i<= n; i++) {
			//1. pehle spaces hai
			for( int j=1; j<= sp; j++) {
				
				//3. jaha space print kar rhe hai waha check karenge ki kya hum middle row pe hai kya
				if( i == n/2 + 1) { // 5/2 2 hota hai islye 5/2+1 pe hai kya aisa check kar rhe
					// so agar hum 3rd row pe hai to hum space nhi print karenge space ki jagah star print karenge
					System.out.print("*\t");
				} else {
					System.out.print("\t");
				}
			}

			for( int j=1; j<= st; j++) {
				System.out.print("*\t");
			}
			
			//2. agar hum first half mai hai to stars badhenge aur second half mai hai to stars ghatenge
			if( i <= n/ 2) {
				st++;
			}else {
				st--;
			}
			
			System.out.println();
		}
	}

}

