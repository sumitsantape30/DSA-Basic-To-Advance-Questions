Count the number of subarrays with given xor K
Problem Statement: Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to B.

Examples:

Input Format:  A = [4, 2, 2, 6, 4] , B = 6
Result: 4
Explanation: The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]

Input Format: A = [5, 6, 7, 8, 9], B = 5
Result: 2
Explanation:The subarrays having XOR of their elements as 2 are [5] and [5, 6, 7, 8, 9]

Code:

//==================================== Brute Force ===========================================
import java.io.*;
public class Solution {
    public int solve(int[] A, int B) {
        int c=0;
        for(int i=0;i<A.length;i++){
            int current_xor = 0;
            for(int j=i;j<A.length;j++){
                current_xor^=A[j];
                if(current_xor==B) c++;
            }
        }
        return c;
    }
}
class TUF {
	public static void main (String[] args) {
		Solution obj = new Solution();
		int[] A = new int[]{4,2,2,6,4};
		int countTotal=obj.solve(A,6);
		System.out.println("The total number of subarrays having a given XOR 
                k is "+countTotal);
	}
}

//===================================== Optimised Approach ================================

import java.io.*;
import java.util.*;
public class Solution {
    public int solve(int[] A, int B) {
     HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>(); 
        int c = 0; //count
        int cpx = 0; //will store prefix xor
        int n = A.length;
        for(int i = 0;i<n;i++) { //linearly traverse in the array
            cpx = cpx ^ A[i]; //we'll keep taking XOR whenever we have new element
            
            //after this we'll check for value Y 
            if(visited.get(cpx^B) != null) //prefix xor aur B ka xor agar hashamap mai already hai to uski value not null hai to usko count mai dal denge
                c += visited.get(cpx ^ B); // how many times cpx^B appears you can get it and add in count
          
            if(cpx == B) { // aur agar current prefix xor B ke equal hai tonhi count badhana padega because you need to consider prefix subarray also
                c++; 
            }
          //after this you need to add it in hashmap, simply get the previous value and add 1 to it else keep the frequency as it is
            if(visited.get(cpx) != null) 
                visited.put(cpx, visited.get(cpx) + 1); 
            else 
                visited.put(cpx, 1); 
        }
        return c; 
    }
}

class TUF {
	public static void main (String[] args) {
		Solution obj = new Solution();
		int[] A = new int[]{4,2,2,6,4};
		int countTotal=obj.solve(A,6);
		System.out.println("The total number of subarrays having a given XOR 
                k is "+countTotal);
	}
}                  
