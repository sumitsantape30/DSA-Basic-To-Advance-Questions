Gcd And Lcm

1. You are required to print the Greatest Common Divisor (GCD) of two numbers.
2. You are also required to print the Lowest Common Multiple (LCM) of the same numbers.
3. Take input "num1" and "num2" as the two numbers.
4. Print their GCD and LCM.
Input Format
num1
num2
.. the numbers whose GCD and LCM we have to find.
Output Format
a
b
.. where 'a' and 'b' are the GCD and LCM respectively.
Question Video

Constraints
2 <= n <= 10^9

Sample Input
36
24
Sample Output
12
72

Code:

package GettingStarted;

import java.util.Scanner;

public class GCDAndLCM {
	
	public static void gcdandlcm(int n1, int n2) {
		// you'll think ki isme se pehle chota number dhundlu coz hum divide karna chote number se start karenge but usse faraq nhi pdta
		
		//LCM keliye original values preserve kr rhe hai
		int on1= n1;
		int on2= n2;
		
		int div= n1;
		int dvd= n2;
		
		while( div % dvd != 0) { //jabtak remainder 0 nhi ata tabtak hum un dono number pe kam krte rahenge
			
			//yad karo: ek divisor tha ek dividend tha, divisor ne divide kiya to remainder aya agli division keliye yeh remainder divisor ban jayega aur purana divisor dividend ban jayega *book dekho*
			int rem= dvd % div;
			dvd = div;
			div= rem;
		}
		
		//so jis number ne remainder 0 laya woh GCD hota hai means n2 nehi khud divide krke remainder 0 laya tabhi hum loop ke bahar aaye
		int gcd = div;	//gcd wahi hai jis divisor ke wajah se aakhri remainder 0 aya
		//lcm keliye property hai, gcd*lcm= n1*n2
		int lcm= (on1*on2)/gcd; //but yaha n1 and n2 woh number rhe hi nhi jo initially the kyuki woh GCD calculate krte krte chote hogye hai isliye do variables rakhenge jisme original value preserve krke rakhle
		
		System.out.println(gcd);
		System.out.println(lcm);
		
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n1 = s.nextInt();
		int n2= s.nextInt();
		gcdandlcm( n1, n2);
	}

}

Analysis:
	
Time Complexity:
O(min(a, b))
Since we have just one loop from min(a, b) to 1.

Space Complexity:
O(1)
Since no auxiliary space was needed.
This is not a very good optimized approach hence we are avoiding the code for this.
The code is explained in the youtube solution video.


