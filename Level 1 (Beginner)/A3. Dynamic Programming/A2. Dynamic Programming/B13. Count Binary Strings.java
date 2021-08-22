Count Binary Strings

1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.
	
Input Format
A number n
Output Format
A number representing the number of binary strings of length n with no consecutive 0's.
Question Video

  COMMENTConstraints
0 < n <= 45
Sample Input
6
Sample Output
21

Code:

package DP;

import java.util.Scanner;

public class CountBinaryStrings {
	
	//recursive
	public static int cbs(int n) { // expectation: yeh n length ki binary string lake dega jisme consecutive 0s nhi honge ye meri iss function se expectation hai
		if( n == 1){
			return 2;
		}
		
		if( n == 2) {
			return 3;
		}
		
		//faith: mai isko bolunga n-1 length ki valid binary strings lade
		int f1= cbs(n-1);
		//jo mera answer ayega unke last mai simply 1 append hojayega aur n ka answer ban jayega
		
		int f2= cbs(n-2);
		// iske last mai mai 10 append kardunga, isse 2 consecutive 0s nhi ayenge
		
		int ans= f1 + f2 ;
		//so kya append karna chahiye yahi dekhna tha taki consecutive 0s na aaye
		
		return ans;
		// yeh fibonacci ki variation ban gyi
		
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int dp1[]= new int[n+1]; // n+1 size ki banayenge coz aakhri index n hona chahiye, aur isme ending at 0 ka count store karenge
		int dp2[]= new int[n+1]; // ending at 1 ka count store karunga
		
		dp1[0]=1; // 1 length ka answer 1 hi hoga
		dp2[0]= 1; 
		
		for( int i=2; i< dp1.length; i++) {
			dp1[i] = dp2[i-1]; // ending at 0's pe, pehli wali string ka ending at 1's ka count
			dp2[i]= dp1[i-1] + dp2[i-1] ;// i length ki string, ending at 1 chahiye, i-1 length ki string 0 and 1 pebhi end ho skti hai so dono ke addition
			
		}
		
		System.out.println(dp1[n]+" "+dp2[n]);
		
	}

}

//===============================SS's Mthd================

package DP;

import java.util.Scanner;

public class CountBinaryStringss {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
/*		int dp0[]= new int[n+1]; // dp array jo 0's ka count rakhega
		int dp1[]= new int[n+1];
		
		dp0[1]= 1 ; //dp[0] pe 0 bhi rakh skte ho
		dp1[1]= 1;
		
		for( int i=2; i<=n; i++) {
			dp1[i]= dp0[i-1] + dp1[i-2]; // 1 wale mai pichli stage ka 1 bhi use hota hai aur 0 bhi use hota hai
			dp0[i]= dp1[i-1]; //aur issbar ke 0 mai pichli bar ka keval 1 use hota hai
		}
		
		System.out.println(dp1[n]+" "+ dp0[n]);
		
		// yaha hum extra array use kr rhe hai to space jada lagega
		*/
		
		int oczeroes= 1; // shuruwat mai 0s pe khatam hone walo ki count hoti hai 1: oldcountzeroes
		int ocones= 1; //initially 1 pe khatam hone walo ki count hoti hai 1: oldcountones
		
		for( int i=2; i<=n; i++) {
			int nczeros= ocones; //jo new count zeros hai woh pichli bar ke old count ones ban jayenge
			int ncones= oczeroes+ ocones; //jo new count ones honge usme old count zeros bhi ayega aur old count ones bhi ayega
			
			ocones= ncones;
			oczeroes= nczeros;
		}
		
		System.out.println(ocones+oczeroes);
	
	}

}
