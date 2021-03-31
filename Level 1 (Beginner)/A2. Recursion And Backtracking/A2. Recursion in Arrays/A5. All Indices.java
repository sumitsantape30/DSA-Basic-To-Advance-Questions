package Recursion;

import java.util.Scanner;

public class AllIndices {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int[] allIndices( int arr[], int x, int idx, int fsf) {
		if( idx == arr.length) { // hum basecase pe pohoch gye means end mai so ab hum ek naya array banake return karenge
			return new int[fsf];
			
		}
		
		if( arr[idx]== x) { // agar equal hai to yeh wali call karenge
			// yeh jo values lake dega woh array mai receive karenge
			int iarr[]=allIndices(arr, x, idx+1, fsf +1); //index bhi badhega and found so far bhi badhega
		   // jo basecase mai array bana woh iski niche wale level means yaha return hua then iarr ne receive kiya usko
			
			// jahape equal hai and jo answer recieve kiya hai usko directly return nhi karna pehle usme iarr mai fsf wali position ke upar index dalna hai aur fir hume iarr return karna hai
			iarr[fsf]= idx;
			return iarr;
		}else {
			int iarr[]= allIndices(arr, x, idx+1, fsf); // agar equal nhi hai to sirf index badhega fsf nhi badhege
		   //iss case mai bina kuch kare iarr return karna hai
		    return iarr;
		}
		//isme array sirf ek bar ban rha hai woh chota array sirf woh basecase mai bana hai jo nicheke levels hai use piche piche return kar rhe hai bas, woh as it is return kar rhe hai or value mai change karke return kr rhe hai
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		int result[]= allIndices(arr, 3, 0, 0);
		
		for( int i=0; i< result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
