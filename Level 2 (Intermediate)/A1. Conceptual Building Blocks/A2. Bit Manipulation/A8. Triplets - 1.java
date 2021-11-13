Triplets - 1

1. You are given an array(arr) of N numbers.
2. You have to select three indices i,j,k following this condition -> 
      0 <= i < j <= k < arr.length
3. Two numbers X and Y as defined as :
      X = arr[i] ^ arr[i+1] ^ ... ^ arr[j - 1]
      Y = arr[j] ^ arr[j+1] ^ ... ^ arr[k]
4. You have to print the number of triplets where X is equal to Y.
Input Format
A number N
arr1
arr2..
n numbers
Output Format
Check the sample ouput and question video.

Constraints
1 <= N <= 1000
0 <= arr[i] <= 10^9
Sample Input
3
1 2 3
Sample Output
2

Code:

import java.io.*;
import java.util.*;

public class Main {

	public static void solution(int[] arr){
		int c= 0; // count = 0
		
		for( int i=0; i< arr.length; i++){ // maine bahar lagaya i ka loop
		    int val = arr[i]; // val ko arr[i] se initialise kardiya
		    
		   for( int k= i +1 ; k < arr.length; k++){ // k ko strictly grater se start kiya
		       val = val ^ arr[k];
		       
		       if( val == 0){ // ab agar val 0 ata hai , means i se leke k tak ka XOR aagya 
		           c += (k - i); //i to k ke bichme total (k-i) triplets hote hai so usko count mai add karlo
		       }
		   }
		    
		}
		System.out.println(c);
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
                int[] arr = new int[n];
                for(int i = 0 ; i < arr.length; i++){
                   arr[i] = scn.nextInt();
                }
               solution(arr);
    }	
}
