Search In A Sorted 2d Array

1. You are given a number n, representing the number of rows and columns of a square matrix.
2. You are given n * n numbers, representing elements of 2d array a. 
Note - Each row and column is sorted in increasing order.
3. You are given a number x.
4. You are required to find x in the matrix and print it's location int (row, col) format as discussed in output format below.
5. In case element is not found, print "Not Found".
Input Format
A number n
e11
e12..
e21
e22..
.. n * n number of elements of array a
A number x
Output Format
row
col of the location where element is found or "Not Found" if element is not in the matrix
Question Video

  COMMENTConstraints
1 <= n <= 10^2
-10^9 <= e11, e12, .. n * m elements <= 10^9
All rows and columns are sorted in increasing order
Sample Input
4
11
12
13
14
21
22
23
24
31
32
33
34
41
42
43
44
43
Sample Output
3
2

Code:

package DSA_Cracker;

import java.util.Scanner;

class Pair{
	int first;
	int second;
}

public class searchin2DMatrix {
	
	public static int[][] takeInput(){
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int row= s.nextInt();
		
		System.out.println("Enter the number of column");
		int column= s.nextInt();
		int arr[][]= new int[row][column];
		
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		return arr;
	}
	
	public static boolean search( int arr[][], int target) {
		
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				
				if( arr[i][j] == target) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static Pair search2( int arr[][], int key) {
		
		Pair ans= new Pair();
		int n= arr.length;
		int m= arr[0].length;
		int i=0; //row 0 pe 
		int j= m -1; // column last wale index pe lere
		
		//yeh kam muje tabtak karna hai ? jabtak mai out of bound na chale jau ya to woh element na mil jaye, agar element mil jaye to wahi return kardenge uske index
		//out of bound chala gya means woh key present nhi hai
		while( i >=0 && i < n && j>= 0 && j<m ) { //jabtak yeh bound ke andar hai
			
			// abhi compare karenge ki apn abhi jaha hai woh key ke equal hai to mai return karunga i and j
			if( arr[i][j] == key) {
				ans.first= i;
				ans.second= j;
				return ans;
			}else if( arr[i][j] > key) { //agar aisa hua to uske pas do direction hai left mai ya to down mai ja skte hai
				//agar current wala greater hai key se matlab current ke niche wale sare usse bada hai means woh useless hai so hum right mai jayenge means j-- karenge
				j--;
			
			}else if( arr[i][j] < key) { //agar current element se badi hai key to muje niche jana chahiye means i++ karna hai
				i++;
				
			}
		}
		ans.first= -1;
		ans.second= -1;
		return ans;
	}

	public static void main(String[] args) {

	}

}
