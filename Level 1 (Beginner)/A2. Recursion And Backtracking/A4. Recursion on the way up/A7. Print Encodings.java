Print Encodings

1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
Use the input-output below to get more understanding on what is required
123 -> abc, aw, lc
993 -> iic
013 -> Invalid input. A string starting with 0 will not be passed.
103 -> jc
303 -> No output possible. But such a string maybe passed. In this case print nothing.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A string str
Output Format
Permutations of str in order hinted by Sample output

Constraints
0 <= str.length <= 10
Sample Input
655196

Sample Output
feeaif
feesf

Code:

package Recursion;

import java.util.Scanner;

public class printEncodings {
	
    public static void printEncodings(String ques, String asf) {
     if( ques.length() == 0) { //agar question ki length hogyi hai 0
    	 System.out.println(asf);
    	 return;
     }else if( ques.length()== 1) { //agar question ki length hai ek character
    	 
    	 char ch= ques.charAt(0);
    	 if( ch == '0') { // aur agar woh ek character 0 hua to answer nhi hai
    		 return ; // 1 hi length hai aur last mai 0 hai to hum kuch nhi kr skte
    	 }else {
    		 // agar woh koi aur character hai to uske corresponding jo code hoga woh print kardenge
    		 int chv= ch - '0'; //pehle woh character ko number mai convert karenge. ab chv ke andar asli wala means number ajayega
    		 // isliye number mai kiye coz uske corresponding character print karna hai hume
    		 char code= (char)(chv -1 + 'a'); //code keliye hum 'a' mai add karenge character ki value aur usme se 1 minus karenge
    		 asf= asf + code;
    		 System.out.println(asf);
    	 } 
     } else { // if( ques.length() >= 2) agar question ki length 2 ya 2 se badi ho to humare pas 2 option hojati hai
    	 // pehle character alag karenge
    	 char ch= ques.charAt(0);
    	 String roq= ques.substring(1) ;// rest of the string
    	 
    	 //yahpe bhi hume dhyan rakhna hai agar yeh character jo humne nikala hai woh 0 hua to problem hojayegi
    	 // so hum yahape bhi wahi kam karenge
    	 if( ch == '0') { 
    		 return ; 
    	 }else {
    		 int chv= ch - '0'; 
    		 char code= (char)(chv -1 + 'a');
    		 //yaha ab print nhi kareng, 2 ya 2 se bda hai woh call karenge
    		 printEncodings(roq, asf + code); // answer so far mai code add krte hue aage call kar denge
    	 } 
     } // ek character wala kam hogya
     
     //ab aisa bhi ho skta hai ki pehle 2 character ho apne pas
     String ch12= ques.substring(0,2) ;// character 1 and 2 = ch12
     String roq12= ques.substring(2); // isme 2 se end tak sabkuch milgya
     
     //ab jo characters nikale hai unko intergers mai convert karo
     int ch12v= Integer.parseInt(ch12);
     
     // ab aage ka kam tabhi hoga jab pehle 2 character jo nikale hai woh less than equal to 26 hai
     if( ch12v <= 26) {
		 char code= (char)(ch12v -1 + 'a'); // upar ka copy paste kiya hai
		 //yaha ab print nhi kareng, 2 ya 2 se bda hai woh call karenge
		 printEncodings(roq12, asf + code); // roq12 means baki roq 12 ko chhodke
     }
    }

	public static void printEncodings(String str, String asf) {
    	if( str.length() == 0) {
    		System.out.println(asf);
    		return;
    	}
    	// pehle string ki length hi check karna badme character
    	if( str.charAt(0) == '0') { // starting mai 0 agya to wahise return hojao
    		return;
    	}
    	
    	//char ch0= str.charAt(0); // iss character kobhi string mai hi lenge
    	String ch0= str.substring(0,1);
    	String ros1= str.substring(1);
    	
    	printEncodings(ros1, asf + (char)(Integer.parseInt(ch0) - 1 + 'a')); // 0th pe jo number tha string form mai usko number mai convert kiya then uska endcoding lene keliye character mai convert kiya
    	
    	// ab strting ke 2 character alag nikalne hai aur baki bachi hui string alag nikalni hai but yeh tabhi nikal paoge jab string ki length at least 2 ho
    	if( str.length() >= 2) {
    		String ch01= str.substring(0, 2);
        	String ros2= str.substring(2);
            
        	if(Integer.parseInt(ch01) <= 26) {
            	printEncodings(ros2, asf + (char)(Integer.parseInt(ch01) - 1 + 'a'));
        	}
    	}
    }
	
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		String str= s.next();
		printEncodings(str, "");
		
	}

}
