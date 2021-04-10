Pivot In Sorted And Rotated Array

1. You are given an array(arr) of distinct integers, which is sorted and rotated around an unknown point.
2. You have to find the smallest element in O(logN) time-complexity
Input Format
An Integer N 
arr1
arr2..
n integers
Output Format
The smallest element

Constraints
1 <= N <= 10000
-10^9 <= arr[i] <= 10^9
Sample Input
9
15
16
19
21
23
24
1
2
12
Sample Output
1

Code:

package TimeAnsSpace;

import java.util.Scanner;

public class PivotofSortedRotatedArray {

	// binary search types hai
	public static int findPivot(int[] arr) {

		//ek low banayenge
		int lo = 0 ;
		int hi = arr.length-1;
		
		while( lo < hi) { // jabtak lo less than hi hai, equal to nhi less than tak hi chala rhe hai hum, coz agar lo hi ke barabr hai to aur kuch karne keliye hai nhi. means assume ek array hai jisme ek hi elements hai to uska lo and hi equal hi hoga to usme kuch nhi karna hota coz wahi elements pivot hai so kam se kam 2 elements ho tabhi yeh question valid hota hai tabhi pivot nikal skte hai
			int mid= (lo + hi)/2;
			if(arr[mid] < arr[hi]) { // agar array of mid chota hai array of i se means mid se high ke taraf value badh rhi hai to first half mai pivot belong karega means hum hi ko uthakr mid pe rakh denge
				hi = mid;
				//ab hum first half mai low se mid means hi wale area mai dhund rhe hai
			}else { // if( arr[mid] > arr[hi]) so agar humara mid hi se bda hai to second half mai pivot hota hai mid+1 se hi ke bich mai.
				lo= mid + 1; 
			}
			
		}
		
		//jab bahar agye hai to lo and mid sab equal ho chuka hai so ab aap arr[hi] or arr[lo] kuch bhi return kr skte hai
		return arr[lo];
	}

	  public static void main(String[] args) throws Exception {
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++) {
	      arr[i] = scn.nextInt();
	    }
	    int pivot = findPivot(arr);
	    System.out.println(pivot);
	  }

}
