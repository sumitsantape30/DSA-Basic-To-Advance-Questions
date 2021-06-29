package Restart;

import java.util.Scanner;

public class printZ {

	public static void rotate( int n, int k) {
		
		//1. find number of digits
		int num=0; //number of digits
		while( n != 0) {
			num++;
			n= n/10;
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

