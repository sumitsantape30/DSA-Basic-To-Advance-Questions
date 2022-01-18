Matrix Chain Multiplication

1. You are given an array(arr) of positive integers of length N which represents the dimensions of N-1 matrices such that the ith matrix is of dimension arr[i-1] x arr[i].
2. You have to find the minimum number of multiplications needed to multiply the given chain of matrices.
Input Format
A number N
arr1
arr2.. N integers
Output Format
Check the sample output and question video.

  COMMENTConstraints
2 <= N <= 1000
1 <= arr[i] <= 500
Sample Input
3
1
2
3
Sample Output
6

Code:

import java.io.*;
import java.util.*;

public class Main {

	public static int mcm(int[] arr){
		int dp[][] = new int[arr.length-1][arr.length-1]; // array se choti dp banani hai muje, 6 length ka array mil hai to 5*5 ki dp banani hai muje
		
		for( int g = 0; g < dp.length; g++){
		    for( int i = 0, j = g; j < dp.length; i++, j++){
		        if( g == 0){ // agar gap 0 hai matlab pehla diagonal to waha sab jagah 0 ayega kyuki woh akeli matrix hai
		         dp[i][j] = 0;
		        }else if( g == 1){ //agar gap 1 hai tobhi kuch karenge
		          dp[i][j] = arr[i] * arr[j] * arr[j+1] ; // AB ke andarse jo A wali matrix hai woh i,i+1 pe pdi hai aur B ki matrix j,j+1 pe pdi hai 
		        }else{
		            int min = Integer.MAX_VALUE;
		            for( int k = i; k < j; k++){
		                //dp ke andar i se k mera left hoga aur k+1 se j right half hoga
		                //but array ke andar mera left half ki jo dimension rakhta hai woh i*k+1 ki rakhta hai, jo i se k jayega uski dimension i*k+1 hogi, aur array mai right half k+1 * j+1 jayega
		                int lc = dp[i][k]; //left ki cost
		                int rc = dp[k+1][j]; // right ki cost
		                int mc = arr[i] * arr[k + 1] * arr[j + 1]; //multiplication cost
		                int tc = lc + rc + mc; //total cost
		                if( tc < min){
		                    min = tc;
		                }
		            }
		            dp[i][j] = min;
		        }
		    }
		}
		
		//dp ka top right corner return karna hai
		return dp[0][dp.length-1];
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(mcm(arr));
	}

	
}
