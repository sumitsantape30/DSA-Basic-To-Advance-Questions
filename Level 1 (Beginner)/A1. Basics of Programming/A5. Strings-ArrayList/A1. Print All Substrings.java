package Strings;

import java.util.Scanner;

public class Allsubstrings {
	
	public static String takeInput() {
		
		Scanner s= new Scanner(System.in);
		String str= s.next();
		return str;
	}
	
	public static void printSubstring(String str) {
		
		for( int i=0; i< str.length(); i++) {
			for( int j= i+1 ; j<= str.length(); j++) {
				System.out.println(str.substring(i,j));
			}
		}
	}

	public static void main(String[] args) {

		String str= takeInput();
		printSubstring(str);
		
	}

}

Input:
abcedf
Output:
a
ab
abc
abce
abced
abcedf
b
bc
bce
bced
bcedf
c
ce
ced
cedf
e
ed
edf
d
df
f
