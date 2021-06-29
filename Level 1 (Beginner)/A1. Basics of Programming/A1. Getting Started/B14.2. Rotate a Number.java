package Restart;

import java.util.Scanner;

public class printZ {

	public static void rotate( int n, int k) {
		
		int num=0; //number of digits
		while( n != 0) {
			num++;
			n= n/10;
		}
		
		k= k % num;
		if( k < 0) {
			k += num;
		}
		
		//ab divisor aur multiplier ki value set karenge
		int div=(int) Math.pow(10, k);
		int mult= (int) Math.pow(10, num-k);
		
		//fir quotient aur remainder nikalo
		
		int q= n /div;
		int r= n % div;
		
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

