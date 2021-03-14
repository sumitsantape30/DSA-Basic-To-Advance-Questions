Pattern 20
  
Constraints
1 <= n <= 10
 Also, n is odd.
  
Sample Input
5
Sample Output
*				*	
*				*	
*		*		*	
*	*		*	*	
*				*	
  
Code:

package Patterns;

import java.util.Scanner;

public class Pattern20 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		for( int i=1; i<=n; i++) {
			for( int j=1; j<= n; j++) {
				
				//yato pehla column ho ya aakhri column ho, tab humesha star hoga
				if( j == 1 || j ==n ) {
					System.out.print("*\t");
				}else if( i > n/2 && ( i == j || i + j == n +1)) { //agar first aur last column nhi hai to diagonals wala case, diagols hume sirf second half mai chahiye and dono mese diagonal hona chahiye
					//so maine iss condition mai aisa bola stars waha honge jaha second half hoga aur dono diagonal mses ek hoga either of the two diagonals
					System.out.print("*\t");
				}else { //agar dono conditions nhi hoti hai to hum print karenge space
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}

}
