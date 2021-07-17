Remove Primes

1. You are given an ArrayList of positive integers.
2. You have to remove prime numbers from the given ArrayList and return the updated ArrayList.

Note -> The order of elements should remain same.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
An Arraylist

Constraints
1 <= N <= 10000
Sample Input
4
3 12 13 15
Sample Output
[12, 15]


code:

package Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class removePrimeFromArrayList {
	
	public static ArrayList<Integer> takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		ArrayList<Integer> a1= new ArrayList<Integer>();
		
		for( int i=0; i< n; i++) {
			a1.add(s.nextInt());
		}
		return a1;
	}
	
	public static ArrayList<Integer> removePrimes( ArrayList<Integer> a1){
		
		//pichese loop chalayenge
		for( int i= a1.size()-1; i>=0 ; i--) {
			//arraylist se value get karenge
			int val= a1.get(i);
			//ab check karenge kya yeh value prime hai ya nhi
			if( isPrime(val) == true) { //agar eyh prime hui to isko remove karna hai
				a1.remove(i); //ith index pe jo value hogi usko remove karenge
			}
		}
		return a1;
	}
	
	public static boolean isPrime( int val) {
		
		if( val == 0 || val == 1) {
			return false;
		}
		
		for( int div= 2; div*div <= val; div++) {
			if( val % div==0) {
				return false; //agar division hogya to prime nhi hai
			}
		}
		return true;// agar division hua hi nhi to prime hai
	}
	
	public static void main(String[] args) {

		ArrayList<Integer> a1= takeInput();
		ArrayList<Integer> result= removePrimes(a1);
		System.out.println(result);
		
	}

}
