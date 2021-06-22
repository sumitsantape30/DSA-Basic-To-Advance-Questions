1. You've to check whether a given number is prime or not.
2. Take a number "t" as input representing count of input numbers to be tested.
3. Take a number "n" as input "t" number of times.
4. For each input value of n, print "prime" if the number is prime and "not prime" otherwise.
  
Input Format
A number t
A number n
A number n
.. t number of times

Output Format
prime
not prime
not prime
.. t number of times

Code:
package GettingStarted;

import java.util.Scanner;

public class printPrime {
	
	public static void checkPrime( int n) {
		
		//1 se leke n tak loop lagayenge and check karenge kitni bar divide hota hai
		int count=0;
		for( int divisor=1; divisor<= n; divisor++) { // B. iss loop mai har number keliye yeh jo n ki value hai utna chal rha hai aur n possibly 10^9 tak ja skta tha so iss loop number of operations 
			
			if( n % divisor == 0) { //c. yaha numberof operations possible 10^4 * 10^9 times hue hai. so humara total 10^13 mai program khaam hone wala nhi tha 
				count++; //jitni bar woh divide hoga mai count aage badhaunga
			}
		}
		
		// agar loop se bahar aane pr count mila 2 to woh mera prime number hai
		if( count == 2) {
			System.out.println("Prime");
		}else {
			System.out.println("No Prime");
		}
	}
	
	public static void checkPrime2( int n) {
		
	     int count=0;
		
		for( int div= 2;  div*div <= n; div++) { //yeh wala loop root n ke order wala hai means around 10^5 ke aspas so humari complexity is around 10^9
			
			if( n % div == 0) {
				count++;
				break; //jaisehi koi divide hua to break kar denge coz woh non prime hi hoga hume pura root n tak divide karne ki jarurat nhi hai pura loop chalake fayda nhi
			}
		}
		
		//agar count zero hai means 2 se leke root n tak kisine divide nhi kiya to prime hai
		if( count == 0) {
			System.out.println("Prime");
		}else {
			System.out.println("Not Prime");
		}
	}
	

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int t= s.nextInt(); //yey program muje kitne test case keliye run karna hai
		
		for( int i=0; i< t; i++) { // A.yaha t ki value 10^4 tak ho skti hai so yeh 10^4 times chalega 
			int n= s.nextInt(); //jitni bar test case run karwani hai utni bar n ka input lenge
			checkPrime(n);
		}
		
	}

}
