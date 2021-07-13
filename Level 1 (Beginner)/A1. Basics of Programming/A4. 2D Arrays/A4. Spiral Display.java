Spiral Display

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a.
4. You are required to traverse and print the contents of the 2d array in form of a spiral.
Note - Please check the sample output for details.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
e11
e21
..
en1
en2
en3
..
enm
e(n-1)m
..
e1m
e1(m-1)
..
e12
e22
e32
..

Constraints
1 <= n <= 10^2
1 <= m <= 10^2
-10^9 <= e1, e2, .. n * m elements <= 10^9
Sample Input
3
5
11
12
13
14
15
21
22
23
24
25
31
32
33
34
35
Sample Output
11
21
31
32
33
34
35

Code:

import java.util.Scanner;

public class SpiralTraversal {
	
	public static int[][] takeInput(){
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the number of row");
		int row= s.nextInt();
		System.out.println("Enter the number of column");
		int column =s.nextInt();
		int arr[][]= new int[row][column];
		for( int i=0; i< arr.length; i++) {
			for( int j= 0; j< arr[0].length; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		return arr;
	}
	
	public static void spiralMatrix( int arr[][]) {
		
		//4 variable define karenge, minimum row and column aur maximum row and column
		int minr= 0;
		int minc= 0;
		int maxr= arr.length;
		int maxc= arr[0].length;
		// inn char variable se mai box define kar rha hu sabse outer box
		
		//jitne total elements hai utna hi chalenge
		int tne= arr.length* arr[0].length;
		int cnt=0; //harbar print karte hi mai count ko bdhaunga
		
		while( cnt < tne) { //while the boxes are there, mai har box print hone ke bad cnt badha rha hu so woh jabtak less rahega total elements se.
			//ab mai ek ek wall print karunga
			
			//left wall
			//left wall keliye column humara min column hi rahe galekin hum min row se max row ke taraf travel kar rhe hai tabhi humara print hoga
			for( int i= minr, j= minc; i< maxr && cnt < tne; i++) { //min row se max row tak gya, and J min column hi rahega isliye woh bhi loop mai dal diye
				System.out.println(arr[i][j]); //mera bas row vary ho rha tha and column wahi tha
				cnt++;
			}
			//left wall hote hi hum min column ko ++ kar denge
			minc++; //isliye ++ kiye taki agla box aage se start ho so that corner repeat hone se bache
			
			//bottom wall
			//left wall print hone ke bad hume bottom wall print karni hai but agar bottom wall puri print kardi from min column to max column to corner wala element do br hojayega
			for( int j= minc, i= maxr; j<= maxc && cnt < tne; j++) { //bottom mai row max row pe fix rehti hai
				System.out.println(arr[i][minr]);
				cnt++; 
			}
			maxr--;
			
			// right wall, yahape i bhi max row pe hoga and j bhi max column pe hoga, i vary karega from max row se min row ke taraf
			for( int i= maxr, j= maxc ; i >= minr && cnt< tne; i--) { 
				System.out.println(arr[i][j]);
				cnt++;
			}
			maxc--;
			
			
			// top wall, isme column vary kr rhe hai max column se min column ke taraf aur i min row pe fixed hai 
			for( int i= minr, j= maxc; j>= minc && cnt < tne; j--) {
				System.out.println(arr[i][j]);
				cnt++;
			}
			minr++; //isliye ++ kiye taki agla box aage se start ho so that corner repeat hone se bache
			
		}
		
		
	}

	public static void main(String[] args) {

		int arr[][]= takeInput();
		spiralMatrix(arr);
	}
}

