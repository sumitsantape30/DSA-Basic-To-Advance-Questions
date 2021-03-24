Saddle Price

1. You are given a square matrix of size 'n'. You are given n*n elements of the square matrix. 
2. You are required to find the saddle price of the given matrix and print the saddle price. 
3. The saddle price is defined as the least price in the row but the maximum price in the column of the matrix.
Input Format
A number n
e11
e12..
e21
e22..
.. n * n number of elements of array a
Output Format
Saddle point of the matrix if available or "Invalid input" if no saddle point is there.
  
Constraints
1 <= n <= 10^2
-10^9 <= e11, e12, .. n * m elements <= 10^9
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
41

Code:

package TwoDArrays;

import java.util.Scanner;

public class SaddlePoint {
	
	public static int[][] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[][]= new int[n][n];
		
		for(int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		return arr;
	}
	
	public static void saddlePoint( int arr[][]) {
		
		//saari row mai loop lagayenge
		for( int i=0; i< arr.length; i++) {
			// so muje row ka minimum chahiye and uss minimum ko check karna padega ki uss column mai maximum hai ya nhi
			// so mai ek row ke sare column mai loop lagaunga. mai uss column ko identify karna chahte hu jo iss row ka least column hai
			int svj = 0; //smallest value of j= svj. Aisa man lete hai ki iss row ka sabse choti value wala column 0 hai aisa man liya
			for( int j=1; j< arr[0].length; j++) {
				// basically mai iss row ka least value wala column dhundna chahta hu
				if( arr[i][j] < arr[i][svj]) { //agar ith row ke jth column mai ith row ke lci column se choti value hogi to lci will be j
					svj = j;
				}
			}
			
			// iss loop ke bad mere pas iss row ka sabse choti value ka index pda hua hoga ab muje uss column mai check karna hai ki yeh apne column mai max hai ya nhi
			// ab rows vary karengi
			boolean flag= true; // jo point aya hai usko saddle point man ke chal rhe hai
			for( int k=0; k< arr.length; k++) {
				if( arr[k][svj] > arr[i][svj]) { // so agar humare aye hue arr[i][svj] se bada nikla to humne jo chose kiya tha woh saddle point nhi hai
					// to hum flag ko false kar dunga
					flag= false;
				}
			}
			
			//agar hum bahar true leke pahuchte means humse koi bda nhi nikla  so print karke program terminate kar denge
			if( flag == true) { 
				System.out.println(arr[i][svj]);
				return;
			}
		}
		
		//agar hum iss loop ke bahar aaye to hum invalid print karte hai ki nhi dhund paye
		System.out.println("Invalid Input");
	}

	public static void main(String[] args) {
		
		int arr[][]= takeInput();
		saddlePoint(arr);
		
	}

}

