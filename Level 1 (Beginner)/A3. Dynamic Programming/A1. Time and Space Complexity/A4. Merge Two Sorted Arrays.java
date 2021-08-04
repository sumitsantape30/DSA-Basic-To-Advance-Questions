Merge Two Sorted Arrays

1. You are given two sorted arrays(a,b) of integers.
2. You have to merge them and form one sorted array.
3. You have to do it in linear time complexity.
Input Format
An Integer n 
a1
a2..n integers
An integer m
b1
b2..m integers
Output Format
Check the sample output and question video.

Constraints
1 <= N <= 10^8
-10^9 <= a[i],b[i] <= 10^9
Sample Input
4
-2 
5 
9 
11
3
4 
6 
8
Sample Output
-2
4
5
6
8
9
11
  
Code:

package TimeAnsSpace;

import java.util.Scanner;

public class mergeTwoSortedArrays {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int[] mergeTwoSortedArrays(int a[], int b[]) {
		
		int res[]= new int[a.length + b.length];
		
		//3 pointers banayege
		int i=0;
		int j=0;
		int k=0;
		
		//jabtak i and j range mai hote hai tabtak dono ko compare krte hue faisla lo
		while( i < a.length && j < b.length) { // i and j dono bache hue hai dono array ke end tak pahuche nhi hai
			// dono mese jo chota hoga usko use karenge
			if( a[i] < b[j]){
				res[k]= a[i];
				i++; //i ko use kiya hai so i++
				k++; // and k har bar ++ hota hai
			}else { // agar arr2[j] chota hai or equal hai to usko use karenge
				res[k]= b[j];
				j++;
				k++;
			}
		} // aisa krte krte i and j apne end tak pahuch jayega, dono array mese ek bhi array khatam hogya to yeh loop khatam hojayega
		
		//niche dono bhi while loop se bad ek hi run hoga, jo abhibhi bacha hua hai woh chalega
		// but agar dono mese jo array abhibhi bacha hai usko bina compare kiye dal denge
		while( i < a.length) {
			res[k]= a[i];
			i++;
			k++;
		}
		
		while( j < b.length) {
			res[k]= b[j];
			j++;
			k++;
		}
		return res;
	}

	public static void main(String[] args) {

		int arr1[]= takeInput();
		int arr2[]= takeInput();
		int arr[]= mergeTwoSortedArrays(arr1, arr2);
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

