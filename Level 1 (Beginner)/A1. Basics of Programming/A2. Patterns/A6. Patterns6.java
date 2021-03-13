Constraints
1 <= n <= 100
 Also, n is odd.
  
Sample Input
5
Sample Output
*	*	*		*	*	*	
*	*				*	*	
*						*	
*	*				*	*	
*	*	*		*	*	*	

Code:
package Patterns;

import java.util.Scanner;

public class Pattern6 {
	

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int st= n/2 + 1; //humare stars ab n/2+1 hai
		int sp= 1; //and spaces 1 hai initially 
		
		for( int i=1; i<=n; i++) {
			//System.out.println(st+" "+sp+" "+st);
			
			//pehle stars print karenge
			for( int j= 1; j<= st; j++) {
				System.out.print("*\t");
			}
			
			//bich me spaces rahenge
			for( int j= 1; j<= sp ; j++) {
				System.out.print("\t");
			}
			
			//last mai firse stars rahenge
			for( int j= 1; j<= st; j++) {
				System.out.print("*\t");
			}
			
			if( i <= n/2) { //i <= n/2 tak stars ek ek se kam hote rhe hai and spaces 2 2 se badh rhe hai
				st--; 
				sp +=2;
			}else { // n/2 ke bad stars ek se badhne lage and spaces do se ghatne lage
				st++;
				sp -= 2;
			}
			
			System.out.println();
		}
	}
}
