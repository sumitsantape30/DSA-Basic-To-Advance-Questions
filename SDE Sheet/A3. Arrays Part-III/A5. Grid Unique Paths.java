Problem Statement: Given a matrix m X n, count paths from left-top to the right bottom of a matrix with the constraints that from each cell you can either only move to the rightward direction or the downward direction.

Example 1:

Input Format: m = 2, n= 2
Output: 2
Explanation: From the top left corner there are total 2 ways to reach the bottom right corner

Code:

package Arrays;

public class uniqueGrids {
	

	//brute Force - Recursion
    public int uniquePaths(int m, int n) {
        int arr[][]= new int[m][n];
        int ans = pathsHelper(arr, 0, 0);
        return ans;
    }
    
    public int pathsHelper( int arr[][], int i, int j){
        if( i < 0 || i > arr.length || j < 0 || j > arr[0].length){
            return 0;
        }
        if( i == arr.length-1 && j == arr[0].length-1){
            return 1;
        }

        int count1 = pathsHelper(arr, i, j+1);
        int count2 = pathsHelper(arr, i+1, j);
        int ans = count1 + count2;
        return ans;

    }
    
    //better- memoization
	 public static int pathsHelper2( int arr[][], int i, int j, int dp[][]){
         if(i >= arr.length|| j >= arr[0].length){
             return 0;
         }
         
         if( i == arr.length-1 && j == arr[0].length-1){
             return 1;
         }
         
         if( dp[i][j] != -1) {
        	 return dp[i][j];
         }
         
         int count1 = pathsHelper2(arr, i, j+1, dp);
         int count2 = pathsHelper2(arr, i+1, j, dp);
         int ans = count1 + count2;
         
         dp[i][j] = ans;
         
         return ans;

    }

    public  int uniquePaths2(int m, int n) {
        int arr[][]= new int[m][n];
        int dp[][]= new int[n][n];
        for( int i=0; i< dp.length; i++) {
        	for( int j=0; j< dp[0].length; j++) {
        		dp[i][j]= -1;
        	}
        }
        int ans = pathsHelper2(arr, 0, 0, dp);
        return ans;
    }
    
    //optimised solution - combination
    public  int uniquePaths3(int m, int n) {
        int N = n + m - 2; //Calculate the total number of steps required to reach the destination (bottom-right corner) from the top-left corner, considering only right and down movements. Since there are m-1 right moves and n-1 down moves, the total number of steps required is m-1 + n-1 = m + n - 2, which is stored in the variable N.
        int r = m - 1; //Calculate the number of right moves (r) required to reach the bottom-right corner from the top-left corner. The number of right moves is equal to m - 1, as there are m columns and you start at the first column (0-indexed). The variable r holds this value.
	//left moves bhi le skte ho right ki jagah
	    
        double res = 1; //Initialize a variable res with a value of 1. This variable will store the result, representing the total number of unique paths.

         for( int i = 1; i<= r; i++){
             res = res * (N - r + i) / i; //The binomial coefficient C(N - r + i, i) represents the number of ways to choose i right movements out of N - r + i total movements required to reach the destination. It is calculated using the formula C(n, k) = n! / (k! * (n - k)!).
         }
         return (int)res;

     } 

	public  void main(String[] args) {

		System.out.println(uniquePaths(3, 2));
	}

}

