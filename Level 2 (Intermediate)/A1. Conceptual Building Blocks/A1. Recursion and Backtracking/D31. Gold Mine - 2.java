Gold Mine - 2

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are allowed to take one step left, right, up or down from your current position.
5. You can't visit a cell with 0 gold and the same cell more than once. 
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine if 
     you start and stop collecting gold from any position in the grid that has some gold.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number n
A number m
e11
e12..
e12
e22..
m*n numbers
Output Format
Maximum gold collected

  COMMENTConstraints
1 <= n <= 10
1 <= m <= 10
0 <= e1, e2, .. n * m elements <= 1000
Sample Input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
Sample Output
120

Code:

import java.io.*;
import java.util.*;

public class Main {
    
	static int max = 0; // is max mai ek complete component ka rahega
	
	public static void travelAndCollectGold( int arr[][], int i, int j, boolean[][] visited, ArrayList<Integer> bag){
	    // muje dhyan rakhna hoga ki mai visited ko collect na karu aur mai board ke kahi bahar to nhi aagya, yafir aise jagah aaye ho jaha 0 pda hai to return karna hoga
	    if( i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0 || visited[i][j] == true){
	        return;
	    }
	    
	    //sabse pehle aatehi spot ko visit krde aur bag mai dal denge
	    visited[i][j] = true;
	    bag.add(arr[i][j]);
	    //ab iske neighbours ke pas jana hoga, north east west sount iske neighbours hai.
	    travelAndCollectGold(arr, i - 1, j, visited, bag);
	    travelAndCollectGold(arr, i, j + 1, visited, bag);
	    travelAndCollectGold(arr, i, j - 1, visited, bag);
	    travelAndCollectGold(arr, i + 1, j, visited, bag);

	}
	
	public static void getMaxGold(int[][] arr){
	    
	    //jo cell visit hogye hai uspe dubara nhi jana
	    boolean visited[][] = new boolean[arr.length][arr[0].length];
	    
	    //hum kisi bhi cell se start kr skte hai
	    for( int i=0; i< arr.length; i++){ // so mai loop lagaunga aur sare cells ko mauka dunga start point banne ka, travel krne ke start point banne ka, travel and collect gold
	        for( int j=0; j< arr[i].length; j++){
	            
	            if( arr[i][j] != 0 && visited[i][j] == false){ // starting point pe 0 nhi hona chahiye aur yeh jagah already visited nhi honi chahiye
	              ArrayList<Integer> bag = new ArrayList<>(); // iss bag mai gold bharenge
	              travelAndCollectGold(arr, i, j, visited, bag); // yeh sare gold collect karke jis jis rasta jeyega wahase gold collect krke bag mai dal dega isliye bag bhi pass kr rhe hai 
	              
	              //isbar kitne gold collect hua hai woh bag mai loop lagake nikalunga
	              int sum = 0;
	              for(int val: bag){
	                  sum += val;
	              }
	              
	              if( sum > max){ // agar yeh sum max se bada hai to hum max ko update krdenge
	                  max = sum;
	              }
	            }
	        }
	    }
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}
		
}
