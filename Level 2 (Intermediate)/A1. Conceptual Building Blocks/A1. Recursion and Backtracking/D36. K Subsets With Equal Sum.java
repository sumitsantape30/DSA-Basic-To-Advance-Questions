K Subsets With Equal Sum

1. You are given an array of n distinct integers.
2. You have to divide these n integers into k non-empty subsets such that sum of integers of every 
     subset is same.
3. If it is not possible to divide, then print "-1".

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number n
n distinct integers 
A number k
Output Format
Check the sample ouput and question video.

Constraints
1 <= n <= 20
1 <= arr[i] <= 100
1 <= k <= n
Sample Input
6
1
2
3
4
5
6
3
Sample Output
[1, 6] [2, 5] [3, 4] 

Code:

import java.io.*;
import java.util.*;

public class Main {


	public static void solution(int[] arr, int vidx,int n , int k,int[] subsetSum,int ssssf, ArrayList<ArrayList<Integer>> ans) { //ssssf is ki kitne sets ban chuke hai, kitne non empty set ban chuke hai. subsetsum mai har partition ka sum lekar aa rhe hai 
	    
	    if(vidx == arr.length){ 
	        if( ssssf == k){ // agar non empty set for far is equal to k to patition thik hui hai apki maltab apke pas appropriate number of paritions hai 
	        //ab sari values aapas mai barabr honi chahiye
	        boolean flag = true;
	        for( int i=0; i < subsetSum.length -1; i++){
	            if( subsetSum[i] != subsetSum[i+1]){ // sath wali 2 values ki value barbar nhi hui to flag ko false krke break karjayenge
	             flag = false;
	             break;
	          }
	        }
	        
	        if( flag){ // agar sare sets ke elements ka sum apas mai barabr hai to hum inn sets ko print kar skte hai 
	          for(ArrayList<Integer> partition: ans){
	              System.out.print(partition + " ");
	          }
	          System.out.println();
	        }
	    }
	    return;
	}

        //yeh arr[vidx] hai iske pas kya choices hai? 
        for( int i=0; i< ans.size(); i++){ 
            if( ans.get(i).size() > 0 ){ // iske pas choices hai ya to mai kisi exisiting non empty set mai baith jau
                ans.get(i).add(arr[vidx]); //apne arraylist ke andar apna banda add kardiy hai to usi wale ka subset sum increase karega
                subsetSum[i] += arr[vidx];
                solution(arr, vidx +1, n, k, subsetSum, ssssf, ans); // yahape naya set nhi banaya hai aise set mai value dali jo pehlese bana hua tha ssssf waisahi rahega
                //backtrack krte hue apne jo action apne upar jate hue liya tha use undo krde
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size() -1 ); // last wala remove krdiya aate hue
                
            }else{ // yafir mai ek nanya empty set banalu
                ans.get(i).add(arr[vidx]); 
                subsetSum[i] += arr[vidx];
                solution(arr, vidx +1, n, k, subsetSum, ssssf +1, ans); // apne ek empty set ko occupy kiya hai to ssssf wala count badhega ki ab kitne non empty sets hai  
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size() -1 );
                break;
            }
        }

	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i =  0 ; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i]; // sare elements ka sum karke rakh liya
		}
		int k = scn.nextInt();
		// if k is equal to 1, then whole array is your answer, 1 hi partition mai batna hai
		if(k == 1) { // k=1 means agar set 1 hi hai to partition hi kuch nhi karna sare elements ko print krde
			System.out.print("[");
			for(int i = 0 ; i  < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			return;
		}
		//if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
		if(k > n || sum % k != 0) { // agar k n se bada hai maltab elements 5 hai aur maine bole ki 10 hisse krdo to iska kuch nhi ho skta OR jo total elements ka sum tha woh woh k ka multiple hi nhi hai tobhi kuch nhi ho skta to -1 print karke return krdenge
			System.out.println("-1");
			return;
		}
		//fir humne array banaya k size ka, humare pas k sets banne wale hai, 0th index woh 0th set ke elements ka sum contain karegi
		int[] subsetSum = new int[k]; 
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // aur fir arraylist of arraylist banali
		for(int i = 0; i < k; i++) { // aur yeh arraylist bhi k size ki banayi, bahar wali arraylist k size ki banayi 
			ans.add(new ArrayList<>()); //abhi sari arraylists khali hai 
		} // so arraylist of arraylist ke andar mere pas k arraylist padi hai, sari blank hai abhi 
		solution(arr,0,n,k,subsetSum,0,ans);
	}
}
