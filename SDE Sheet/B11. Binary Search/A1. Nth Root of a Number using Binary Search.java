The nth root of a number M is defined as a number X when raised to the power N equals M.

Example 1:

Input: N=3 M=27

Output: 3

Explanation: The cube root of 27 is 3.
  
Code:

import java.io.*;
class GFG {
    private static double multiply(double number, int n) {
        double ans = 1.0;
        for(int i = 1;i<=n;i++) {
            ans = ans * number;
        }
        return ans; 
    }
    private static void getNthRoot(int n, int m) {
        double low = 1;
        double high = m;
        double eps = 1e-7; 
        
        while((high - low) > eps) {
            double mid = (low + high) / 2.0; 
            if(multiply(mid, n) < m) {
                low = mid; 
            }
            else {
                high = mid; 
            }
        }
        
        System.out.println(n+"th root of "+m+" is "+low);  
        
    }
	public static void main (String[] args) {
		int n = 3, m = 27; 
		getNthRoot(n, m); 
	}
}
Output: 3th root of 27 is 3

Time Complexity: N x log(M x 10^d)

Space Complexity: O(1)
