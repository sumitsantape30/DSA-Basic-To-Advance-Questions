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

		int ans= 0;
		int power=1; // pehli bar jo answer ayega woh 10^0 se multiply hoga, dusri bar jo answer ayega woh 10^1 se multiply hoga isliye power chahiye
		
		while( n2 > 0) {
			int l2= n2 % 10; //jabtak n2 zero nhi hojata uska aakhri digit nikalte rahenge aur usko reduce bhi karte rahenge
			n2 = n2 /10;
			
			int gpwsd= getProductWithASingleDigit(b, n1, l2)  ; //single product, get product with single digit
			ans = getSum(b , ans, gpwsd*p);
			power = power * 10;
		}
		
		return ans;
		
	 }
	
	// n2 single digit number hai yeh mano aur iska code likho
	public static int getProductWithASingleDigit( int b, int n1, int n2) { // yeh function single digit ke sath multiply karke answer nikalke de dega
		
		int ans=0;
		int carry=0;
		int power= 1;
		
		while( n1 > 0 || c > 0) {
			int l1= n1 % 10; //last digit of n1 aur fir n1 ko reduce bhi kar denge
			n1= n1/10;
			
			int product = l1 * n2 + carry;
			
			q= product / b; // quotient
			rem = product % b; //ramainder
			
			//remainder ki help se answer update
			ans= ans + (rem * p);
			
			//agli bar keliye carry update with the help of quotient
			carry= q;
			power= power * 10;
		}
		
		return ans;
	}
	
	 public static int getSum(int b, int n1, int n2){

		 int ans=0;
		 int carry= 0; 
		 int power=1; 
		 
		 while( n1 > 0 || n2 > 0 || c > 0) {
			 
			 int l1= n1 % 10;
			 int l2= n2% 10; 
			 
			 // dono ko reduce kardo
			 n1= n1 /10;
			 n2= n2/10; 
			 
			 int sum = l1+ l2 + c;
			 int q = sum/ b; 
			 int r = sum % b; 
			 ans += (r* power);
			 // aur quotient ki help se agli bar keliye carry update karenge
			 carry= q;
			 power = power * 10; 
		 }
		 return ans;
		 
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
