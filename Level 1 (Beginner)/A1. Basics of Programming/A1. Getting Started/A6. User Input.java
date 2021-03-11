package GettingStarted;

import java.util.Scanner;

public class TakeInput {

	public static void main(String[] args) {

		//int n= 10; //yeh ek n variable hai integer type ka aur yeh ek number contain krta hai
		Scanner s= new Scanner(System.in); //yaha s variable hai Scanner type ka jisse input uthaya jata hai means woh keyboard se juda hua hai
		int n= s.nextInt(); //yeh likhne ka matlab hai ki keyboard se likh kar jo number enter marunga woh n mai pohoch jayega
//		for( int i=0;i<= n; i++) {
//			System.out.println(i);
//		}
		
		//for string input
		String name= s.nextLine(); //puri line uthakr name mai dal dega scannner
		System.out.println("Name: "+name);
    
//=======================================================================================================
		// to take the input of both integer and string in a single program
		// let's say user ne humko diya ek number aur ek nam
		
		Scanner s= new Scanner(System.in);
		int n= Integer.parseInt(s.nextLine()); //string and integer ka input lena hai to s.nextLine() hi use karenge but use integer mai convert karne keliye use pareseInt
		String name= s.nextLine();
		
		System.out.println("Dear "+name+" here is the counting");
		for( int i=0;i<n; i++) {
			System.out.println(n);
		}
	}
}

Output:
5
sumit
Dear sumit here is the counting
5
5
5
5
5

