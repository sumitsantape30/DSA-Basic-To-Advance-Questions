Print All Primes Till N

1. You've to print all prime numbers between a range. 
2. Take as input "low", the lower limit of range.
3. Take as input "high", the higher limit of range.
4. For the range print all the primes numbers between low and high (both included).
Input Format
low 
high
Output Format
n1
n2
.. all primes between low and high (both included)
  
Constraints
2 <= low < high < 10 ^ 6
  
Sample Input
6 
24
Sample Output
7
11
13
17
19
23

Code:

package GettingStarted;

import java.util.Scanner;

public class PrintAllPrime {
	
	//low se leke high tak ke saare prime numbers hume print karne hai
	
	public static void checkPrime( int low, int high) {
		
		
		for( int n= low; n<= high; n++) {

		int count=0; //count yeh btata hai ki kitni bar divide hua agar ek bar bhi divide nhi hua to prime hai aur 1 or 1 se jada bar divide hogya to prime hai
		
		for( int div= 2; div*div <= n; div++) {
			// try to divide n and increase count
			if(n % div == 0) {
				count++;
				break;
			}
		}

			if (count == 0) {
				System.out.println(n);
			}

		}

	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int low= s.nextInt();
		int high= s.nextInt();
		
		checkPrime( low, high);
		
	}

}



