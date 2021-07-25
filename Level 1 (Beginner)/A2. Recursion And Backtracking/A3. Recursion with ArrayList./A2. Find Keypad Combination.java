Get Kpc
1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
2. The following list is the key to characters map :
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
3. Complete the body of getKPC function - without changing signature - to get the list of all words that could be produced by the keys in str.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A string str
Output Format
Contents of the arraylist containing words as shown in sample output

Constraints
0 <= str.length <= 10
str contains numbers only
Sample Input
78
Sample Output
[tv, tw, tx, uv, uw, ux]

Code:

package Recursion;

import java.util.Scanner;
import java.util.ArrayList;

public class KeypadCombination {
	
	public static String takeInput() {
		
		Scanner s= new Scanner(System.in);
		String str= s.next();
		return str;
	}
	
	//humne jo key codes de rakhe hai to uska hume ek global array banana hoga, global array ko hum static se difine krte hai
	// string hai to string ka array banayenge taki input number sring mai 0th pe jo number hoga ussa index pe jake uske character access karpaye aur usko substring(1) se aage walo ke sath append karpye
	// 0h pe hai .; 1th index pe hai abc 2nd index pe hai def so on...
	static String codes[]= {".;","abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"}; //yeh array bar bar use hoga isliye bahar hi bana dya
	//yeh array function ke bahar banaya isliye static banaya andar hota to bina static kehi bana dete
	
	public static ArrayList<String> getKPC(String str){
		if( str.length()== 0) { //agar koi key press nhi hui to ek word generate hoga that's blank
			ArrayList<String> bres= new ArrayList<String>();
			bres.add("");
			return bres;
		}
		
		// humari input string 678 types hogi yeh represent krta hai ki pehle 6 press hua then 7 and then 8 press hua
		
		//so uss 678 ka 6 alag karlena hai
		 char ch= str.charAt(0); // 6
		String ros= str.substring(1); // 78 bhi alag nikal liya
		
		// ab maine ek faith rakha aur call laga di
		ArrayList<String> rres= getKPC(ros);// recursion result. hume faith hai ki 78 ke words aajayenge
		// rres  mai 6 words ajayenge of 78
		
		// lekin muje to answer 678 ka chahiye so my result
		ArrayList<String> mres= new ArrayList<String>(); // muje 24 words banane hai for 678
		
		// so yeh jo 6 words hai of 78 unke sath yeh 6 interact karega pehle
		
		String codeforch= codes[ch- '0']; //yahape muje mno mil gya ab mai ispe loop chalaunga. And - '0' isliye kiye taki character ko number bana ske 
		// so 678 ke 6 ke sare characters aagye ab yeh characters rres ke sare words ke sath interact karega
		// so mere is codeforch string mai 6 ke characters means pqrs aagye hai ab mai ispe loop chalaunga
		
		for( int i=0; i< codeforch.length(); i++) { // yeh loop mai uss strin pe chala rha hu, pehle p ayega fir q ayega so on
			char chcode= codeforch.charAt(i); // uspe loop chalake ek ek character leliye
			
			//ab recursion result mai loop lagayenge
			for( String rstr: rres) {
				// aur my result mai add karenge, jo character code aya hai usko rstr ke sath add karenge
				mres.add(chcode + rstr);
			}
			
		}
		return mres;	
	}

	public static void main(String[] args) {

		String str = takeInput();
		ArrayList<String> words= getKPC(str);
		System.out.println(words);
		
	}

}
