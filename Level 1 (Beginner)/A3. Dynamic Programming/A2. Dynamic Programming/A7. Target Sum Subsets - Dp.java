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
	
	//recursive
	public static boolean  tss( int arr[], int idx, int target) { // index pass karenge ki iss current index faisla aap kr rhe ho
		if( target == 0) { //agar target kahipe bhi 0 ho jata hai means hume subset mil gya to return true
			return true;
		}
		
		if( idx >= arr.length || target < 0) {
			return false;
		}
		
		boolean f1= tss(arr, idx+1, target); //current element nhi ana chahta, woh bol rha hai kya indx+1 se aage wale elements kya taret bana payenge
		boolean f2= tss(arr, idx+1, target- arr[idx] ) ; //mai to ana chahta hu, aur kya idx+1 se aage wale elements kya tum updated target bana paoge, updated target will be, target- value of current index
		
		boolean ans= f1 || f2 ; //donomese ek bhi true hai to return true
		return ans;
		
	}
	
	//memoization: kitni size ki array? recursive mai index aur target dono vary kr rhe hai so ek dimension index ko sambhalega aur dusra dimension target ko sambhalega
	// so 2D storage banegi, Boolean wala array pass karna coz isme by default null pda hua hota hai, aur boolean wale array mai by default false hota hai and kisika jawab true or false aata hai so muje pta nhi chalega ki yeh by default wala false hai ya mera answer wala false hai so Boolean wala mai dekh skte ki not null rha means calculated hai
	//Boolean dp[][]= new dp[n][target+1] ; kitne size ka? vertical mai index rakhenge aur horizontal size "target" rakhenge so kitne size ka banega? n+1 aur target+1, n size ka bhi row le skte ho  
	//2 chize vary kr rhi thi, index aur target. index 0 se array.length-1 tak vary karega so 0 to n-1 'n' bande hote hai isliye vertical wale ko n size ka banaya, dusra vary karega 0 to target tak let's say 0 to 19 tak, 0 to 19 '20' bande honge isliye target+1 ka banaya
	public static boolean tssM( int arr[], int idx, int target, Boolean dp[][]) { 
		if( target == 0) {
			return true;
		}
		
		if( idx >= arr.length || target < 0) { //target -ve hogya to out of bound ajayega so woh basecace bhi dalo
			return false;
		}
		
		if( dp[idx][target] != null) { //agar woh null nhi hai means calculated hai
			return dp[idx][target];
		}
		
		boolean f1= tss(arr, idx+1, target); 
		boolean f2= tss(arr, idx+1, target- arr[idx] ) ; 
		boolean ans= f1 || f2 ; 
		
		dp[idx][target]= ans;
		return ans;
		
	}
	
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
