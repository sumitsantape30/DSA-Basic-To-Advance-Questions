Any Base Multiplication

1. You are given a base b.
2. You are given two numbers n1 and n2 of base b.
3. You are required to multiply n1 and n2 and print the value.
Input Format
A base b
A number n1
A number n2
Output Format
A number of base b equal in value to n2 * n1.
  
Constraints
2 <= b <= 10
0 <= n1 <= 10000
0 <= n2 <= 10000
Sample Input
5
1220
31
Sample Output
43320
  
Code:

package FunctionsAndArrays;

import java.util.Scanner;

public class AnyBaseMultiplication {
	
	public static int getProduct(int b, int n1, int n2){

		int rv= 0;
		int p=1;
		
		while( n2 > 0) {
			int d2= n2 % 10;
			n2 = n2 /10;
			
			int sprd= getProductWithASingleDigit(b, n1, d2)  ; //single product
			rv= getSum(b , rv, sprd*p);
			p= p * 10;
		}
		
		return rv;
		
	 }
	
	// n2 single digit number hai yeh mano aur iska code likho
	public static int getProductWithASingleDigit( int b, int n1, int d2) { // yeh function single digit ke sath multiply karke answer nikalke de dega
		
		int rv=0;
		int c=0;
		int p= 1;
		
		while( n1 > 0 || c > 0) {
			int d1= n1 % 10;
			n1= n1/10;
			
			int d= d1 * d2 + c;
			
			c= d / b;
			d = d % b;
			
			rv= rv + d * p;
			p= p * 10;
		}
		
		
		
		return rv;
	}
	
	 public static int getSum(int b, int n1, int n2){

		 int rv=0;
		 int c= 0; 
		 int p=1; 
		 while( n1 > 0 || n2 > 0 || c > 0) {
			 
			 int d1= n1 % 10;
			 int d2= n2% 10; 
			 
			 n1= n1 /10;
			 n2= n2/10; 
			 
			 int d= d1+ d2 + c;
			 c = d/ b; 
			 d = d % b; 
			 rv += d* p;
			 p= p * 10; 
		 }
		 return rv;
		 
	 }

	public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    int b = scn.nextInt();
	    int n1 = scn.nextInt();
	    int n2 = scn.nextInt();

	    int d = getProduct(b, n1, n2);
	    System.out.println(d);
	 }
	}

Input:
5
1220
31
Output:
43320
