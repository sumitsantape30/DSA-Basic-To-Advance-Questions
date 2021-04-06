Quick Sort

1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using quick-sort.
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
pivot -> 3
Swapping -2 and 7
Swapping 1 and 7
Swapping 3 and 4
pivot index -> 2
pivot -> 1
Swapping -2 and -2
  
Code:
package TimeAnsSpace;

import java.util.Scanner;

public class QuickSelect {
	
	public static int quickSelect(int arr[], int lo, int hi, int k) {
		
		//sbase bade(hi) element ko pivot rakh lenge
		int pivot= arr[hi];
		
		// ab mai partiotion function ko call karke pivot index mangaunga
		int pi= partition(arr, pivot, lo, hi);
		
		//ab hume pivot ka index mil gya ab hum ise k sath compare karke decision lenge
		if( k > pi) { // agar k pivot ke index se bda hai, matlab usko jada bda element chahiye matlab hume right side jana padga
			return quickSelect(arr, pi + 1, hi, k);
		
		}else if( k < pi) { // yafir k pivot index se chota hai
			return quickSelect(arr, lo, pi-1, k);
			
		}else { // yafir k pivot index ke barabr hai
			return arr[pi];
		}
	}
	
	public static int partition(int arr[], int pivot, int lo, int hi) {

		int i = lo;
		int j = lo;

		while (i < arr.length) {
			if (arr[i] > pivot) {
				i++;
			} else {
				swap(arr, i, j);
				i++;
				j++;
			}
		}
		return (j-1);
	}

	public static void swap(int[] arr, int i, int j) {
		System.out.println("Swapping " + arr[i] + " and " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int arr[]= takeInput();
		int k= s.nextInt();
		quickSelect(arr, 0, arr.length-1, k-1); //hum jo bhi k de rhe hai humne yahipe k-1 mai convert kardliya
		
	}

}
