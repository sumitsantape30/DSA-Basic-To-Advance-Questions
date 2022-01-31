Maximum Consecutive Ones - 2

1. You are given an array(arr) which contains only 0's and 1's and a number K.
2. You have to find the maximum number of consecutive 1's in the given array if you can flip at most K zeroes.
Input Format
A number N
arr1
arr2... N numbers
A number K
Output Format
A number representing maximum number of consecutive 1's after flipping at most K zeroes.

Constraints
1 <= N <= 10^5
0 <= arr[i] <= 1
1 <= K <= N
Sample Input
6
1 1 0 0 1 1
1
Sample Output
3

Code:

import java.util.*;

public class Main {

    public static int solution(int[] arr, int k){
        int ans = 0;
        
        int j = -1; //release krne keliye j ko shuruwat mai rakha -1 pr
        int count = 0;
        
        //acquire wala loop chala denge ki acquire to karnahi hai
        for( int i=0; i< arr.length; i++){
            // i harbar acquire hota ahi
            if( arr[i] == 0){ //agar i pe 0 agya to count++
              count++;
            }
            
            while( count > k){ //jaisehi apka count k se bada hojaye. ab valid nhi hai, jasehi number of 0s k se bade hojayenge to aap j badhake release kardenge
              j++;
              if( arr[j] == 0){ //0 ko release krdiya hai to count-- kardenge
                count--;
              }
            }
            //iss loop se bahar aneka ek hi tarika hai ki apka count k ke equal hojaye, to jab yahape aayenge to count k ke equal ho chuka hoga to iss moment pr length nikalenge
            int len = i - j;
            if( len > ans){
                ans = len;
            }
        }
        
        return ans;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr,k));
	}

}
