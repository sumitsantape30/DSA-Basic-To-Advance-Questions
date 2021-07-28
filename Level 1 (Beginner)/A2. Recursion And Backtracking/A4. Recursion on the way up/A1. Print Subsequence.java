Print Subsequence

1. You are given a string str.
2. Complete the body of printSS function - without changing signature - to calculate and print all subsequences of str.
Use sample input and output to take idea about subsequences.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A string str
Output Format
Subsequences of str in order hinted by Sample output

Constraints
0 <= str.length <= 7
Sample Input
yvTA

Sample Output
yvTA
yvT
yvA
yv
yTA
yT
yA

Code:

package Recursion;

import java.util.Scanner;

public class PrintSubsequence {
	
	//arraylist mai agar sare subsequence store krte to memory jada lag jati ab hum sare ek sath store nhi krte, ek paida krte hai use print krte hai fir stack mai ek level niche aajate hai
	// fir dusre ispe jata hai fir dusre ko print krte hai fir niche aajate hai to kisi moment pe stack mai 4 level honge usse jada kabhi nhi honga, stack mai utne levels hote hai jitne aapke pas number of characters hote hai
	public static void printSS( String ques, String ans) {
		if( ques.length() == 0) { // jab question ki length hojayegi 0 to ab kahi nhi ja skte to return karna hoga but usse pehle humm answer ko print karlenge
			System.out.println(ans);
			return;
		}
		
		// ek yes ki call lagegi and ek no ki call lagegi, woh character ek bar ayegi aur ekbar nhi ayega
		// ab mai question ko split karunga
		char ch= ques.charAt(0); // iss character ke pas 2 options hai ki woh ek bar ayega aur ekbar nhi ayega
		String roq= ques.substring(1);  //rest of the question, 1 ke bad ka question split karenge
		printSS(roq, ans + ch); // ab answer mai character dal rhe hai, yeh yes ki call hai 

		printSS(roq, ans +""); // roq pass kiya and answer ke andar character add nhi kiya, character ne no keh diya
		
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		String str= s.next();
		printSS(str, ""); // hum ques and answer aise do rakh rhe hai and starting mai answer "" pass kiya gya hai
		
	}

}
