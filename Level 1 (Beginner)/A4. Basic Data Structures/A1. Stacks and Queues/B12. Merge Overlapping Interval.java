Merge Overlapping Interval
1. You are given a number n, representing the number of time-intervals.
2. In the next n lines, you are given a pair of space separated numbers.
3. The pair of numbers represent the start time and end time of a meeting (first number is start time and second number is end time)
4. You are required to merge the meetings and print the merged meetings output in increasing order of start time.

E.g. Let us say there are 6 meetings
1 8
5 12
14 19
22 28
25 27
27 30

Then the output of merged meetings will belongs
1 12
14 19
22 30

Note -> The given input maynot be sorted by start-time.
Input Format
Input is managed for you 
Output Format
Print a merged meeting start time and end time separated by a space in a line
.. print all merged meetings one in each line.


Constraints
1 <= n <= 10^4
0 <= ith start time < 100
ith start time < ith end time <= 100
Sample Input
6
22 28
1 8
25 27
14 19
27 30
5 12
Sample Output
1 12
14 19
22 30
  
Code:

package Stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.Scanner;

public class MergeOverlapInterview {
	
	public static int[][] takeInput(){
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[][]= new int[n][2];
		
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				arr[j][0]= s.nextInt();
				arr[j][1]= s.nextInt();
			}
		}
		return arr;
	}
	
	//1. mai chahta hu yeh sort ho ske, jabt aap ek array or pairs ko sort karna chahte hai to uspe aapko comparable of pair implement karna pdta hai
	public static class Pair implements Comparable<Pair> {
		int st;
		int et;
		
		Pair(int st, int et){
			this.st= st;
			this.et= et;
		}
		
		public int compareTo(Pair other) {
			//so yahapr 2 objects compare ho rhe hai ek object this hai and dusra other hai jo parameter mai pass hua hai
			//agar this > other se to hum return karenge +ve value
			//agar this aur other barabr hai to return karenge 0
			// this < other se to aap return karenge -ve value
			if( this.st != other.st) { // agar donoke start time equal nhi hai
				return this.st - other.st; //this.st bada rha to positive value return hogi means decreasing, this.st chota rha to negative value return hogi means increaing
			}else { //agar donoka start time same hai to unka difference 0 hoga so end time ka difference return karenge
				return this.et - other.et; // [1,2] [1,4] isme st same hai donoka
			}
		}
	} //By implementing the Comparable interface and providing the compareTo method, you enable Java's built-in sorting methods to work with instances of your Pair class seamlessly.
	
	
	public static void mergeOverlappingIntervals(int arr[][]) {
		
		Pair[] pairs= new Pair[arr.length]; //pairs ka array banaya
		
		for( int i=0; i< arr.length; i++) {
			pairs[i]= new Pair(arr[i][0], arr[i][1]); //0th mai start time diya hai and 1 mai end time diya hai 
		}
		
		//ab mai chahta hu isko sort karna
		Arrays.sort(pairs); // mai chhata hu pairs array sort hojaye aur start time pe sort hojaye. Arrays.sort() internally compareTo method use krti hai sort krne keliye so humne nayi compareTo method implement ki hai humare tarike se
		//java ek integers ke array ko sort krdeti hai but woh apke objects ke array ko sort nhi kr skti to aapko usko batana padega ki sort karo aur kisko chota manna aur kisko bada manna
	   //see comparable
		
		//so sort hone ke bad 
		Stack<Pair> st= new Stack<Pair>();
		for( int i=0; i < pairs.length; i++) {
			if( i == 0) {// pehla banda hai to sirf push hoga
				st.push(pairs[i]);
			}else {
				//agar dusra banda hai to hum dekhenge top pe kon hai
				Pair top= st.peek();
				
				if( pairs[i].st > top.et) { //agar pairs of i jo abhi ara rha hai uska start time bada hai uske end time se to yeh sirf push hojayega
					st.push(pairs[i]);
				}else {
					//otherwise jo top pe pda hai usike end time ko update karenge
					top.et= Math.max(top.et, pairs[i].et);
				}
			}
		}
		
		
		Stack<Pair> rs= new Stack<>(); //result stack
		while( st.size() > 0) {
			rs.push(st.pop());
		}
		
		while( rs.size() > 0) {
			Pair p= rs.pop();
			System.out.println(p.st+ " "+ p.et);
		}
		
	}

	public static void main(String[] args) {

		int arr[][]= takeInput();
		mergeOverlappingIntervals(arr);
		
	}
}

