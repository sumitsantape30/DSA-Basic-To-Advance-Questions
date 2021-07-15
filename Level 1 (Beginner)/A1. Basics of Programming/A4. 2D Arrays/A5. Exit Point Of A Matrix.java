Exit Point Of A Matrix

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers (1's and 0's), representing elements of 2d array a.
4. Consider this array a maze and a player enters from top-left corner in east direction.
5. The player moves in the same direction as long as he meets '0'. On seeing a 1, he takes a 90 deg right turn.
6. You are required to print the indices in (row, col) format of the point from where you exit the matrix.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
row
col (of the point of exit)

Constraints
1 <= n <= 10^2
1 <= m <= 10^2
e1, e2, .. n * m elements belongs to the set (0, 1)
Sample Input
4
4
0
0
1
0
1
0
0
0
0
0
0
0
1
0
1
0
Sample Output
1
3

Code:

package TwoDArrays;

import java.util.Scanner;

public class ExitPoint {
	
	public static int[][] takeInput(){
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int m= s.nextInt();
		
		int arr[][]= new int[n][m];
		
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		return arr;
	}
	
	public static void exitPoint( int arr[][]) {
		
		
		//1. dir nam ka variable initialise karenge from 0
		int dir=0; // dir mai 0 stands for e, 1=s, 2=w, 3=n
		// 1 ko south kyu banaye? kyuki east se 90 degree right turn se south ata hai so east se agli direction south hai and 0 se agli value 1 hoti hai and east se agli direction south hoti hai so on
		
		//and woh banda i=0 se and j=0 se entry kr rha hai
		int i=0;
		int j=0;
		
		while( true) {
			//3. yeh hume help karega, agar hum 0 pe aaye to humari direction change nhi hogi
			dir= (dir+ arr[i][j]) % 4; //%4 hume help karega, agar dir 4 hua to modulus se woh 0 hojayega means first east ke taraf
			
			//2. 
			if( dir == 0) { //agar direction 0 hai means banda east mai ja rha hai, east mai ja rha hai to i ko nhi j ko faraq pdta hai
				j++;
			}else if( dir == 1) { //agar direction 1 hai means south to i++
			    i++;	
			}else if( dir == 2) { //agar west ja rha hai to j--
				j--;
			}else if( dir == 3) { //agar dir 3 hai means north ko ja rha hai to i--;
				i--;
			}
			
			//hume exist point chahiye to yeh hume pta chalega bahar aane ke bad, so agar hum matrix ke kahi bahar aagye to break kar denge, yeh hume pta lagega ek step bahar aane ke bad
			//hum dekhenge kya hum bahar aagye kya
			if( i < 0) { //agar i negative hojaye
				i++; //i negative hogya to i++ krke break kare
				break;
			}else if(j < 0) { //ya j negative hojaye
				j++;
				break; 
			}else if(i == arr.length) { //ya humara i row ke length jitna hojaye, last possible value arr.length-1 hoti hai
				i--; //i arr.length hogya to i-- karke break kare, mean i bahar nikal gya hai to i-- karke break kare
				break;
			}else if( j == arr[0].length ) { //ya humara j column ke length jitne hojaye
				j--; // j bahar nikal gya hai to j-- karke break kare
				break;
			}//let's jab hum bahar nikal jayege to i and j ki value hogi 2,-1 but exit point hum 2,-1 nhi print karna chahte hum print karna chahte hai jo aakhri spot humne visit kiya tha to hum 2,0 hi print karenge
		     // so jab hum exist ho chuke hai to ek step wapas leke jayiye aur fir btaye ki yahase exit hua tha 
		}
		//i and j ko print kardenge
		System.out.println(i);
		System.out.println(j);
	}

	public static void main(String[] args) {

		int arr[][]= takeInput();
		exitPoint(arr);
	}

}
