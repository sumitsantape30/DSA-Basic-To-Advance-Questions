First Index And Last Index

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.

Asssumption - Array is sorted. Array may have duplicate values.
Input Format
A number n
n1
n2
.. n number of elements
A number d
Output Format
A number representing first index
A number representing last index
Question Video

  COMMENTConstraints
1 <= n <= 1000
1 <= n1, n2, .. n elements <= 100
1 <= d <= 100
Sample Input
15
1
5
10
15
22
33
33
33
33
33
40
42
55
66
77
33
Sample Output
5
9

Code:

package Restart;

import java.util.Scanner;

public class Problems {

	public static int[] takeInput() {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static void firstIndex(int arr[], int ele) {

		int start = 0;
		int end = arr.length - 1;
		int fi = -1;

		while (start <= end) {

			int mid = (start + end) / 2;

			if (arr[mid] == ele) {
				fi = ele; // agar data barbar hai to answer mark kare, coz this may be an answer aur left ko jana na bhule
				end = mid - 1;
			} else if (ele > arr[mid]) {
				start = mid + 1;
			} else if (ele < arr[mid]) {
				end = mid - 1;
			}
		}

		System.out.println(fi);
	}

	public static void lastIndex(int arr[], int ele) {

		int start = 0;
		int end = arr.length - 1;
		int li = -1;

		while (start <= end) {

			int mid = (start + end) / 2;

			if (arr[mid] == ele) {
				li = ele; // agar data barbar hai to answer mark kare, coz this may be an answer aur left ko jana na bhule
				start= mid +1;
			} else if (ele > arr[mid]) {
				start = mid + 1;
			} else if (ele < arr[mid]) {
				end = mid - 1;
			}
		}

		System.out.println(li);
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int arr[] = takeInput();
		int ele= s.nextInt();
		firstIndex(arr, ele);
		lastIndex(arr, ele);

	}
}
