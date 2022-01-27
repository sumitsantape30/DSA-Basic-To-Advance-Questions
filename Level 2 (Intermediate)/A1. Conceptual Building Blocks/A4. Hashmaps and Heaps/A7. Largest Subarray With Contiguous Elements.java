Largest Subarray With Contiguous Elements

1. You are given an array(arr) of integers. Values may be duplicated.
2. You have to find the length of the largest subarray with contiguous elements.

Note -> The contiguous elements can be in any order(not necessarily in increasing order).
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing the length of the largest subarray with contiguous elements.

Constraints
1 <= N <= 10^4
1 <= arr[i] <= 10^3
Sample Input
3
10 12 11
Sample Output
3

Code:

import java.util.*;

public class Main {

	public static int solution(int[] arr) {
        int ans = 0;
        
        //i and j ke do loop rakhenge
        for( int i= 0; i < arr.length-1; i++){ //i akhri ka ek element chodke wahatk vary karega
           //initially current element hi mera min and max rahega
            int min = arr[i];
            int max = arr[i];
            HashSet<Integer> cd = new HashSet<>(); //aur hashset hume duplicacy check karne mai help karega, cd = check duplicacy
            cd.add(arr[i]); //yeh current element hashset mai dal dunga, yeh element dubara aya to gadbad hojayegi
            
            for( int j = i + 1 ; j < arr.length; j++){ // j = i sebhi start kr skte ho
                if( cd.contains(arr[j])){ //agar hashset iss jth element ko already contain krta hai to break krde
                    break;
                }
                cd.add(arr[j]); // agar contain nhi krta to hashset mai dal de
                
                //ab apna min aur max update krde
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                
                //iss subarray to tab consider karenge jab max-min == i - j
                if(max - min == j - i){ //aisa hua matlab yeh valid subarray ban rha hai, iss subarray ke andar sare continuos elements hai
                  int len = j - i + 1; // iski length j-i nhi j-i+1 hoti hai
                  if( len > ans){ // agar yeh length answer se lambi hai to ans ko update krde
                    ans = len;
                  }
                }
            }
        }
        
		return ans;
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

