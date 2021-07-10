Constraints
1 <= n <= 10
 Also, n is odd.
  
Sample Input
7

Sample Output
*	*	*	*	*	*	*	
	*				*	
		*		*	
			*	
		*	*	*	
	*	*	*	*	*	
*	*	*	*	*	*	*	
  
Code:

package Patterns;

import java.util.Scanner;

public class pattern18 {

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		int n= s.nextInt();
		
		int sp=0;
		int st= n;
		
		for( int i=1; i<= n; i++) {
			
			//1.pehle bahar wale spaces
			for( int j=1; j<= sp; j++) {
				System.out.print("\t");
			}
			
			//2.bahar wale spaces ke bad stars
			for( int j= 1; j<= st; j++) {
				//3. ab upper half ka part vacant karenge
				//first row ko chhodke and n/2 se pehle ka part vacant karna hai
				// and sathme hi woh first half ke hone chahiye, first half ke first row se bada hoga and aakri star se chota hoga means st se chota hoga uss area mai hum space print karenge warna hum star print krte rahenge
				if( i > 1 && i <= n/2 && j >1 && j< st ) { //2nd row mai stars ke loop mai first position and last pe star print hoga so unko chhodna padega 		
					System.out.print("\t");
				} else {
					System.out.print("*\t");
				}
			}
			
			if( i <= n/2) {
				//3.pehle upper half mai stars ghatate hai do do se and spaces badhate hai ek ek se
				sp++;
				st -= 2;
			}else {
				sp --;
				st += 2;
			}
			System.out.println();
		}
	}

}

