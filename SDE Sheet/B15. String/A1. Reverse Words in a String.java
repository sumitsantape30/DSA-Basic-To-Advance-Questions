Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
  
Code:

package Codes;

import java.util.*;
import java.io.*;

public class code {
	

	public static String reverseByword(String str) {
		
		String result = "";
		
		int i=0;
		while(i < str.length()) {
			
			while(i < str.length() && str.charAt(i) == ' ')i++;
			
			if( i >= str.length()) { //agar i badhake string ki length ke barabr or cross kargya to break the loop
				break;
			}
			
			int j= i+1;
			
			while( j < str.length() && str.charAt(j) != ' ')j++;
			
			String word = str.substring(i, j);
			
			if(result.length() == 0) { //if result is empty means this is the first word
				result = word;
			}else {//if there are already some words in result
				
				result = word + " "+ result;
			}
			
			//i ko j ke aage leke ayenge coz ek word hogya
			i = j + 1;
									
		}
		
		return result;
		
	}
	
	public static void main(String args[]) {
		
		System.out.println(reverseByword("a good   example"));
		
	}

}
