Problem statement: Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order. 
  Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.
  
Example 1:

Input: 
n = 4, arr1[] = [1 4 8 10] 
m = 5, arr2[] = [2 3 9]

Output: 
arr1[] = [1 2 3 4]
arr2[] = [8 9 10]

Explanation:
After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.

Example2:

Input: 
n = 4, arr1[] = [1 3 5 7] 
m = 5, arr2[] = [0 2 6 8 9]

Output: 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]

Explanation:
After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.
  
Code:

//========================== Brute Force=========================
package Arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class setMatrixZeroes {
	
	public static void mergeArrays( int arr1[], int arr2[]) {
		
		int ans[]= new int[arr1.length + arr2.length];
		int idx= 0;
		
		for( int i=0; i< arr1.length; i++) {
			ans[idx]= arr1[i];
			idx++;
		}
		
		for( int i=0; i< arr2.length; i++) {
			ans[idx] = arr2[i];
			idx++;
		}
		
		Arrays.sort(ans);
		idx= 0;
		
		for( int i=0; i< arr1.length; i++) {
			arr1[i] = ans[idx];
			idx++;
		}
		
		for( int j=0; j< arr2.length; j++) {
			arr2[j] = ans[idx];
			idx++;
		}
		
		for( int i=0; i< arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		for( int j=0; j < arr2.length; j++) {
			System.out.print(arr2[j]+" ");
		}
		
	}

	public static void main(String[] args) {
		int arr1[]= {1, 4, 8, 10};
		int arr2[]= {2, 3, 9};
		mergeArrays(arr1, arr2);
		
	}

}

//============================================== my code=========================

package Arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class setMatrixZeroes {

	// brute force
	public static void mergeArrays(int arr1[], int arr2[]) {

		int ans[] = new int[arr1.length + arr2.length];
		int idx = 0;

		for (int i = 0; i < arr1.length; i++) {
			ans[idx] = arr1[i];
			idx++;
		}

		for (int i = 0; i < arr2.length; i++) {
			ans[idx] = arr2[i];
			idx++;
		}

		Arrays.sort(ans);
		idx = 0;

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = ans[idx];
			idx++;
		}

		for (int j = 0; j < arr2.length; j++) {
			arr2[j] = ans[idx];
			idx++;
		}

		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for (int j = 0; j < arr2.length; j++) {
			System.out.print(arr2[j] + " ");
		}

	}

	// optimised
	public static void mergeTwoSorted(int arr1[], int arr2[]) {

		for (int i = 0; i < arr1.length; i++) {

			if (arr1[i] > arr2[0]) {
				int temp = arr1[i];
				arr1[i] = arr2[0];
				arr2[0] = temp;
			}
			Arrays.sort(arr2); // can use insertion sort here
		}

		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}

		System.out.println();

		for (int j = 0; j < arr2.length; j++) {
			System.out.print(arr2[j] + " ");
		}

	}

	// most optimised- gap method
	public static void mergeTwoSorted2(int arr1[], int arr2[]) {
		int n = arr1.length;
		int m = arr2.length;
		int gap = (int) Math.ceil((double) (n + m) / 2.0);

		while(gap > 0) {

			int i = 0;
			int j = gap;

			while (j < (m + n)) {

				if (j < n  && arr1[i] > arr1[j]) {
					swap(arr1[i], arr1[j]);
				} else if (j >= n && i < n && arr1[i] > arr2[j - n]) {
					swap(arr1[i], arr2[j - n]);
				} else if (j >= n && i >= n && arr2[i - n] > arr2[j - n]) {
					swap(arr2[i - n], arr2[j - n]);
				}
				i++;
				j++;
			}
			if (gap == 1) {
				gap = 0;
			} else {
				gap = (int) Math.ceil((double) gap / 2.0);
			}
		}
	}

	public static void swap(int a,int b)
	    {
	        int temp=a;
	        a=b;
	        b=temp;
	    }
	
	public static void merge(int ar1[], int ar2[], int n, int m) {
		  // code here 
		  int gap =(int) Math.ceil((double)(n + m) / 2.0);
		  while (gap > 0) {
		    int i = 0;
		    int j = gap;
		    while (j < (n + m)) {
		      if (j < n && ar1[i] > ar1[j]) {
		        swap(ar1[i], ar1[j]);
		      } else if (j >= n && i < n && ar1[i] > ar2[j - n]) {
		        swap(ar1[i], ar2[j - n]);
		      } else if (j >= n && i >= n && ar2[i - n] > ar2[j - n]) {
		        swap(ar2[i - n], ar2[j - n]);
		      }
		      j++;
		      i++;
		    }
		    if (gap == 1) {
		      gap = 0;
		    } else {
		      gap =(int) Math.ceil((double) gap / 2.0);
		    }
		  }
	}

	public static void main(String[] args) {
		int arr1[] = { 1, 4, 7, 8, 10 };
		int arr2[] = { 2, 3, 9 };
		merge(arr1, arr2, 5, 3);
		
		System.out.println("After merge:");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}

	}

}

if (j < n && arr1[i] > arr1[j]): This condition checks if the variable j is less than n (where n is the size of the array arr1). 
It also verifies whether the element at index i in arr1 is greater than the element at index j in arr1. If both conditions are true, 
the code executes the swap operation between arr1[i] and arr1[j]. This means that if the current element at index i in arr1 is greater than 
the element at index j, it swaps the positions of these two elements to maintain a non-decreasing order in arr1.

else if (j >= n && i < n && arr1[i] > arr2[j - n]): This condition checks if j is greater than or equal to n (indicating we have moved beyond 
the elements of arr1) and if i is less than n (indicating we are still within the elements of arr1). 
Additionally, it verifies whether the element at index i in arr1 is greater than the element at index j - n in arr2 (since we have moved to 
the elements of arr2). If all these conditions are true, the code executes the swap operation between arr1[i] and arr2[j - n]. This means that if the current element at index i in arr1 is greater than the element at index j - n in arr2, it swaps the positions of these two elements to maintain a non-decreasing order in both arrays.

else if (j >= n && i >= n && arr2[i - n] > arr2[j - n]): This condition checks if both j and i are greater than or equal to n 
(indicating we are within the elements of arr2). It also verifies whether the element at index i - n in arr2 (to access elements of arr2 
correctly) is greater than the element at index j - n in arr2. If both conditions are true, the code executes the swap operation between 
arr2[i - n] and arr2[j - n]. This means that if the current element at index i - n in arr2 is greater than the element at index j - n in arr2, 
it swaps the positions of these two elements to maintain a non-decreasing order in arr2.
