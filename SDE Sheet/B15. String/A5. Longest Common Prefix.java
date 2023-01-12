Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 
Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
  
Code:

//========================================== Brute Force==================================================

package Codes;

import java.util.*;
import java.io.*;

public class code {
	
	public static int getMinLength(String strs[]) {
		
		int min = strs[0].length();
		
		for( int i= 1; i< strs.length; i++) {
			
			if( strs[i].length() < min) {
				min = strs[i].length();
			}
		}
		return min;
		
	}

	public static String longestCommonPrefix(String[] strs) {
		
		int n = strs.length;
		
		int minLen = getMinLength(strs);
		
		String result = "";
		int count= 0;
		
		for( int i=0; i< minLen; i++) {
			
			char curr = strs[0].charAt(i); //har string ka 0th character same rehna chahiye. apn yaha 0th index pe rakhi string ka har ek character baki strings mai dekh rhe hai
			
			System.out.println(curr);
			for( int j= 1; j< n; j++) {
				
				if(strs[j].charAt(i) != curr) {
					return result;
				}
			}
			
			result += curr;
			
		}
		return result;

	}

	public static void main(String args[]) {

		String arr[] = {"geeksforgeeks", "geeks", "geek", "geezer"};
		System.out.println(longestCommonPrefix(arr));

	}

}

//======================================================== Optimal - trie =================================================
 Solution: https://www.geeksforgeeks.org/longest-common-prefix-using-trie/
