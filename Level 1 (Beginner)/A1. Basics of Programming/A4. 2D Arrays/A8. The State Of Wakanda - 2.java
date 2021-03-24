The State Of Wakanda - 2

The historic state of Wakanda has various monuments and souveniers which are visited by many travellers every day. The guides follow a prescribed route of visiting the monuments which improves them understand the relevance of each monument. The route of the monument is fixed and expressed in a 2-d matrix where the travellers visit the prescribed next monument. For example
1  2  3
4  5  6
7  8  9
is the prescribed route and the visitors travels this path: 1->2->3->4->5->6->7->8->9
However, a certain visitor decides to travel a different path as follows:
1. The visitor only plans to visit the upper diagonal triangle of the monument list.
2. The visitor travels diagonally till there are no more moves left in the current journey. 
3. He then visits the adjacent monument to the first monument of current diagonal journey. 
4. He continues the same path till all the monuments of the upper half have been travelled.
For Example:
The monuments are named as:
1    2    3    4
5    6    7    8
9   10  11  12
13 14  15  16
The path followed by the visitor is: 1->6->11->16->2->7->12->3->8->4
You are required to print the path followed by the traveller to visit all the monuments.
Refer to the photo for a better clarification.
1. You are given a number n, representing the number of rows and columns of a square matrix.
2. You are given n * n numbers, representing elements of 2d array a.
3. You are required to diagonally traverse the upper half of the matrix and print the contents.
For details check image.

diagonal-traversal
Input Format
A number n
e11
e12..
e21
e22..
.. n * n number of elements of array a
Output Format
Diagonal traversal as in image below

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
11
22
33
44
12
23
34

Code:

package TwoDArrays;

import java.util.Scanner;

public class DiagonalTraversal {
	
	public static int[][] takeInput(){
		
		Scanner s= new Scanner(System.in);
		// matrix square hai so rows and column alag alag input lene ki jarurat nhi hai
		int n= s.nextInt();
		
		
		int arr[][]= new int[n][n];
		
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length ; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		return arr;
	}

	public static void diagonal(int arr[][]) {
		
		// hum 0 gap wala diagonal then 1 gap wala then 2 gap wala then 3 gap wala diagonal print karenge
		for( int g= 0; g < arr.length; g++) { //jitni row hai utne hi gap ho skti hai isliye g< arr.length
			
			//ab muje koi bhi gap wala print karna hai let's say 2 gap wala print karna hai, humara koi bhi diagonal i ki 0 value ke sath start ho rha hai, agar 2 gap wale kibhi bat kare to woh diagonal i ki value 0 se start ho rha hai and j ki value utni hoti hai jitna gap hota hai
			// so agar i=0 se start ho rha hai to j gap value se start hoga. Har diagonal ki shuruwat i ki 0 value se hoti hai aur j hota hai gap ke barabr
			for( int i=0, j= g; j< arr.length; i++,j++) { //i ko humesha 0 se start karenge and j ko gap se start karenge and i and j ek se badhta rahega harbar, regarding condition *open book* for explanation
				System.out.println(arr[i][j]);
			}
		}
	}
	
	public static void main(String[] args) {

		int arr[][]= takeInput();
		diagonal(arr);
	}
}
