Stock Span
Easy  Prev   Next
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the prices of a share on n days.
3. You are required to find the stock span for n days.
4. Stock span is defined as the number of days passed between the current day and the first day before today when price was higher than today.

e.g.
for the array [2 5 9 3 1 12 6 8 7]
span for 2 is 1
span for 5 is 2
span for 9 is 3
span for 3 is 1
span for 1 is 1
span for 12 is 6
span for 6 is 1
span for 8 is 2
span for 7 is 1
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video


Constraints
0 <= n < 10^5
-10^9 <= a[i] <= 10^9
Sample Input
4327142

Sample Output
1
1
3
4
5
6
1

Code:

package Stack;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int[] solve( int arr[]) {
		//sirf difference yeh hai ki left to right loop chalega aur index rakhenge
		int span[]= new int[arr.length];
		
		Stack<Integer> st= new Stack<Integer>();
		st.push(0);
		span[0]= 1;
		
		for( int i=1 ; i< arr.length; i++) {
			// humara algorithm hai, pop karaye answer le aur fir push karaye
			//pop all smaller elements
			while( st.size() > 0 && arr[i] > arr[st.peek()] ) { // pop tabtak karenge jabtak stack mai kuch hai aur arr of i arr[st.peek] se bda hai. stack mai index rakhege hue hao isliye arr[st.peek] liye
				// st.peek() se muje milega ek index to uss index pe rakhi value current index wale value se choti hai to usko pop karado
				// matlab tab rukenge jab stack mai humnse kuch bda milega
				st.pop();
			}
			
			//update your ans
			//ab jab hum rukenge to dekhenge stack ka size kaisa hai
			if( st.size() == 0) { //agar stack ka size 0 kara diya to sabko pop kardiya aapse koi chota hai hi nhi
				// uss case mai span hoga i+1
				span[i]= i - (-1);
			}else {
				// agar aap sabko pop nhi kara paye, to jo aapse bda aapke left par hai uska index
				span[i]= i - st.peek();
			}
			//push index of current element in the stack
			//last mai push krde i ko
			st.push(i);
		}
		
		return span;
		
	}
	
	public static void print(int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		int span[]= solve(arr);
		print(span);
		
	}
}
