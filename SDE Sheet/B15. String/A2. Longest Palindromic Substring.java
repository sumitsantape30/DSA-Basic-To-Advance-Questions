Given a string s, return the longest 
palindromic
 
substring
 in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 
Code:

package Codes;

import java.util.*;
import java.io.*;

public class code {
	

	private static int lo, maxLen; //lo is the starting point of longest palindromic substring

	public static String longestPalindrome(String s) {
		int len = s.length(); 
		
		if (len < 2)return s; //agar length less than 1 hai means ek character hai to woh khud palindromic hai
		
	    for (int i = 0; i < len-1; i++) {
	     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, i, i+1); //assume even length.
	    }
	    
	    return s.substring(lo, lo + maxLen);
	}
	
	//notes wala
	public static String longestPalindrome1(String s) {
		int len = s.length(); 
		
		if (len < 2)return s; //agar length less than 1 hai means ek character hai to woh khud palindromic hai
		
	    for (int i = 1; i < len-1; i++) {
	     	extendPalindrome(s, i+1, i-1);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, i, i+1); //assume even length.
	    }
	    
	    return s.substring(lo, lo + maxLen);
	}

	private static void extendPalindrome(String s, int j, int k) { //yeh jth to kth index substring aayi hai, yeh palindromic hai ki nhi yeh check karenge
		
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) { //jth and kth index wae character same hai ki nhi check krhee
			j--;
			k++;
		}
		
		//agar is palindromic substring ki length previos wale se jada hai to update
		if (maxLen < k - j - 1) { //length = endingPoint - startingPoint - 1
			lo = j + 1; //upar j-- hua to piche gya so original place pe lane keliye lo= j + 1 kiya
			maxLen = k - j - 1; //maxlength
		}
		
	}
	
	public static void main(String args[]) {
		
		System.out.println(longestPalindrome("cbbd"));
		
	}

}
