Any Base To Any Base

1. You are given a number n.
2. You are given a base b1. n is a number on base b.
3. You are given another base b2.
4. You are required to convert the number n of base b1 to a number in base b2.
  
Input Format
A number n
A base b1
A base b2
Output Format
A number of base b2 equal in value to n of base b1.
  
Constraints
0 <= n <= 512
2 <= b1 <= 10
2 <= b2 <= 10
Sample Input
111001
2
3
Sample Output
2010
  
Code:

package GettingStarted;

import java.util.Scanner;

public class AnyBaseToAnyBase {
	
	
	public static int getValue( int n, int b1, int b2) {
		
		//pehle hum source base se decimal mai chale jayenge
		int dec= anybaseToDecimal(n, b1);
		
		//ab mere pas decimal hai ab muje iss decimal ko destination base mai jana hai
		// we'll use decimal to anybase for that
		int dn= decimalToanyBase(dec, b2); //destination number
		
		return dn;
		
	}
	
public static int decimalToanyBase( int n, int b) {
		
		int rv= 0; 
		int p= 1; 
		
		while( n > 0) {
			int dig= n % b;  
			n= n/b; 
			
			rv= rv+ dig*p; 
			p= p * 10;
		}
		
		return rv;

	}
	
	public static int anybaseToDecimal(int n, int b) {
		int rv= 0;
		int p=1;
		
		while( n >0 ) { 
			
			int dig= n % 10; 
			n= n /10;
						
			rv +=  dig* p;
			
			p= p * b;
			
		}
		return rv;
	}
	
	public static void main(String[] args) {
	      Scanner scn = new Scanner(System.in);
	      int n = scn.nextInt();
	      int sourceBase = scn.nextInt();
	      int  destBase= scn.nextInt();
	     
	     int ans= getValue(n, sourceBase, destBase);
	     System.out.println(ans);
	   }   
	  }

input:
172
8
2
Output:
1111010

