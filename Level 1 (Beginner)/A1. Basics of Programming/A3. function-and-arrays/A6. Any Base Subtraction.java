Any Base Subtraction

1. You are given a base b.
2. You are given two numbers n1 and n2 of base b.
3. You are required to subtract n1 from n2 and print the value.
Input Format
A base b
A number n1
A number n2
Output Format
A number of base b equal in value to n2 - n1.
  
Constraints
2 <= b <= 10
0 <= n1 <= 256
n1 <= n2 <= 256
Sample Input
8
1
100
Sample Output
77

Code:

package FunctionsAndArrays;

import java.util.Scanner;

public class AnyBaseSubstraction {
	
	public static int getDifference(int b, int n1, int n2) {

		int ans= 0;
		int carry= 0;
		int power=1;
		
		//humara kam tabtak chalega jatbak bada number bacha hua hai
		while( n2 > 0) {
			
			// dono mese last digit nikalenge
			int l1= n1 % 10;
			int l2= n2 % 10;
			// n1 and n2 ko chota kardenge
			n1= n1/10;
			n2= n2/10;
			
			//ab hum digit d banana chahte hai so d ko 0 assign karenge
			int d= 0;  
			//aur d2 digit ke andar carry add karlenge
			d2= d2 + c;
			
			//ab hum dekhenge kya d2 mai dum hai d1 ko manage karneka
			if( d2 >= d1){ // agar iss waqt d2 greater or equal hai d1 ke to hume carry ki jarurat nhi hai so carry hoga 0
			   c= 0;
			   // d digit hojayegi d2-d1
			   d= d2- d1;
			}else {
			   // agar d2 chota pd gya to carry hojayega 1 actually yeh carry borrow hai to muje -1 ka carry dena padega kyuki hum carry ko add kr rhe hai
			   c = -1;
			   d = d2 + b - d1;
			}
			
			//ab rv ke andar add karenge d* power, power ka kam hai unko dhang se allign karna 
			ans= ans + d*power;
			p= p* 10;
		}
		
		return rv;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int b = scn.nextInt();
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();

		int d = getDifference(b, n1, n2);
		System.out.println(d);
	}

}

Input:
8
256
1212
Output:
734
