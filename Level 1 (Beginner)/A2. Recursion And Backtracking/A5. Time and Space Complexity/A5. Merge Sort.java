Merge Sort

1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using the merge sort.
Input Format
An Integer n 
arr1
arr2..
n integers
Output Format
Check the sample output and question video.

Constraints
1 <= N <= 100000
-10^9 <= arr[i] <= 10^9
Sample Input
5
7 
-2 
4 
1 
3
Sample Output
Merging these two arrays 
left array -> 7 
right array -> -2 
Merging these two arrays 
left array -> -2 7 
right array -> 4 
Merging these two arrays 

Code:

package TimeAnsSpace;

import java.util.Scanner;

public class mergeSort {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int[] mergeSort( int arr[], int lo, int hi) {
		if( lo == hi) { //jab ek hi element reh jaye, low bhi wahi hai and high bhi so 1 size ka array banayenge
			int ba[]= new int[1]; // aur iss array ke 0th index mai lo or hi dal denge
			ba[0]= arr[lo];
			return ba; //aur return kar denge base array
		}
		
		int mid= ( lo + hi)/2;
		
		//hum pehle half ko sort karenge
		 int fsh[]= mergeSort(arr, lo, mid); //yahase muje first sorted half milega(fsh)
		 int ssh[]= mergeSort(arr, mid+1, hi); // second sorted half
		 
		 //ab mere pas dono sorted arrays hai to dono ko merge kr denge
		 int fsa[]= mergeTwoSortedArrays(fsh, ssh);
		return fsa;
		
	}
        
	public static int[] mergeTwoSortedArrays(int a[], int b[]) {
		
		int res[]= new int[a.length + b.length];
		
		//3 pointers banayege
		int i=0;
		int j=0;
		int k=0;
		
		while( i < a.length && j < b.length) { // i and j dono bache hue hai dono array ke end tak pahuche nhi hai
			// dono mese jo chota hoga usko use karenge
			if( a[i] < b[j]){
				res[k]= a[i];
				i++; //i ko use kiya hai so i++
				k++; // and k har bar ++ hota hai
			}else { // agar arr2[j] chota hai to usko use karenge
				res[k]= b[j];
				j++;
				k++;
			}
		} // aisa krte krte i and j apne end tak pahuch jayega, dono array mese ek bhi array khatam hogya to yeh loop khatam hojayega
		
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

		int arr[]= takeInput();
		int low= 0;
		int high= arr.length-1;
		mergeSort(arr, low, high);
	}

}
