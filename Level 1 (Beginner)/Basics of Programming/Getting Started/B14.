Rotate A Number

1. You are given two numbers n and k. You are required to rotate n, k times to the right. If k is positive, rotate to the right i.e. remove rightmost digit and make it leftmost. Do the reverse for negative value of k. Also k can have an absolute value larger than number of digits in n.
2. Take as input n and k.
3. Print the rotated number.
4. Note - Assume that the number of rotations will not cause leading 0's in the result. e.g. such an input will not be given
   n = 12340056
   k = 3
   r = 05612340
   
Input Format
"n" where n is any integer.
"K" where k is any integer.

Output Format
"r", the rotated number

Constraints
1 <= n < 10^9
-10^9 < k < 10^9

Sample Input
562984
2
Sample Output
845629

Code:

package GettingStarted;

import java.util.Scanner;

public class rotateANumber {
	
	public static void rotate( int n, int k) {
		
		// humara k decide karega ki humara divisor kya hoga
		
		//pehle hume number of digit ki jarurat padegi kyuki hume multiplier bhito chahiye, agar number mai 6 digits hai to divisor aur mutliplier milkar 6 zero rakhenge
		int temp= n;
		int nod= 0;
		while( temp != 0) {
			temp= temp/10;
			nod++;
		}
		//pehle sabse last wala point dekho then yaha aao
		k= k % nod;//so koi 253 bar rotate karne bolta hai to hum bolenge nhi actually mai 2 hi bar rotate karna hai
		// ab koi bolta hai ki -ve number se rotate karo means 3 ko piche bhejna 5618 ke but hum 5618 ko  aage la skte hai tabhi same hi result ayega so humari jo negative rotations hai that can be defined in terms of positive rotation koi bolta hai -2 that's actually +4
		// so -2 bola means aage se 2 bande piche bhejne hai  that's equivalent to puchese 3 bande aage laye usko positive rotation mai convert kiya ja skta hai
		// so -ve rotations ko +ve rotations mai convert kr skte hai, how? see below
		if( k < 0) { //agar k -ve hai to hum bolenge ki instead of -ve uski jagah kuch number of positive rotations kariye
			k = k + nod; // kisne bola -2 so -2 ki jagah hum +3 rotations kr denge
		}
		
		//initially divisor and multiplier 1 rakh rhe
		int div= 1;
		int mult = 1; 
		for( int i=1; i<= nod; i++) { //1 se leke n tak loop chala rhe
			// let's say 35618 ko 2 se rotate karna hai to divisor rahega 100 taki 18 mil paye, and multiplier rahega 1000 taki 18 ko isse multpy kar ske
			
			if( i <= k) { //jabtak i less than equal to hai k ke means jitne se rotate karna hai tabtak divisor mai 10 multiply krte rahiye
				div= div *10;
			}else{ //jab rotation se aage nikal jaye to multiplier se multiply kijiye
				mult = mult * 10; //humare multiplier baki number 0's bana lega
			}
		} //so iske bad humne jo example liye tha uske liye divisor ban jayega 100 and multiplier ban jayega 1000
		// ab hume chahiye quotient and remainder
		int q= n/ div;
		int r= n % div;
		
		// rotated number will be
		int rotated= r * mult + q; //remainder* mutliplier+ quotient
		 System.out.println(rotated);	
		 
		 //now special cases, agar humare example ko bola ki 5 se rotate kardo to wahi ayega, fir bole ki 6 se rotate krdo means 1 sehi rotate karo yah bole ki 11 se rotate karo means wahi hai
		 // agar hume koi bolta ki 352 se rotate krdo to hume bas 2 bar rotate krna hai, means har 5vi rotation se wahi banta rahega. 
		 // 350 th rotation se wahi milega uske bad ki 2 rotation ki count hogi so actually hume modulus lena hoga sabse pehle so yeh code no of digits ane ke bad karenge.
	}
	

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt(); // yeh woh number hai jisko rotate karna hai
		int k= s.nextInt(); //hume number ko itne se rotate karna hai
		rotate(n, k);
	}

}
