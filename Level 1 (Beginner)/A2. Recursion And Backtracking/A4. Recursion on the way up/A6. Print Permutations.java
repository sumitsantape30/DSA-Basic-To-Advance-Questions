Print Permutations
1. You are given a string str.
2. Complete the body of printPermutations function - without changing signature - to calculate and print all permutations of str.
Use sample input and output to take idea about permutations.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A string str
Output Format
Permutations of str in order hinted by Sample output

Constraints
0 <= str.length <= 7
Sample Input
abc
Sample Output
abc
acb
bac
bca
cab
cba

Code:


package Recursion;

import java.util.Scanner;

public class PrintPermutations {
	
	 public static void printPermutations(String ques, String asf) {
		 if( ques.length()== 0) { // question khatam hogya hai to answer so far ko print kar denge aur return kar denge
			 System.out.println(asf);
			 return;
		 }
	        
		 //kisi bhi character ko hum choose kr skte hai
		 // jitna question ka size hai utni hi mere pas choices hai 
		 for( int i=0; i< ques.length(); i++) {
	
			 char ch= ques.charAt(i);// so ek bar ek character nikal liya
			 // ab muje rest of the string btani hai
			 // so question ka left part
			 String qlpart= ques.substring(0,i); // qlpart= question left part
			 String qrpart= ques.substring(i+1);   //question right part
			 
			 //so ab rest of the question ban jayega
			 String roq= qlpart + qrpart;
			 
			 // ab apni call laga skte hai
			 printPermutations(roq, asf + ch); // answer so far mai jo character humne choose kiya hai woh jodkar call laga denge 
		 } 
	 }
	
	public static void printPermutation(String str, String asf) {
		if( str.length() == 0) {
			System.out.println(asf);
			return;
		}
		
		for( int i=0; i< str.length(); i++) { 
			
			char ch= str.charAt(i);
			String ros= str.substring(0, i) + str.substring(i +1);
			printPermutation(ros, asf + ch);
			
		}
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		String str= s.next();
		printPermutations(str, "");	
	}
}
