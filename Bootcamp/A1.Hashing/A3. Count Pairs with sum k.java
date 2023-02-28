package Hashing;

import java.util.*;
import java.io.*;

public class session1_p1 {
	
	public static int countPair( int arr[], int tar) {
		
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		for( int i=0; i< arr.length; i++) {
			
			if(!map.containsKey(tar - arr[i])) {
				map.put(tar-arr[i], 1);
			}else {
				map.put(tar-arr[i], map.get(tar-arr[i])+1);
				count += map.get(tar -arr[i]);
			}
			
		}
		return count;
		
	}

	public static void main(String[] args) {
		
		int[] arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
	    int n = arr.length;
	    System.out.println(countPair(arr, 12));
		
	}

}
