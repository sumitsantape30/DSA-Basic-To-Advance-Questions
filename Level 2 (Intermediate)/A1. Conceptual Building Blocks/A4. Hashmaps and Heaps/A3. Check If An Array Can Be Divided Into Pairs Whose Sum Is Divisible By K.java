Check If An Array Can Be Divided Into Pairs Whose Sum Is Divisible By K

1. You are given an array(arr) of integers and a number K.
2. You have to find if the given array can be divided into pairs such that the sum of every pair is divisible by k.

Input Format
A number N
arr1
arr2.. N numbers
A number K
Output Format
true or false.

Constraints
1 <= N <= 10^6
1 <= arr[i] <= 10^4
1 <= K <= 10^4
Sample Input
4
9 7 5 3
6
Sample Output
true

Code:

import java.util.*;

public class Main {
	
	//jab bhi k se divisibility ka kuch aa rha hai aur array hai, array ke andar k se divisibility ka question hai to most likely apka jo hasmap banega woh remainders ka hashmap banega
	public static void solution(int[] arr, int k){
        
        HashMap<Integer, Integer> rfmap = new HashMap<>(); // remainer frequency map, remainders ki frequency store kr rhe hai hum
        
        for( int val: arr){
            int rem = val % k; // remainder agya mere pas
            
            //remainder ki kitni frquency hai yeh store karna hai
            int of = rfmap.getOrDefault(rem, 0); //old frequency. yaha sirf get use kiya to exception dega isliye getOrdDefault use kare
            rfmap.put(rem, of + 1); //
        }
        
        //frquency nika li ab test karna hai to dubara array lagate hai array mai
        for( int val: arr){
            int rem = val % k; //remainder nikala
            
            if( rem == 0){ //agar tumhara remainder 0 hai
              int fq  = rfmap.get(rem);
              if( fq % 2 == 1){ // agar yeh frquency odd hui to gadbad hai hum false print karenge
                System.out.println(false);
                return;
                  
              }
                //aisahi k/2 keliye karenge
            }else if( 2 * rem == k){ //or remainder k/2 hai
              int fq  = rfmap.get(rem);
              if( fq % 2 == 1){ // agar yeh frquency odd hui to gadbad hai hum false print karenge
                System.out.println(false);
                return;
              }
              
            }else{ //so ab agar nahi 0 hai remainder, na remainder k/2 hai, remainder kuch aur hi hai 
              int fq = rfmap.get(rem);
              int ofq = rfmap.getOrDefault(k - rem, 0);
              
              if( fq != ofq){ //agar dono freqency match nhi hui to hum false print kardenge
                System.out.println(false);
                return;
              }
            }
        }
        
        //aisa kabhi nhi hua ki na 0 pe odd mile na k/2 pe odd frequency mili aur sare frequency wale other frequency walo ke sath barabr hue to kabhi false nhi hoga aap yaha akr true print kardenge
        System.out.println(true);

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
	}

}
