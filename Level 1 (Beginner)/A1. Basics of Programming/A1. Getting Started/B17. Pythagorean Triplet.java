Pythagorean Triplet

1. You are required to check if a given set of numbers is a valid pythagorean triplet.
2. Take as input three numbers a, b and c.
3. Print true if they can form a pythagorean triplet and false otherwise.

Input Format
a, an integer
b, an integer
c, an integer
Output Format
true if the numbers form a pythagorean triplet and false otherwise

Constraints
1 <= a <= 10^9
1 <= b <= 10^9
1 <= c <= 10^9

Sample Input
5 3 4
Sample Output
true

Code:

package GettingStarted;

import java.util.Scanner;

public class pythagoreanTriplet {
	
	public static void checkPythaThm( int a, int b, int c) {
		
		//hume sabse pehle hypotenuse kohi indentify karna hai, hypotenuse sabse badi wali side hoti hai
		
		//mai a ko sabse bda man lunga
		int max= a;
		
		if( b >= max) { //agar b hara de mere champ ko to mera champ b hojayega
			max= b; 
		}
		
		if( c >= max) {
			max= c;
		}
		
		if( max == a) {
			boolean result= ( (b*b + c*c) == a*a );
			System.out.println(result);
		}else if( max == b) {
			boolean result= ( (a*a + c*c) == b*b );
			System.out.println(result);
		}else if( max == c) {
			boolean result= ( (a*a + c*c) == c*c );
			System.out.println(result);
		}
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int a= s.nextInt();
		int b= s.nextInt();
		int c= s.nextInt();
		
		checkPythaThm(a,b,c);
	}

}

