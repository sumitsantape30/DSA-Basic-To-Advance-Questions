Largest Subarray With Zero Sum

1. You are given an array(arr) of integers.
2. You have to find the length of the largest subarray with sum 0.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing the length of largest subarray with zero sum.

Constraints
1 <= N <= 10^6
1 <= arr[i] <= 10^4
Sample Input
8
15 -2 2 -8 1 7 10 23
Sample Output
5

Code:

import java.util.*;

public class Main {
	
	public static int solution(int[] arr) {
	    
	    HashMap<Integer, Integer> map = new HashMap<>();// yeh hashmap sum  ke against index represent rkta hai
	    int mlen = 0; //maxlength
	   
	    int sum = 0;
	    int i = -1;
	    map.put(sum, i); //map mai pehlese -1 index put kr rha hu, array se pehle wala index ustime 0 sum tha. i== -1 index pe sum 0 tha
	    //sum ke samne i dalo, sum is the key
	    while( i < arr.length-1){ //i arr.length-1 se chota hona chahiye
	    //i badhaunga aur sum mai current elment dal dunga
	      i++; //andar aatehi mai i ko ek se badhaunga 
	      sum += arr[i];
	      
	      //ab mai dekhunga kya yeh sum map mai pehlese pda hai ya nhi pda
	      if( map.containsKey(sum) == false){ //agar yeh sum nhi pda hai map mai matlab pehli bar aya hai to map mai i index ke samne yeh sum dalde
	        map.put(sum, i); // sum ke samne i dalo
	      }else{
	          //agar map mai already pda hua hai to pta karo kaha tha pichli bar
	          int len = i - map.get(sum);
	          if( len > mlen){
	              mlen = len;
	          }
	      }
	    }
	    return mlen;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
