Subsets Of Array

1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to print all subsets of arr. Each subset should be
on separate line. For more clarity check out sample input and output.
Input Format
A number n
n1
n2
.. n number of elements
Output Format
[Tab separated elements of subset]
..
All subsets

Constraints
1 <= n <= 10
0 <= n1, n2, .. n elements <= 10^3
Sample Input
3
10
20
30
Sample Output
-	-	-	
-	-	30	
-	20	-	
-	20	30	
10	-	-	
10	-	30	
10	20	-	
  
Code:

package FunctionsAndArrays;

import java.util.Scanner;

public class subsetOfArray {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		
		return arr;
	}
	
	public static void subset( int arr[]) {
		
		int limit= (int)Math.pow(2, arr.length); // kitne subsets honge means kahatk loop chalega: 2^n
	
		for( int i=0; i< limit; i++) { // 8 subsets honga to uske liye 0 se 7 tak loop chalta hai
			String set= "";
			
			//i ko temp mai le lenge coz niche i=i/2 karunga to pura i hi change hojayega aur loop mai gadbad hojayegi
			int temp= i;
			
			//convert i to binary and use 0's and 1's to know if to print the element or not
			// so hume remainders binary nikalne mai help krte hai, muje mere i ko 2 se divide karna hoga bar bar
			//hum binary mai convert karne ke bad niche se means ulte numbers print krte hai so yeh loop ulta chalao
			for( int j= arr.length -1 ; j>= 0; j--) { //jitne array mai elements hai utin bar hum divide karenge
				int r=  temp %2 ;// remainder
				temp= temp /2; //temp ko chota kardenge
				
				//agar remainder 0 hai to muje element ko print nhi karna warna muje element ko print karna hai
				if( r == 0) {
					set= "-\t"+ set; //agar yeh 0 aya hai to iss number ke nam ka dash hum apn set mai add karlenge
				}else {
					//aur agar yeh 1 aya hai to hum arr[j] ko apne set mai add karle
					set= arr[j]+ "\t" + set;
				}
			}
			
			System.out.print(set);
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		subset(arr);
	}

}

