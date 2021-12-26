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

//==================== Arraylist Concepts (question niche hai)================================================================
//==============Remember: getsetaddre get, set, add, remove

import java.io.*;
import java.util.*;
public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    ArrayList< Integer> al = new ArrayList< >(); //declares an integer arraylist
    Arraylist< String> a2 = new Arraylist < >(); //declares an arraylist of string
    System.out.println(a1.size());

    a1.add(10);
    a1.add(20);
    a1.add(30);
    a1.add(1, 1000); // adds 1000 at index 1

    System.out.print(a1);  //prints the entire list at one go

    for (int x : a1)
    {
      System.out.println(x); //each element belonging to a1 will get printed
    }

    int val = a1.get(1); //gets the value at index 1
    val = 10;

    for (int i = 0; i < a1.size(); i++)
    {
      System.out.println(a1.get(i));  //printing using get()
    }

    a1.set(1, 2000); //changes the value at index 1 to 2000;

    a1.remove(1) //removes the value at index 1

  }
}

//===================================================================================================================

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
			if( isPrime(val) == true) { //agar yeh prime hui to isko remove karna hai
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
