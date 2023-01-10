Code:

package Codes;

import java.util.*;
import java.io.*;

public class code {

	public static int[] nextSmaller(int arr[]) {
		
		int nse[]= new int[arr.length];
		nse[arr.length-1] = -1;
		Stack<Integer> st = new Stack<>();
		
		for(int i= arr.length-2; i>=0; i--) {
			
			while(st.size() > 0 && arr[i] <= st.peek()) {
				st.pop();
			}
			
			if(st.size() == 0) {
				nse[i] = -1;
			}else {
				nse[i] = st.peek();
			}
			st.push(arr[i]);
			
		}
		
		return nse;
		
	}

	public static void main(String args[]) {
		int arr[]= {34, 35, 27, 42, 5, 28, 39, 20, 28 };
		int ans[] = nextSmaller(arr);
		for(int i=0; i< ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
