Paint House - Many Colors

1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
Input Format
A number n
n1-0th n1-1st n1-2nd .. n1-kth
n2-0th n2-1st n2-2nd .. n2-kth
.. n number of elements
Output Format
A number representing the minimum cost of painting all houses without painting any consecutive house with same color.
Question Video

  COMMENTConstraints
1 <= n <= 1000
1 <= k <= 10
0 <= n1-0th, n1-1st, .. <= 1000
Sample Input
4 3
1 5 7
5 8 4
3 2 9
1 2 4
Sample Output
8

Code:
package DP;

import java.util.Scanner;

public class paintHouseManyColors {
	
	// n3 approach hai yeh
	public static int paintHouseManyColors( int arr[][]) {
		int n= arr.length;
		int c= arr[0].length;
		
		int dp[][]= new int[n][c];
		
		for( int j=0; j< arr[0].length; j++) { //first row wahi rahega jaise ka waisa
			dp[0][j]= arr[0][j];
		}
		
		for( int i=1; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				// ab yaha i hai house number aur j hai color number
				//so ith ghar pr jth color lagana hai to usse pehle wale gharke upar jth ko chodkar koi bhi color ho skta hai
				int min= Integer.MAX_VALUE;
				
				//isse pehle wali row mai ghumenge to get minimum
				for( int k=0; k< dp[0].length; k++) {
					if( k != j) { //minimum lete waqt dhyan denge ki k!= j
						if( dp[i-1][k] < min) { //pichli row ke sare colors except j color itself agar woh chota hai min se to min ko update krlo
							min= dp[i-1][k];
						}
					}
				}
				
				// min aagya ab dp mai dalenge
				dp[i][j]= arr[i][j] + min;
			}
		}
		
		//aisa karne ke bad jo aakhri row ka min hoga woh humara answer hoga
		int min= Integer.MAX_VALUE;
		for( int k=0; k< arr[0].length; k++) { 
			if( dp[n -1][k] < min) {  //aakhri row isliye n-1
				min= dp[n -1][k];
			}
		}
		
		return min;
		
	}
	
	// yeh n2 hai, loop mai loop aur mamla khatam
	public static int paintHouseManyColors( int arr[][]) {
		int n= arr.length;
		int c= arr[0].length;
		
		int dp[][]= new int[n][c];
		
		// jab hum first row ko bhar rhe hai tabhi least aur 2nd least ko nikalne ki koshish kare
		int least= Integer.MAX_VALUE;
		int sleast= Integer.MAX_VALUE;
		for( int j=0; j< arr[0].length; j++) { 
			dp[0][j]= arr[0][j];
			
			//agar aapki value jo arr[0][j] dal rhe hai , agar yeh value least sebhi choti hai 
			if( arr[0][j] <= least) {
				sleast= least;
				least= arr[0][j];
				
			}else if(arr[0][j] < sleast){
				//agar yeh sirf 2nd least se choti hai to sirf second least mai change ayega
				sleast= arr[0][j];
			}
		}
		
		for( int i=1; i< dp.length; i++) {
			int nleast= Integer.MAX_VALUE;
			int nsleast= Integer.MAX_VALUE; //new least and 2nd least bhi calculate karne padenge
			for( int j=0; j< dp[0].length; j++) {
				if(least == dp[i-1][j]) { //agar least pichle wale se equal hai to 2nd least add karenge
					dp[i][j]= sleast+ arr[i][j];
				}else {
					dp[i][j]= least + arr[i][j];
				}

				//agli row keliye least aur sleast calculate kr rhe hai
				if (dp[i][j] <= nleast) {
					nsleast = nleast;
					nleast = dp[0][j];

				} else if (dp[i][j] < nsleast) {
					nsleast = dp[0][j];
				}
			}
			//yeh pura process hone ke bad mere pas naya least aur 2nd least agya hoga
			// so agli row mai jane se pehle least mai new least ko pdkdle
			least= nleast;
			sleast= nsleast;
		} 
		
		return least;
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt(); // number of houses
		int c= s.nextInt(); // number of colors
		
		int arr[][]= new int[n][c];
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		
		System.out.println(paintHouseManyColors(arr));
		
	}

}
