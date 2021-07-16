Print All Palindromic Substrings

1. You are given a string. 
2. You have to print all palindromic substrings of the given string.
Input Format
A String
Output Format
All palindromic substrings(one in a line).
First, all palindromic substrings starting from first character of string will be printed, then from second character and so on.
  
Constraints
1 <= length of string <= 500
Sample Input
abcc
Sample Output
a
b
c
cc
c

Code:

package Strings;

import java.util.Scanner;

public class printAllPalindromicString {
	
	public static String TakeInput() {
		
		Scanner s= new Scanner(System.in);
		String str= s.next();
		
		return str;
	}
	
	public static void printPalindromicStrings( String str) {
		
		for( int si=0; si< str.length(); si++) { // si 0 se length-1 tak chala tha
			for( int ei= si +1; ei<= str.length(); ei++) { // end index si se leke puri length ke end tak chalega
				String s= str.substring(si,ei); 
				//isme saari substring ajayegi but hume saari substrings nhi print karni hai bas wahi print karenge jo palindrome hai
			  //so ek function banayenge isPalindrome and usme yeh substring pass karenge agar woh palindrom hai to print karenge
				if( isPalindrome(s)== true) {
					System.out.println(s);
				}
			}
		}
	}
	
	// jaisa subarray ka code hai waisahi bas substring mai ei+1 karenge taki ei include hojaye
	public static void substring2(String str) {

		for (int si = 0; si < str.length(); si++) {

			for (int ei = si; ei < str.length(); ei++) {

				String s = str.substring(si, ei + 1);

				if (Ispalindrome(s) == true) {
					System.out.println(s);
				}
			}
		}
	}
	
	public static boolean isPalindrome( String str) {
		//do pointers lenge ek start pe rahega and ek end pe and dekho agar dono same hai to aage badh jayiye
		int left=0;
		int right= str.length()-1;
		
		while( left < right) {
			char ch1= str.charAt(left); // front se ek character nikalenge
			char ch2= str.charAt(right); //ek character back se nikalenge
			//agar dono barabr hai to koi bat nhi nhi i badhao and j ghatao barabr nhi hai to return false
			if( ch1 != ch2) {
				return false;
			}else {
				left++;
				right--;
			}
		}
		//agar sare characters equal hai tabhi yahape ayenge and then return true
		return true;
	}

	public static void main(String[] args) {

		String str= TakeInput();
		printPalindromicStrings(str);
	}
}
