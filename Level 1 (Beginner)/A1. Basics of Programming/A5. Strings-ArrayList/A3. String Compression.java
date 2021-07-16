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
	
//===========================Jitu Bhaiyas method==========================
	
	public static String compression2( String str) {
		String ans= "";
		ans += str.charAt(0); // answer mai 0th character add karenge
		int count=1;
		
		//1 se leke last tak loop chalayenge
		for( int i=1; i< str.length(); i++) {
			
			if(str.charAt(i) == ans.charAt(ans.length()-1)) { // string ka ith character agar equal hai answer ke last character se to count badha do 
				 count++; //equal hota hai to bas count ko bdha denge
				 
			}else {
				//jab non equal hai to 3 kaam, count ko add karlo uss character ko add karlo aur count ko reset kardo
				
				if( count > 1) { //count 1 hoga to add nhi hoga directly woh character add kardenge
					ans += count;
					count=1;
				}
				ans += str.charAt(i);
			}
		}
		
		// loop se bahar aane ke bad agar count ki value grater than 1 hai to count add karlenge usme
		if( count > 1) {
			ans += count;
			count=1;
		}
		
		return ans;
		
	}
	
	public static String compression1( String str) {
		String ans= "";
		ans += str.charAt(0); // answer mai 0th character add karenge
		
		//1 se leke last tak loop chalayenge
		for( int i=1; i< str.length(); i++) {
			
			if(str.charAt(i) != ans.charAt(ans.length()-1)) { // string ka ith charcter agar equal nhi hai answer ke last character se to answer mai add karlo string ka ith character
				ans += str.charAt(i);
			}
			
		}
		return ans;
		
	}
	
//=========================================================================
	
	public static String Compression1( String str) {
		
		//intially output string mai string ka 0th character dal de
		String s= str.charAt(0)+ ""; // empty string "" add karne se woh pura string mai convert hogya, akela str.charAt(0) rakhte to woh bas character hojate usko character mai hi store karna pdta isliye usko string mai convert kiye
		// answer mai string ka pehla character as it is add kardenge
		
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
