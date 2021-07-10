Pattern 1
  
Constraints
1 <= n <= 100
  
Sample Input
2
Sample Output
*	
*	*

Code:

package Patterns;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		for( int i=1; i<= n; i++) {
			for( int j= 1; j<= i; j++) { //yeh jitni i ki value hai utne starts print karega
				System.out.print("*\t"); // \t se tab lag jayega taaki stars thode dur dur aaye humare
			}
			System.out.println();
		}
	}

}

==============================Approach 2 =============================================
package Restart;

import java.util.Scanner;

public class Problems {
	
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int st=1;
		
		
		for( int i=1; i<= n; i++) {
			for( int j=1; j<= st; j++) {
				System.out.print("*");
			}
			st++;
			System.out.println();
		}
	}
}
