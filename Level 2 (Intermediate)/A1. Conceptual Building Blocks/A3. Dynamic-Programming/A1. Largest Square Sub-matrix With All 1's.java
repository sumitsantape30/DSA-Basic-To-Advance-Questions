Largest Square Sub-matrix With All 1's

1. You are given a matrix of 0's and 1's.
2. You have to find the maximum size square sub-matrix with all 1's.
Input Format
A number N, which represents number of rows in matrix
A number M, which represents number of columns in matrix
arr1
arr2...N*M numbers
Output Format
Check the sample output and question video.

 Constraints
1 <= N,M <= 100
0<= arr[i][j] <= 1
Sample Input
5 6
0 1 0 1 0 1 
1 0 1 0 1 0 
0 1 1 1 1 0 
0 0 1 1 1 0 
1 1 1 1 1 1
Sample Output
3

Code:

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[][] arr) {
        int dp[][] = new int[arr.length][arr[0].length] ; // jitna bada array hai utne size ka dp array banayenge
        
        int ans = 0; //ans ko 0 se initialise karene pehle
        
        for( int i = dp.length - 1; i >= 0; i--){ //last row se loop laga rhe hai
            for( int j = dp[0].length - 1; j >= 0; j--){
                //mai unn 4 hisso mai todunga isko, 3 jagah pr jo arr mai uss spot pe value pdi hai wahi dp array mai uss spot pe ajayegi
                if( i == dp.length - 1 && j == dp[0].length - 1){ //agar yeh last cell pe hai
                    dp[i][j] = arr[i][j] ; // jo uss last mai pda hai wahi value dp mai dal denge
                    
                }else if( i == dp.length - 1){ //last row
                    dp[i][j] = arr[i][j];
                    
                }else if( j == dp[0].length - 1){ // last column 
                    dp[i][j] = arr[i][j] ;
                    
                }else{ // and the rest of it, baki area
                     
                     if( arr[i][j] == 0){ //agar baki area mai kahipe 0 hai to wahi 0 dal de dp array mai
                        dp[i][j] = 0;
                         
                     }else{ //agar yeh spot pe 1 hai to hum minimum lenge
                     
                       int min = Math.min(dp[i][j + 1], dp[i + 1][j]); //horizontal and vertical ka minimum
                       min = Math.min(min, dp[i + 1][j + 1]); // jo horizontal aur vertical ka minimum tha uska digonal ke sath bhi minimum lenge
                       dp[i][j] = min + 1; // so dp[i][j] min +1 store kardenge ab
                       
                       if( dp[i][j] > ans){ //harbar jo value store hui agar woh previous ans se badi hui to ans ko update krdenge
                        ans = dp[i][j];
                        //aisa nhi hai ki top left pehi answer ajayega bichme kahipebhi answer aa skta hai 
                       }
                    }
                }
            }
        }
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m =scn.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < m; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		
		System.out.println(solution(arr));
	}

}
