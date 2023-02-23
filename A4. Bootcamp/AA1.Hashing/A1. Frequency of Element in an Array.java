
//===================Using Frequency Array==============
package Hashing;

import java.util.*;
import java.io.*;

public class session1_p1 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		int arr[]= new int[n];
		
		for(int i=0; i< arr.length; i++) {
			arr[i] = s.nextInt();
		}
		
		int freq[]= new int[arr.length+1];
		for( int i=0; i< arr.length; i++) {
			int val = arr[i];
			freq[val]++;
		}
		
		int q= s.nextInt();
		while(q > 0) {
			int x = s.nextInt();
			System.out.println(freq[x]);	
		}
	}
}

//======================= Using HashMap ============================
package Hashing;

import java.util.*;
import java.io.*;

public class session1_p1 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		int arr[]= new int[n];
		
		for(int i=0; i< arr.length; i++) {
			arr[i] = s.nextInt();
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for( int i=0; i< arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		int q= s.nextInt();
		while(q > 0) {
			int x = s.nextInt();
			System.out.println(map.get(x));	
		}
		
	}

}

