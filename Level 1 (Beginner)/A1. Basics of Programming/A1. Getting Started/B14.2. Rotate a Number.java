package Restart;

import java.util.Scanner;

public class printZ {

	public static void rotate( int n, int k) {
		
		//1. find number of digits
		int temp= n;
		int num=0; //number of digits
		while( trmp != 0) {
			num++;
			temp = temp/10;
		}
		
		//2. bring value of k in range
		k= k % num;
		if( k < 0) {
			k += num;
		}
		
		//3. set value of divisor and  multiplier
		//ab divisor aur multiplier ki value set karenge
		int div=(int) Math.pow(10, k);
		int mult= (int) Math.pow(10, num-k);
		
		//4. find quotient and remainder
		//fir quotient aur remainder nikalo
		int q= n /div;
		int r= n % div;
		 
		//5. update ans and print it
		int inv= (r*mult) + q;
		System.out.println(inv);
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k= s.nextInt();
		rotate(n, k);
	}
}

Time Complexity:
Getting the number of digits in n will take O(log10 n) time.
Finding 10k and 10(nod - k) will take O(k) and O(nod - k) time respectively since k is of the order of the number of digits (after taking mod with nod), its time complexity will also be O(log10 n).
Finding q and r are constant time-taking operations. Hence, the overall time complexity will be O(number of digits) = O(log10 n).

Space Complexity:
We are just using integer variables nod, multiplier, divisor, r, q, which will take constant {O(1)} space.
