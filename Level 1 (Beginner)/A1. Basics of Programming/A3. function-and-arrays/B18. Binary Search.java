package array;

import java.util.Scanner;

public class BinarySearch {

	public static int binarySearch(int arr[], int element) { //function will return the index of the element if it is found otherwise -1
		 
		int start= 0; //start index
		int end= arr.length-1; //last index
		
		// start ka element humesha end se chota hi rahega coz sorted array hai
		while( start <= end) { // hum yeh kam kabtak karre? jab hume humara element mil jaye ya fir element hai hi nhi array mai tab start aur end overlap ho jayenge
			
			// start and end har bar change hora matlab mid bhi change hoga.
			int mid= (start+end)/2;
			
			if( element == arr[mid]) { // jo element search karna hai usko mid index value ke sath compare karre agar dono same rhe to mid index return karenge
				return mid;	
			
			}else if( element > arr[mid]) {  //if element that we have to find is greater than the element at the mid, then we should move towards right of the mid
					start= mid+1; //right mai jare matlab hume start index update krna padega and end wahi rahega.	
				
			}else{  //( element < arr[mid])  agar element chota hai than element at mid to left ke side jana padega and humara end mid se ek se kam hoga.
					end= mid-1;
				}
			}
		return -1; //agar yeh while loop pura execute hojata hai matlab start aue end ek duse ko cross kar jate hai
	}

	public static void main(String[] args) {

		int arr[]= {1,3,7,9,11,12,15};
		int searchResult= binarySearch(arr, 11);
		System.out.println(searchResult);
	}
}

