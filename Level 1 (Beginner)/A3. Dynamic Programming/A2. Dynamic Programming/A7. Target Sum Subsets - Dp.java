Target Sum Subsets - Dp

1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add 
     up to "tar" or not.
Input Format
A number n
n1
n2
.. n number of elements
A number tar
Output Format
true or false as required
Question Video

  COMMENTConstraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= tar <= 50
Sample Input
5
4
2
7
1
3
10
Sample Output
true

Code:

package DP;

import java.util.Scanner;

public class targetSumSubset {
	
	public static void targetSumSubset(int arr[], int tar) {

		//true or false store karege isliye boolean array banayenge
		boolean dp[][]= new boolean[arr.length+1][tar+1]; //dp array banaynge jisme array size+1 hoga aur jo target ho usse ek size jada means target+1
		
		//pehla cell and rest of the row, aur first cell aur rest of the column 
		// pehle row mai first cell chodake sab false hai coz empty array 0 ke alawa kuch nhi bana skta
		//aur first column true hai coz sare array mai empty subset to hota hi hai. empty subset humesha 0 banwa hi deta hai
	    //to mai iske part karunga alag alag, first cell alag, first row alag aur first column alag aur bakika alag
		for( int i= 0; i< dp.length; i++) {
			for( int j=0; j< dp[0].length; j++) {
				if( i == 0 && j == 0) { //agar donobbhi 0 hai means first cell hai, to true
					dp[i][j]= true;
					
				}else if( i == 0) { //bakiki first row mai har jagah hota hai false
					dp[i][j]= false;
					
				}else if( j == 0) { //first column mai har jagah hota hai true
					dp[i][j]= true;
					
				}else {
					//agar aap rest of the spot pe hai, to aap sabse pehle immediately upar dekhte hai
					if( dp[i-1][j] == true) { //agar i-1 tak ki team hi j bana degi to i tak ki team to banahi degi i ko batting nhi denge
						dp[i][j]= true; 
						//hum isme batting hi nhi kr rhe coz upar wala yeh run(j) score krskta hai already
					}else {
						//agar i-1 tak ki team j nhi bana payi tab isko(i) batting karani padegi 
						//but yeh banda(i) jitne runs bana skta hai woh total(j) runs se jada hone chahiye
						int val= arr[i-1]; // yeh banda itne run score krta hai
						if( j >= val) {
							if( dp[i-1][j-val] == true) { //bakike team ne bakike run score kar diye tobhi hum true karenge coz yeh banda khud bhi to val socre karega
								dp[i][j]= true;
							}
						}
					}
					
				}
			}
		}
		System.out.println(dp[arr.length][tar]);
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		
		int tar= s.nextInt();
		targetSumSubset(arr, tar);
	}

}
