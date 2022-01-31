Maximum Consecutive Ones - 1

1. You are given an array(arr) which contains only 0's and 1's.
2. You have to find the maximum number of consecutive 1's in the given array if you can flip at most one zero.
Input Format
A number N
arr1
arr2... N numbers
Output Format
A number representing maximum number of consecutive 1's after flipping at most one zero.

Constraints
1 <= N <= 10^5
0 <= arr[i] <= 1
Sample Input
6
1 1 0 0 1 1
Sample Output
3

Code:

import java.util.*;

public class Main {

    public static int solution(int[] arr){
        int ans = 0;
        
        //j ko rkha -1 pr aur count rakha 0
        int j = -1;
        int count = 0;
        
        for( int i=0; i< arr.length; i++){
            if( arr[i] == 0){ //agar 0 mila hai to count badhado
               count++;
            }
            
            while( count > 1){ //agar apka jo count hai woh 1 se bada hogya hai 
             //to j badhaye aur agar j spot pe 0 hai to count ghataye
             j++;
             if( arr[j] == 0){
                 count--;
             }
            }
            
            //jab aap yaha honge to apka count 1 hoga
            int len = i - j;
            if( len > ans){ //agar apki len answer se badi hai to ans ko update krde
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
        System.out.println(solution(arr));
	}

}

