Rotate By 90 Degree

1. You are given a number n, representing the number of rows and number of columns.
2. You are given n*n numbers, representing elements of 2d array a.
3. You are required to rotate the matrix by 90 degree clockwise and then display the contents using display function.
*Note - you are required to do it in-place i.e. no extra space should be used to achieve it .*
Input Format
A number n
e11
e12..
e21
e22..
.. n * n number of elements
Output Format
output is taken care of by display function
Question Video

Constraints
1 <= n <= 10^2
-10^9 <= e1, e2, .. n * n elements <= 10^9
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
Sample Output
41 31 21 11
42 32 22 12
43 33 23 13
44 34 24 14

Code:

package DSA_Cracker;

import java.util.Scanner;

public class RotateMatrix {
	
	public static int[][] takeInput(){
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int arr[][]= new int[n][n];
		
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		return arr;
	}
	
	//ab hum matrix ka transpose lenge, arr[i][j] mai arr[j][i] dalna hota hai
	public static int[][] transpose( int arr[][]){
		
		for( int i=0; i< arr.length; i++) {
			for( int j=i; j< arr[0].length; j++) { //mai bas upper triangle mai move karunga  isliye j=i kiya taki triangularly move ho. j wala first loop 0 start hoga then next time j 1 se start hoga
				int temp= arr[i][j]; // upper triangle ko niche wale ke sath swap karenge
				arr[i][j]= arr[j][i];
				arr[j][i]= temp;
			}
		}
		return arr;
	}
	
	//transpose hogya ab row by row saari line ko reverse karenge
	//saari row ko reverse karenge jisse first column last column ban jaye
	public static int[][] rowbyrowRev( int arr[][]){
		
		for( int i=0; i< arr.length; i++) {
			int li=0; //left index
			int ri= arr[i].length-1; //right index
			
			while( li > ri) {
				//values swap karte jayenge
				int temp= arr[i][li];
				arr[i][li]= arr[i][ri];
				arr[i][ri]= temp;
				li++;
				ri--;
			}
		}
		return arr;
	}
	
	public static void print( int arr[][]) {
		
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}

	public static void main(String[] args) {

		int arr[][]= takeInput();
		int ans[][]= transpose(arr);
		print(ans);
	}

}
