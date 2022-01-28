Smallest Substring Of A String Containing All Characters Of Another String

1. You are given two strings s1 and s2 containing lowercase english alphabets.
2. You have to find the smallest substring of s1 that contains all the characters of s2.
3. If no such substring exists, print blank string("").
Input Format
Two strings s1 and s2
Output Format
A string

Constraints
1 <= length of string s1 and s2 <= 10000
Sample Input
timetopractice
toc
Sample Output
toprac

Code:
import java.util.*;
import java.io.*;

public class Main {

	public static String solution(String s1, String s2){
	    String ans = "";
	    
	    //string 2 ka map banayenge
	    HashMap<Character, Integer> map2 = new HashMap<>();
	    
	    for( int i=0; i < s2.length(); i++){ // String 2 pe loop chalaya
	      char ch = s2.charAt(i);
	      map2.put(ch, map2.getOrDefault(ch, 0) + 1); // yeh frequency map banane ka tarika, pehlese character pda hai to uski frequency de dega aur nhi pdi hai to 0 dega usme 1 add kr rhe hai 
	    }
	    
	    int mct = 0 ;//matchcount initially 0 hai
	    int dmct = s2.length(); // desired matchount jo string 2 ki length le barabr hai, ki itne character match honge to bat banegi
	    
	    HashMap<Character, Integer> map1 = new HashMap<>(); //yeh string 1 ka map banane mai help karega
	    
	    int i = -1;
	    int j = -1; //shuruwat mai i and j -1 pe hai
	    
	    while(true){ 
	        //iss loop se bahar kaise niklenge?
	        boolean f1 = false;
	        boolean f2 = false;
	        //agar dono loop mai ghusne band krde to break karjaye *niche dekho badme smjhega*
	        
	        //acquire, tabtak acquire krte hai jabtak matchcount sahi nhi hojata
	        while( i < s1.length() - 1 && mct < dmct){ //jabtak i limits mai hai And matchcount is less than desired matchcount jabtak matchcount proper nhi hai
	          i++; //i badhate rhe aur acquire krte rhe
	          char ch = s1.charAt(i);
	          map1.put(ch, map1.getOrDefault(ch, 0) + 1); //map 1 mai uski frequency badhani hai
	          
	          //apne acquire krliye ab matchcount badhega ya nhi badhega, agar acquire krke apki frequency jada hogyi hai to yeh kisi kam ka nhi hai
	          if( map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)){ //acquire krne ke bad choti hai map2 mai jo iss character ki frequency hai usse to yeh kam ka badna acquire kiya hai apne to matchcount ko badhale
	           mct++;
	          }//agar kam ka acquire nhi kiya hai to matchcount nhi badhayenge
	          f1 = true; //pehle loop mai ekbar bhi agye to flag1 ko true krdo
	        }
	        
	        //collect answers and release
	        while( j < i && mct == dmct){// j i ke piche chalna chahiye, release krne wala i ko cross thodi karega, aur matchcount must be equal to desired matchcount
	          //sabse pehle answer collect kare yeh potential answer hai kyuki matchcount desiredmatchcount ke equal hai
	          String pans = s1.substring(j + 1, i + 1); //j+1 se i+1 tak jayenge, j+1 se isliye liya kyuki jth character release ho chuka hota hai. i+1 isliye liye, ith banda acquire hochuka hota hai lekin ith badne ko substring mai i+1 krna padega
	          
	          if(ans.length() == 0 || pans.length() < ans.length()){ //answer tab banega jab iss potential answer ki length answer ki length se choti hai. yafir ans length ki 0 hai pehlese means answer bana hi nhi hai to abhi ans set krdenge
	            ans = pans;
	          }
	          
	          //ab release karenge
	          j++; //pehle j badhaye
	          char ch = s1.charAt(j); //fir character dekhenge
	          //release krna hai to release karne se frequency ghategi
	          if(map1.get(ch) == 1){ //agar iski pehlese frequency 1 hai to isko map se hi udado
	             map1.remove(ch); //uski sirf ek occurence thi to map se udade
	          }else{
	              //else uski frequency kam krde
	              map1.put(ch, map1.get(ch) - 1); //pichli frquency se ek kam krde
	          }
	          
	          if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)){ //map1 mai frequency agar kam hogyi hai map2 se matlab apne kam ka banda gawaya hai. apki frquency kam hogyi hai matlab apne kam ka banda gawaya hai. agar barbr hai to apne kam ka banda nhi gawaya iska matlab pehle isse jadat ho
	           mct--; //kam ka banda gawaya hai to matchcount ko -- krde
	          }
	          f2 = true; //release loop mai ekbar bhi aaye ho to flag2 false krdo
	        }
	        
	        if( f1 == false && f2 == false){ //agar dono flags false reh gye matlab aap konse bhi loop mai nhi ja rhe to break lagade
	          break;
	        }
	    }
        
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}
}
