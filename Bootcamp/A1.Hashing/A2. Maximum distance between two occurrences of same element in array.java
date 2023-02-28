
Code:
package Hashing;

import java.util.*;
import java.io.*;

public class session1_p1 {
	
	public static int maxDistance( int arr[]) {
		
		HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
		int max_Distance = Integer.MIN_VALUE;
		
		for( int i=0; i< arr.length; i++) {
			
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			}else {
				max_Distance = Math.max(max_Distance, i - map.get(arr[i]));
			}
		}
		return max_Distance;
		
	}

	public static void main(String[] args) {
		
		int[] arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
	    int n = arr.length;
	    System.out.println(maxDistance(arr));
		
	}

}
