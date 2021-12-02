K-partitions

1. You are given two integers n and k, where n represents number of elements and k represents 
     number of subsets.
2. You have to partition n elements in k subsets and print all such configurations.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number n
A number k
Output Format
Check the sample ouput and question video.

Constraints
1 <= n <= 10
1 <= k <= 10
Sample Input
3
2
Sample Output
1. [1, 2] [3] 
2. [1, 3] [2] 
3. [1] [2, 3] 



Code:

import java.io.*;
import java.util.*;

public class Main {
    
    static int counter= 0 ; // answer mai counter bhi print krna hai

	public static void solution(int i, int n, int k, int nos, ArrayList<ArrayList<Integer>> ans) { // nos: number of set so far: kitne set mai apne banda bhar diya shuruwat mai ek bhi set mai nhi bhara hai sare khali hai
	  
	  if( i > n){ // basecase pahuchega jab i > n hoga
	    if( nos == k){ // hum check karenge kya number of sets k ke equal hai ya nhi 
	        counter++;
	        System.out.print(counter + ". ");
	        for(ArrayList<Integer> set: ans){ // arraylist of arraylist mese ek set nikalenge aur usko print krdenge
	            System.out.print(set + " ");
	        }
	        System.out.println();
	    }
	    return;
	  }
	  
	  //ith bande ke pas kya options hai? jitne set pehlese bhare hue hai unke sath baith skte ho aur pehle empty set mai baith skte ho
	  //jitne bhare hai usme direct call lagado aur pehle wale khali mai call lagado
	  
	  for( int j=0; j< ans.size(); j++){
	      if( ans.get(j).size() > 0){ //agar pehlese bhara hua hai to isme dalke call lagayenge
	        ans.get(j).add(i); // yeh jo add kiya isse koi naya set nhi bana, pehlese bhare hue set mai tumne kuch add kiya hai to iska koi naya set nhi banega to call krte waqt ssf jitna tha utnahi rahega
	        solution(i + 1, n, k, nos, ans); // abhitak jo pehlese bhare hue set hai usmehi value add krke call laga rhe ho to ssf badhega nhi
	        ans.get(j).remove(ans.get(j).size() - 1); // backtracking krte waqt remove kare, last mai add kiya tha to last banda remove kiya jaye
	      }else{ // jabtak tumhe size grater than 0 wale milte rhe add karke call lagate rho aur wapsi mai remove krte rho aur ab jis din tumhe empty set mile to call lagake break.
	     // empty set mila to usme add kareng fir call lagayenge
	        ans.get(j).add(i); 
	        solution(i + 1, n, k, nos + 1, ans);  // ab ssf badha denge kyuki yeh empty set tha aur iss set mai tumne pehli value dali hai 
	        ans.get(j).remove(ans.get(j).size() - 1);
	        break;
	      }
	  }
	
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // arraylist of arraylist banake de rakhi hai 
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>()); // k sets hai to k arraylist di gyi hai, abhi sari arraylist khali hai 
		}
		solution(1, n, k, 0, ans); // ith banda 1 pass kiya hai,

	}

}

//======================================================================JB's=================================================================

import java.io.*;
import java.util.*;

public class Main {
    
    static int counter= 0 ; // answer mai counter bhi print krna hai

	public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) { //rssf : room selected so far
	  if( i == n + 1){ 
	    if( rssf == k){ 
	        counter++;
	        System.out.print(counter + ". ");
	        for(ArrayList<Integer> list : ans){ 
	            System.out.print(list + " ");
	        }
	        System.out.println();
	    }
	    return;
	  }
	  

	  for( int j=0; j<= rssf && j < k; j++){ // jitni rssf ki value hogi utne mere pas options honge, jitni rooms selected hai utni choices hai, rssf uss index tak choices hai
	     if( ans.get(j).size() == 0 ){ // size agar 0 hai to
	        ans.get(j).add(i); //ans ek arraylist of arraylist hai to ans.get(j) ek arraylist hai usme mai current bande ko add karunga. ans is arraylist of arraylist usmese ek arraylist nikal li ans.get(j) aur ith bande ko add kardiya
	       
	       solution(i+1, n, k, rssf + 1, ans);// recursive call lgadi ki i+1th bande ke pas jao
	       
	       //apne arraylist mai banda add kiya tha aur arraylist banti hai heap pe to wapas aate hue woh change apne aap nhi hoga humko heap mese jake remove karna hoga
	       ans.get(j).remove(ans.get(j).size() - 1);
	       
	     }else{ // agar size non 0 hai to upar wali same lines use karenge bas rooms selected so far ki value nhi badhegi
	         
	       ans.get(j).add(i); 
	       
	       solution(i+1, n, k, rssf, ans);
	       
	       ans.get(j).remove(ans.get(j).size() - 1);
	     } 
	  }
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // arraylist of arraylist banake de rakhi hai 
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>()); // k sets hai to k arraylist di gyi hai, abhi sari arraylist khali hai 
		}
		solution(1, n, k, 0, ans); // ith banda 1 pass kiya hai,

	}
}
