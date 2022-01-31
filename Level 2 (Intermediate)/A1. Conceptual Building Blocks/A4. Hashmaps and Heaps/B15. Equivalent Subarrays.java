Equivalent Subarrays

1. You are given an array of integers(arr).
2. You have to find the count of equivalent subarrays.
3. A subarray is equivalent if,
   count of unique integers in the subarray = count of unique integers in the given array.
Input Format
A number N
arr1
arr2... N numbers
Output Format
A number representing count of equivalent subarrays. 

Constraints
1 <= N <= 10^5
-2^31 <= arr[i] <= 2^31-1
Sample Input
5
2 1 3 2 3
Sample Output
5

Code:

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
		
		//pehle hashset banakr dekh lete hai kitne unique characters humare pas hai
		HashSet<Integer> set = new HashSet<>();
		for( int i=0; i< arr.length; i++){
		    set.add(arr[i]);
		}
		
		int k = set.size(); //yahapr jo k hai distinct elements woh hai set ka size
		int ans = 0;
		
		// ab mai i and j ko rakhunga -1 pr
		int i = -1;
		int j = -1;
		
		HashMap<Integer,Integer> map = new HashMap<>(); //frequncy map hai yeh
		
		while( true){
		    boolean f1 = false;
		    boolean f2 = false;
		    
		    while(i < arr.length - 1){
		        f1 = true;
		        
		        i++;
		        map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); 
		        //isse humara frequency map ban jayega
		        
		        if( map.size() == k ){ //jaisehi map ka size k bande jaisahi hojaye to apko break karna hai
		          ans += arr.length - i; //size k hogya to answer ke andar add karenge pure array ki length jitni hai - jahapr i hai, aur break
		          break; //apke pas k bande hogye to app break karenge
		        }
		    }
		    
		    //ab hum start karenge release krna
		    while( j < i){
		        f2 = true;
		        
		        //j badhayenge aur map mese remove karenge 
		        j++;
		        if( map.get(arr[j]) == 1){ //agar arr[j] ki frequency 1 hai to use map se remove karna hoga
		          map.remove(arr[j]);
		        }else{
		            //else map mese uski frequency ek se kam krdo
		            map.put(arr[j], map.get(arr[j]) - 1);
		        }
		        
		        //yeh release krne ke bad bhi agar map ka size equal to k bacha rha to ans mai dubara se add kardo
		        if(map.size() == k){
		            ans += arr.length - i;
		        }else{
		            //agar size kam hogya k se to break kare
		            break;
		        }
		    }
		    
		    if( f1 == false && f2 == false){
		        break;
		    }    
		}
		System.out.println(ans);
		
	}

}

