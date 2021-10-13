Constraints
1 <= n <= 100
 Also, n is odd.
  
Sample Input
5
Sample Output
		*	
	*		*	
*				*	
	*		*	
		*	

  Code:

package Patterns;

import java.util.Scanner;

public class Pattern10 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int os= n/2; //jab n=7 wala pattern dekhe the usme outer space 7 keliye 3 the so n/2;
		int is= -1; //inner space -1 lenge initially
		
		for( int i=1; i<= n; i++) {
			//System.out.print(os+" "+is);
			
			//outer space print karenge
			for( int j=1; j<= os; j++) {
				System.out.print("\t");
			}
			
			// outer space ke bad ab ek star ayega
			System.out.print("*\t");
			
			//ab inner spaces ayenge
			for( int j=1; j<= is; j++) {
				System.out.print("\t");
			}
			
			// inner space ke bad firse jo star tha woh har row mai nhi tha, yeh pehli and last row mai nhi hai baki bichke rows mai do stars hai
			if( i >1 && i < n) { //agar mera i 1 se bda hai and i n se chota hai means woh first and last row nhi hai tabhi iss star ko print karenge
				System.out.print("*\t");
			}
			
			//iske bad addhe tak kuch means n/2 tak kuch aur ho rha hai aur uske bad kuch ho rha hai
			if(i <= n/2) { //addhe tak outer spaces badh rhe hai aur inner space 2 2 se badh rhe hai
				os--;
				is += 2;
			}else { //aadhe ke bad outer space kam hojate hai and inner space 2 se ghatate hai
				os ++;
				is -= 2;
			}
			
			System.out.println();
			
		}
		
	}

}
