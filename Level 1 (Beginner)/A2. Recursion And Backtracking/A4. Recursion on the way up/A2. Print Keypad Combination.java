Print Kpc

1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
2. The following list is the key to characters map
    0 -> .;
   1 -> abc
   2 -> def
   3 -> ghi
   4 -> jkl
   5 -> mno
   6 -> pqrs
   7 -> tu
   8 -> vwx
   9 -> yz
3. Complete the body of printKPC function - without changing signature - to print the list of all words that could be produced by the keys in str.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.     
                               
Input Format
A string str
Output Format
Words that can be produced by pressed keys indictated by str in order hinted by Sample output

Constraints
0 <= str.length <= 10
str contains numbers only
Sample Input
78
Sample Output
tv
tw
tx
uv
uw
ux

Code:

package Recursion;

import java.util.Scanner;

public class printKPC {
	
	public static void printKPC(String ques, String ans) {
		if( ques.length()== 0) { // jab question khatam hojaye to ans print kardenge and then return
			System.out.println(ans);
			return;
		}
		
		//suppose 678 hai to pehle 6 nikalna hai
		char ch= ques.charAt(0);
		// ab muje 78 ko alag karna hai
		String roq= ques.substring(1); // res of the string
		
		// now this 6 can be solved as pqrs so woh layenge pehle
		String codeforch= codes[ch- '0'];
		// ab pqrs mai ek ek call lagani hai, means yeh 6 p ke form mai solve hoga ya q ke or r ya s ke
		for( int i=0 ; i< codeforch.length(); i++) {
			char cho= codeforch.charAt(i); // character option
			// upar rest of the question roq hi pass hoga and answer mai yeh add hoga, kabhi mai p add karunga kabhi q or r ya s
			printKPC( roq, ans+ cho);
		}
		
	}
	
	//codes keliye global variable bana lenge
	static  String codes[]= {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
	
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		String str= s.next();
		printKPC(str, "");
	}

}
