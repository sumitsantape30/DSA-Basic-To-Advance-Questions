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
Swapping 1 and 1
pivot index -> 1
pivot -> -2
Swapping -2 and -2
pivot index -> 0
pivot -> 4
Swapping 4 and 7
pivot index -> 3
pivot -> 7
Swapping 7 and 7
pivot index -> 4
-2 1 3 4 7 

Code:

package TimeAnsSpace;

import java.util.Scanner;

public class QuickSort {
	
	public static void quickSort(int arr[], int lo, int hi) {
		if( lo >= hi) { //jab apne pas ek element bache or jab koi element nhi bacha ho means jal lo grater than hi hojaye means cross kar jaye
			return;
		}
		
		//hum akhri element ko pivot ke rup mai pass karenge
		int pivot= arr[hi];
		int pi= partition(arr, pivot, lo, hi); // low se leke hi tak jitne bhi elements hai unmese pivot se jo chote hai unko left mai karde and pivot se jo bade hai unko right mai karde, aur aisa karne ke bad yeh muje btayega ki pivot kaha pda hai
		//so iss parition ke bad pivot apni sahi position pe aagya hoga so muje bas pivot ke left and right kohi sort karna hai
		// pivot index muje aage call lagane mai help karega
		
		//so ab ek side small and ek side bade elements hai
		// so jahapr smaller values hai uss half pe call lagayenge
		quickSort(arr, lo, pi-1); // low se lekar pivot index-1 tak sort kardo, aur maine faith rakha ki woh sort hokar ayenge
		
		//ab mai bade elements ko bolunga ki aap sort hokar aaiye
		quickSort(arr, pivot+1, hi);
		
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
		return (j-1); // pura operation complete hojane kebad, i arr.length pe pohoch jane ke bad mera j pivot ke ek step aage hoga means mera pivot j-1 iss position pe hai
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

		int arr[]= takeInput();
		quickSort(arr, 0, arr.length-1);
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
