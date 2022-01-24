Count Distinct Elements In Every Window Of Size K

1. You are given an array(arr) of integers and a number K.
2. You have to find the count of distinct numbers in all windows of size k.
Input Format
A number N
arr1
arr2.. N numbers
A number K
Output Format
Space separated numbers representing the count of distinct numbers in all windows of size k.

Constraints
1 <= N <= 10^5
1 <= arr[i] <= 10^4
1 <= k <= N
Sample Input
7
1 2 1 3 4 2 3        
4
Sample Output
3 4 4 3 

Code:

import java.util.*;

public class Main {

	public static ArrayList<Integer> solution(int[] arr, int k) {
	    
		//hume arraylist of integer banakr return karni hai
		ArrayList<Integer> list = new ArrayList<>();
		
		//apna kam karne keliye chahiye hashmap
		HashMap<Integer, Integer> map = new HashMap<>();//hashmap mai store karenge frequency har integer ki
		
		//pehle k-1 bande acquire honge
		for( int i = 0; i < k-1; i++){
		    map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // arr[i] pe uski old frequency nikalkr usme +1 add kr rha hu, isme agar pehlese pda hua nhi hai to exception ayegi isliye getOrDefault use karenge
		}//0 to k-2 index matlab 0 to k-1 log hote hai, pehle k-1 log ko acquire karliya 
		//k-1 index actually mai kth banda hota hai
		//ab kth se humara kam start hota hai
		for( int j= 0, i = k-1; i < arr.length;){ // j ko rakha 0 pe aur i ko rakha k-1 pe, k-1 index matlab k se loop chal rha hai
		  
		  //pehla kam i pe acquire karo
		  map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

		  //fir print karo means answer list mai add karo
		  list.add(map.size()); //humne map mai abhi kitne distict elements hai map mai dal diya
		  
		  //ab jth element ko release krdo
		  int freq = map.get(arr[j]);// arr[i] ki kitni frequency hai
		  if( freq == 1){ //agar frequency 1 hui to matlab woh udega
		      map.remove(arr[j]);
		  }else{
		      //aur agar frequency 1 se jada hui to frequency kam karenge
		      map.put(arr[j], freq-1);
		  }
		  
		  i++; //agla banda acquire karna hai so i++ krdo
		  j++;
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}
}
