Get Subsequence

1. You are given a string str.
2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
Use sample input and output to take idea about subsequences.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A string str
Output Format
Contents of the arraylist containing subsequences as shown in sample output

Constraints
0 <= str.length <= 20
Sample Input
abc
Sample Output
[, c, b, bc, a, ac, ab, abc]

Code:
package Recursion;
import java.util.ArrayList;
import java.util.Scanner;

public class getSubsequence {
	
	// hume faith hai ki bc ka answer yeh ayega => [--, -c, b-, bc]
	// humari expectation yeh hai ki abc ka banana hai using bc(yeh upar pda hai un sabkse sanmne dash(-) lagado and then a ne ha kaha to inke samne a lagado => [---, --c, -b-, -bc, a--, a-c, a-b, abc]  
	public static ArrayList<String> gss( String str){ //let's understand with example abc
		
		if( str.length()==0) { //jab string khatam hojaye to uska sirf ek hi subsequence hai that's blank empty string itself
			// so ek arraylist banake uskme blank add karke return karenge
			ArrayList<String> bres=  new ArrayList<String>();// base result
			bres.add("");
			return bres;
		}
		
		// abc ka jo pehla character hai use alag karliya
		char ch= str.charAt(0); // a
		String ros= str.substring(1); // 1 se leke end tak ka alag kar diya, abc tha to a alag kiya and bc alag kardiya
		// ab mai call karke rest of the string(ros) ka jawab la lenge
		ArrayList<String> rres= gss(ros); //mera faith hai ki isse result ajayega. Yahape bc ka result ajayega : [--, -c, b-, bc]
		// rres= recursion result
		
		//ab muje mera result banana hai
		ArrayList<String> myres=  new ArrayList<String>(); // so mai ab rres mai ek loop lagake kuch nhi dalunga means dash(-) dalunga fir mai usme dubara loop lagaunga aur isbar usme a kar dunga
		// myres= myresult
		
		// rres ka banda myres mai do bar add hoga blank and char ke liye so hum do alag alag loop laga skte hai (ek loop mai dono kobhi kr skte hai but this is more better)
		for( String rstr : rres) { 
			myres.add(""+ rstr); //ek bar jab a ne na keh diya to jaise ka waisa add hojayega			
		}
		
		for( String rstr : rres) { // rres ka banda myres mai do bar add hoga
			myres.add(ch + rstr) ; //ek bar jab a bolega ki mai aaunga
		} //2 loop lagane se order alag ayega bass that's it
		return myres;
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		String str= s.next();
		ArrayList<String> result= gss(str); //gss mai se jo arraylist ayegi usko print karna hai
		System.out.println(result);
	}

}
