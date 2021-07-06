
Decimal To Any Base

1. You are given a decimal number n.
2. You are given a base b.
3. You are required to convert the number n into its corresponding value in base b.
  
Input Format
A number n
A base b
Output Format
A number representing corresponding value of n in number system of base b

Constraints
0 <= d <= 512
2 <= b <= 10
  
Sample Input
57
 2
Sample Output
111001

Code:

package GettingStarted;

import java.util.Scanner;

public class DecimaltoanyBase {
	
	public static int getValueInitialised( int n, int b) {
		
		int ans= 0; //value to be returned
		int pow= 1; //10 ki sabse choti power hoti hai 10^0 that's actually 1
		
		while( n > 0) {
			int rem= n % b;  //jis base mai convert karna hai usase divide karenge
			n= n/b; //number ko chota kardenge
			
			//so jo pehle digit se jo pehla remainder aya hai usko sabse right mai bhejna hai to uske 10 ki sabse choti power se mutlipy karenge
		    // 10 ki sabse choti power hoti hai 10^0 that's actually 1
			ans= ans + (rem*pow); //ans ke purani value mai add karenge. Base ki power se multiply krte rahenge
			//next ane wale remainder ko 10 ki badi power se multiply karenge taki wo thodase left mai aaye
			pow= pow * 10;
		}
		
		return ans;

	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int b= s.nextInt(); // base
		int ans= getValueInitialised( n, b);
		System.out.println(ans);
	}

}
