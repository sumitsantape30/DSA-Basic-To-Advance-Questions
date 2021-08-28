Largest Area Histogram
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the height of bars in a bar chart.
3. You are required to find and print the area of largest rectangle in the histogram.

e.g.
for the array [6 2 5 4 5 1 6] -> 12
Input Format
Input is managed for you
Output Format
A number representing area of largest rectangle in histogram

Constraints
0 <= n < 20
0 <= a[i] <= 10
Sample Input
7
6
2
5
4
5
1
6
Sample Output
12

Code:
package Stack;

import java.util.Scanner;
import java.util.Stack;

public class LargestAreainHistogram {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void Area( int arr[]) {
		
		int rb[]= new int[arr.length]; // right boundary is basically the next smaller element index on the right
		//next greater element on the right, from right to left ka loop 
		Stack<Integer> st= new Stack<Integer>();
		st.push(arr.length-1); //akhir wale ka index isme dal diye
		rb[arr.length-1]= arr.length; //last wale bande ki right boundary, jiska next smaller element na mile on the right side uska by default arr.length manlo
		//maine default yeh man liya ab mai loop chalunga ulta
		for(int i = arr.length-2 ; i >= 0 ; i--) {
			while( st.size() > 0 && arr[i]< arr[st.peek()]) { //agar arr[i] chota hai stack ke top se to, means stack ke top pe bda elements hai to use pop kara dega.
				//woh rukega tab jab use apnese chota banda milega
				st.pop(); 
			}
			
			if( st.size()== 0) {
			 rb[i]= arr.length;
		    }else {
			   rb[i]= st.peek();
		   }
			st.push(i);
		}//so right boundary mil gyi hai
		
		int lb[]= new int[arr.length]; // left boundary is basically the next smaller element index on the left
		// mai isme yeh nhi rakhne wala ki 4 ka next smaller element 1 hai mai yeh rakhne wala hu 4 ke next smaller element ka index kya hai woh mai index rakhne wala hu. index mese index substract karunga to muje width dekhne ko milegi
		st= new Stack<Integer>();
		st.push(0); 
		lb[0]= -1; //0 ki left boundary -1 hongi coz 0 ke left mai koi hai hi nhi
		for(int i = 1 ; i < arr.length ; i++) {
			while( st.size() > 0 && arr[i]< arr[st.peek()]) {
				st.pop();
			}
			
			if( st.size()== 0) {
			 lb[i]= -1;
		    }else {
			   lb[i]= st.peek();
		   } 
			st.push(i);
		}
		
		//agar yeh dono bhi mere pas ho
		int maxArea=0;
		for( int i=0; i< arr.length; i++) {
			int width= rb[i] - lb[i] - 1;
			int area= arr[i] * width; //uski height arr[i] mai hi pdi hui hai
			
			if( area > maxArea) { //agar yeh area maxArea se jada hai to maxArea ko update karlenge
				maxArea= area;
			}
		}
		
		System.out.println(maxArea); //bahar aake maxArea ko print karlenge
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		Area(arr);
		
	}

}

//====================================JB===========================================================

package practice;

import java.util.Scanner;
import java.util.Stack;

public class Code {
	
	
	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		
		int nsl[]= new int[arr.length]; // nsl : next smaller on left
		int nsr[]= new int[arr.length]; //nsr: next smaller on right

		
		Stack<Integer> st= new Stack<Integer>();
		
		 
		for(int i = 0 ; i < arr.length ; i++) {
			//pop all elements
			while( st.size() > 0 && arr[st.peek()] >= arr[i] ) {
				st.pop();
			}
			
			// update your ans
			if( st.size()== 0) {
			 nsl[i]= -1;
		    }else {
			   nsl[i]= st.peek();
		   } 
			//push current index in the stock
			st.push(i);
		}
		

		st= new Stack<Integer>();
		
		for(int i = arr.length-1 ; i >= 0 ; i--) {
			//pop all grater elements
			while( st.size() > 0 && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			
			//update uour ans
			if( st.size()== 0) {
			 nsr[i]= arr.length;
		    }else {
			   nsr[i]= st.peek();
		   }
			// push current index in the stock
			st.push(i);
		}
		
		int ans =0;
		for( int i=0; i< arr.length; i++) { 
			
			ans= Math.max(ans, arr[i]* (nsr[i]- nsl[i] -1));
	
		}
		
		System.out.println(ans); 
	}

}
