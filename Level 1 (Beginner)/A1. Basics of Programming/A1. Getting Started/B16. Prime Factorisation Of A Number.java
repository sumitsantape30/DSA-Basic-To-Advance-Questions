Prime Factorisation Of A Number

    1. You are required to display the prime factorization of a number.
    2. Take as input a number n.
    3. Print all its prime factors from smallest to largest.
                               
Input Format
n, an integer
Output Format
p1  p2  p3  p4.. all prime factors of n

Constraints
2 <= n < 10 ^ 9

Sample Input
1440
Sample Output
2 2 2 2 2 3 3 5

Code:

package GettingStarted;

import java.util.Scanner;

public class primeFactorizationOfANumber {
	
	public static void printPrimeFactorization(int n) {
		
		//mai pehla divisor 2 choose karra aur jabtak div root n ke barabar na hojaye tabtak kam karenge
		for( int div= 2; div*div <= n; div++) { // n keliye uske sare prime factors root n se niche niche lie karenge except 1, root n se bda prime factor bas 1 hai
			//so kisi bhi number n keliye, root n se bade prime factor 2 nhi ho skte ek hi ho skta hai. n ke prime factors root n se bade 2 nhi ho skte hoga to ek hi hoga
			
			//jabtak yeh n divide hota rehta hai tabtak divide krte rho means katate rho aur har ek bar apne divisor ko print krte rho
			while( n % div == 0) {
				n= n/ 10;
				System.out.print(div+" ");
			}
		}
		
		//isme ek case chhut jata hai kabhi kabhi jaise 46 ki bat kare, 46 is 2*23, 2 se 46 ko divide kiye 23 bach gya ab 23 tak ki table chalani jarurat nhi hai hum quit kardenge lekin jab bahar ayenge n cut karke 1 nhi bana hai
		//so agar apke n 1 nhi bana hai means n 1 se bda bach gya hai to yeh only number hai jo root n ke bad ata hai jo n ko divide kr skta hai *open book and see example of number 46*
	   if( n != 1) {
		   //agar kat kar 1 nhi kar paye to jo number bacha hua tha jaise 23 bacha tha woh khudme ek prime factor hai to usko print kardenge
		   // this is a prime factor having value grater than root n and there can be only 1 such factor aur woh number khud hi ho skta hai so usko print krdwado
		   System.out.println(n);
	   }
	}
	
	//point to remeber: root n se aage loop na chalaye sirf root n tak divide kare, root n ke beyond agar root katke 1 nhi hua to jo number bacha hai woh last prime factor bacha hai jo root n ke beyond hai usko print kardenge.

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		printPrimeFactorization(n);
	}

}
