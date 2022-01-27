Count Of All Subarrays With Zero Sum

1. You are given an array(arr) of integers.
2. You have to find the count of all subarrays with sum 0.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing the count of all subarrays with sum 0. 

Constraints
1 <= N <= 10^6
1 <= arr[i] <= 10^4
Sample Input
8
15 -2 2 -8 1 7 10 23
Sample Output
3

Code:

import java.util.*;

public class Main {

	public static int solution(int[] arr) {
	    int count = 0;
	    
	    //isbar hashmap mai hum sum ki frequency store kr rhe hai
	    HashMap<Integer, Integer> map = new HashMap<>();
	    
	    //shuruwat mai mera i baitha hai -1 pr aur mera sum hai 0
	    int i= -1;
	    int sum = 0;
	    map.put(0, 1); //0 ke samne 1 dal diya hai ki 0 sum ekbar aahuka hai
	    
	    while(i < arr.length-1){
	        //andar aatehi i badhao aur sum badhao
	        i++;
	        sum += arr[i];
	        
	        //ab hume dekhna hai kya yeh sum pehle aa chuka hai
	        if( map.containsKey(sum) == true){ //agar map iss sum ko contain krta hai matlab yeh sum pehle aachuka hai to sum ki jitni pehle frequency thi woh mai count mai add karunga
	          count += map.get(sum);
	           //ab frequency bhi badhani hai
	           map.put(sum, map.get(sum) + 1); //jo purani frquency thi usko ekse badha diya
	        }else{ //agar pehli bar yeh sum aa rha hai to count nhi badhega bas map mai daldo
	           map.put(sum, 1);
	        }
	    }

		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));

	}
}
