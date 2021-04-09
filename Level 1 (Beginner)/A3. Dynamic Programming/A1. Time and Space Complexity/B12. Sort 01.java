Sort 01
1. You are given an array(arr) containing only 0's and 1's.
2. You have to sort the given array in increasing order and in linear time.
Input Format
An Integer N 
arr1
arr2..
n integers
Output Format
Check the sample output and question video.

Constraints
1 <= N <= 10000
arr[i] = 0,1
Sample Input
5
0
1
0
1
0
Sample Output
Swapping index 0 and index 0
Swapping index 2 and index 1
Swapping index 4 and index 2
0
0
0
1
  
Code:

package TimeAnsSpace;
import java.util.Scanner;

public class Sort01 {
	
	public static void sort01(int[] arr){

		int i=0;
		int j=0;
		
		while( i < arr.length) { //jabtak kuch to unknown hai hum kam karte rahenge
			if( arr[i] == 1) { // agar arr[i] pr mil jata hai 1 to simply i badhega
				i++;
			}else { // means agar 0 pe hai to i and j swap hoga and fir dono badhenge
				swap(arr, i, j);
				i++;
				j++;
			}
		}
	  }

	  // used for swapping ith and jth elements of array
	  public static void swap(int[] arr, int i, int j) {
	    System.out.println("Swapping index " + i + " and index " + j);
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	  }

	  public static void print(int[] arr){
	    for(int i = 0 ; i < arr.length; i++){
	      System.out.println(arr[i]);
	    }
	  }
	  public static void main(String[] args) throws Exception {
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for(int i = 0 ;i < n; i++){
	      arr[i] = scn.nextInt();
	    }
	    sort01(arr);
	    print(arr);
	  }

}
