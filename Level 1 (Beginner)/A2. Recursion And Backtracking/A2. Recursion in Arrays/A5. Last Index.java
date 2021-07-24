Last Index

1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number x. 
4. You are required to find the last index at which x occurs in array a.
5. If x exists in array, print the last index where it is found otherwise print -1.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
n1
n2
.. n number of elements
A number x
Output Format
A number representing last index of occurence of x in array a or -1 if not found at all.

  COMMENTConstraints
1 <= n <= 10^4
0 <= n1, n2, .. n elements <= 10 ^ 3
0 <= x <= 10 ^ 3
Sample Input
6
15
11
40
4
4
9
4
Sample Output
4

Code:

public static int li(int arr[], int idx, int data) {
		if( idx == arr.length) { //index yahape aya means woh exist hi nhi krta
			return -1;
		}
		
		int lism= li(arr, idx+1, data);
		// agar lism -1 nhi aya uska ek hi matlab hai ki data ka last index hume mil chuka hai to wahi return kar denge
		if( lism == -1) {
			if( arr[idx]== data) {
				return idx;
			}else {
				return -1;
			}
		}
		return lism;
	}

public static int li2(int arr[], int idx, int data) { 
		if( idx < 0) {
			return -1;
		}
		
		if( arr[idx] == data) {
			return idx;
		}else {
			
			int li= li2(arr, idx-1, data);
			return li;
		}
		
	}
	
