Inverse Of A Number

1. You are given a number following certain constraints.
2. The key constraint is if the number is 5 digits long, it'll contain all the digits from 1 to 5 without missing any and without repeating any. e.g. 23415 is a 5 digit long number containing all digits from 1 to 5 without missing and repeating any digit from 1 to 5.Take a look at few other valid numbers - 624135, 81456273 etc.Here are a few invalid numbers - 139, 7421357 etc.
3. The inverse of a number is defined as the number created by interchanging the face value and index of digits of number.e.g. for 426135 (reading from right to left, 5 is in place 1, 3 is in place 2, 1 is in place 3, 6 is in place 4, 2 is in place 5 and 4 is in place 6), the inverse will be 416253 (reading from right to left, 3 is in place 1, 5 is in place 2,2 is in place 3, 6 is in place 4, 1 is in place 5 and 4 is in place 6) More examples - inverse of 2134 is 1243 and inverse of 24153 is 24153    
4. Take as input number "n", assume that the number will follow constraints.
5. Print it's inverse.

Input Format
"n" where n is any integer, following constraints defined above.
Output Format
"i", the inverted number

Constraints
1 <= n < 10^8, and follwing other constraints defined above.

Sample Input
28346751
Sample Output
73425681

Code:

package GettingStarted;

import java.util.Scanner;

public class InverseANumber {
	
	public static void inverse( int n) {
		
		int inv =0; //muje banana hai iska inverse so abhi inverse 0 hai
		int op= 1; //original place will be 1
		while( n != 0) { //mai tabtak kam karunga jabtak mera number 0 nhi hojata
			int od= n % 10; //original digit. so hume ab first position pe original digit hume mil gyi
		    int id= op; //ab mera inverted digit hoga jo original positionn tha aur inverted place hoga orignal digit
		    int ip= od;
			
		    //id and ip se hum inverse mai kuch addition karenge
		    // make change to inverse using inverted digit and inverted position
		    inv=  inv + id * (int)Math.pow(10, ip-1);
		    
		    //number ko chota karna and original position badhana jarur yad rakhe
		    n= n/10;
		    op++; //original position ++ karenge, coz first position hogyi to agli bar agli position
		}
		System.out.println(inv);
	}
	
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		inverse(n);
	}
}
