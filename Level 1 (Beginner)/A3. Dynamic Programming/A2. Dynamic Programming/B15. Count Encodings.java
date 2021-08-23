Count Encodings

1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. You are required to calculate and print the count of encodings for the string str.

     For 123 -> there are 3 encodings. abc, aw, lc
     For 993 -> there is 1 encoding. iic 
     For 013 -> This is an invalid input. A string starting with 0 will not be passed.
     For 103 -> there is 1 encoding. jc
     For 303 -> there are 0 encodings. But such a string maybe passed. In this case 
     print 0.
Input Format
A string str
Output Format
count of encodings

  COMMENTConstraints
0 < str.length <= 10
Sample Input
123
Sample Output
3

Code:

package DP;

import java.util.Scanner;

public class countEncodings {
	
	public static int ce(String str, int idx) { //virtually chota krdenge string ko to index pass kardiya
		if (idx == str.length()) { //agar blank string ko call lag gyi to wahase 1 return hota hai 
			return 1;
		}
		
		
		if( str.charAt(idx) == '0') { //agar 0 pda hai to wahase 0 return kardena, coz uski 0 encodings hai
			return 0; //string ke index pe 0 pda hai to wahase 0 return karenge
		}
		
		int f1= ce(str, idx+1); // indxe+1 se aage ke string ka encoding mangwa liya
		int f2= 0;
		
	/*	// factor 2 ko aap tabhi consider kare jab woh less than equal to 26 ho
		if(idx <= str.length()-2 && Integer.parseInt(str.substring(idx, idx+2)) <= 26) {  //yeh call lagate waqt at least 2 elements tobhi exist krte ho tabhi woh 2 element nikal payenge isliye woh condn lagayi means ideally idx+2 <= str.length() hona 
			f2= ce(str, idx+2);
		} */
		//string ko chota nhi kr rhe string wahi pass kr rhe hai, virtually chota kr rhe hai string ko
		
		if( idx +1 < str.length()) {
			int chi= str.charAt(idx) - '0'; //character at i, -'0' kiya to integer mai convert hoajeyga
			int chip1= str.charAt(idx+1) - '0';
			if( chi * 10 + chip1 <= 26) { //tabhi aap dusri call laga skte ho
				f2= ce(str, idx+2);
			}
		}
		
		return f1+f2;
		
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		String str= s.nextLine();
		System.out.println(ce(str, 0));
		
	}

}
