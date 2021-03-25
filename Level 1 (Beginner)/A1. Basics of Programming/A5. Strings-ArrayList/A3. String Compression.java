String Compression

1. You are given a string. 
2. You have to compress the given string in the following two ways - 
   First compression -> The string should be compressed such that consecutive duplicates of characters are replaced with a single character.
   For "aaabbccdee", the compressed string will be "abcde".
   Second compression -> The string should be compressed such that consecutive duplicates of characters are replaced with the character and followed by the number of consecutive duplicates.
   For "aaabbccdee", the compressed string will be "a3b2c2de2".
Input Format
A String
Output Format
Two strings representing first compressed string and second compressed string respectively.
 
Constraints
1 <= length of string <= 1000
Sample Input
wwwwaaadexxxxxx
Sample Output
wadex
w4a3dex6

Code:

package Strings;

import java.util.Scanner;

public class StringCompression {
	
	public static String takeInput() {
		Scanner s= new Scanner(System.in);
		String str= s.next();
		return str;
	}
	
	public static String Compression1( String str) {
		
		//intially output string mai string ka 0th character dal de
		String s= str.charAt(0)+ ""; // empty string "" add karne se woh pura string mai convert hogya, akela str.charAt(0) rakhte to woh bas character hojate usko character mai hi store karna pdta isliye usko string mai convert kiye
		
		
		//ab first character se loop lagayenge
		for( int i=1; i< str.length(); i++) {
			//current character nikalenge aur usko piche wale ke sath compare karenge
			char curr= str.charAt(i);
			//and current se previous wala character i-1 pe hai
			char prev= str.charAt(i-1);
			
			//agar jo current character hai woh pichle se alag hai to woh add hoga string mai warna nhi hoga
			if( prev != curr) {
				s += curr; 
			}
		}
		return s;
	}
	
	public static String Compression2( String str) {
		
         String s= str.charAt(0)+"";
         int count=1; //count bhi rakhenge
		
		for( int i=1; i< str.length(); i++) {
			char curr= str.charAt(i);
			char prev= str.charAt(i-1);
			
			//agar current previous ke sath same hai to hum sirf count badhayenge
			if( curr == prev) {
				count++;
			}else { //agar current previous ke sath same nhi hai to rehle hum count add karenge string mai and count tabhi add hota hai jab count 1 nhi hota
				
				if( count > 1) {
					s += count;
					count= 1; //count ko add kardene ke bad count ko 1 kardenge
				} //agar count 1 hai to use add hi na kare aur fir yeh hone ke bad apne jo current character hai use add kare
				s += curr;
			}
		}
		//agar humare pas count bacha hua hai jo 1 se bda hai to woh add hoga last mai
		if( count > 1) {
			s += count;
			count= 1;
		}
		return s;
	}

	public static void main(String[] args) {

		String str= takeInput();
		String s1= Compression1(str);
		String s2= Compression2(str);
		System.out.println(s1);
		System.out.println(s2);
	}

}
