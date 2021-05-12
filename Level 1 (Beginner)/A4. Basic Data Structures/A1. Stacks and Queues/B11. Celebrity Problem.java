Celebrity Problem
1. You are given a number n, representing the number of people in a party.
2. You are given n strings of n length containing 0's and 1's
3. If there is a '1' in ith row, jth spot, then person i knows about person j.
4. A celebrity is defined as somebody who knows no other person than himself but everybody else knows him.
5. If there is a celebrity print it's index otherwise print "none".

Note -> There can be only one celebrity. Think why?

                               
Input Format
Input is managed for you  
Output Format
Index of celebrity or none

Constraints
1 <= n <= 10^4
e1, e2, .. n * n elements belongs to the set (0, 1)
Sample Input
4
0000
1011
1101
1110
Sample Output
0

Code:

package Stack;

import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
	
	public static int[][] takeInput(){
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int m= s.nextInt();
		
		int arr[][]= new int[n][m];
		
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; i++) {
				arr[i][j]= s.nextInt();
			}
		}
		return arr;
	}
	
	public static void findCelebrity( int arr[][]) {
		
		Stack<Integer> st= new Stack<>();
		for(int i= 0; i < arr.length; i++) {
			st.push(i); //stack mai sabko add kardenge
		}
		
		while(st.size() >= 2) { //jabtak stak mai 2 ya 2 se jada log hai 
			// to hum do pop karenge
			int i= st.pop();
			int j= st.pop();
			
			//aur check karenge ki kya i j ko janta hai ya nhi
			if( arr[i][j] == 1) {
				//agar i j ko janta hai means i celebrity nhi hai
				// to jo celebrity nhi hai usko bahar rakhenge aur jo celebrity ho skta hai usko wapas dal denge
				st.push(j); //i celebrity nhi hai to j ko dal denge
				
			}else {
				//if i doesn't know j means j is not celebrity
				st.push(i);// j celebrity nhi hai means i ko wapas dal denge
			}
		}
		
		//aise krte krte last mai aapke pas 2 se kam log reh jayenge, last mai 1 hi reh jayega to mai usko bolta hu potential
		int pot= st.pop();
		// ab apko potential ki puri and column check karna hai
		for( int i=0; i< arr.length; i++) {
			if( i !=  pot) { //hume check tab karna hai jabt i potential ke equal nhi hai
				
				if( arr[i][pot] == 0 || arr[pot][i] == 1) { //agar koi i aisa nikal aya jo iss potential celebrity ko nhi janta ya koi i aisa nikal aya jisko potenntial janta hai to celebrity nhi hoga so hum none print karenge
					System.out.println("none");
					return;
				}
			}
		}
		
		//loop ke bahar aake hum potential print karenge
		System.out.println(pot);
	}

	public static void main(String[] args) {

		int arr[][]= takeInput();
		findCelebrity(arr);
	}
}
