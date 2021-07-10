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

public class Pattern2 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		for (int i =n ; i >= 1; i--) { //maine i n se start kara hai so andar wala loop pehli iteration mai n stars print karega
			for (int j = 1; j <= i; j++) { //andar wala loop utne stars print karta hai jitni i ki value hai
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

================================== Approach 2===================================
	
package Restart;

import java.util.Scanner;

public class Problems {
	
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		for( int i=1; i<= n; i++) {
			
			for( int j=1; j<= n-i-1; j++) {
				System.out.print("*\t");
			}
			System.out.println();
		}
	}
}

================================================= Approach 3 ============================================
	
package Restart;

import java.util.Scanner;

public class Problems {
	
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int st= n;
		
		for( int i=1; i<= n; i++) {
			
			for( int j= 1; j <= st; j++) {
				System.out.print("*\t");
			}
			
			st--;
			System.out.println();
			
		}
		
	}
}
