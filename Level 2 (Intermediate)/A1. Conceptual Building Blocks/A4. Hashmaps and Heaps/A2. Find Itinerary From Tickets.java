Find Itinerary From Tickets

1. You are given number N and 2*N number of strings that represent a list of N tickets(source and destination).
2. You have to find the itinerary in order using the given list of tickets.

Assumption -> The input list of tickets is not cyclic and there is one ticket from every city except the final destination.
Input Format
A number N
N number of lines, where each line contains 2 strings.
Output Format
Check the sample ouput and question video.

Constraints
1 <= N <= 100
Sample Input
4
Chennai Banglore 
Bombay Delhi 
Goa Chennai 
Delhi Goa 
Sample Output
Bombay -> Delhi -> Goa -> Chennai -> Banglore.

Code:

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}
        
        //jo original hashmap bhara hua hai usse ek naya hashmap tayar karna hai String vs Boolean 
        HashMap<String, Boolean> psrc = new HashMap<>(); //potential sources
        for(String src: map.keySet()){ // source
          String dest = map.get(src); //source ka aage destination hai
          
          psrc.put(dest, false); //potential source ke andar put krdo destination ko, ki you cannot be the potential source
          if( psrc.containsKey(src) == false){ //agar potential source ke map ke andar source nhi pda to dalko ki you can be a potential source
            psrc.put(src, true); 
          } //aur agar pehlese pda hai to kuch nhi karna
        }
        
        String src = ""; //overall source, muje woh source nikalna hai
        for(String pot: psrc.keySet()){ //isme loop lagaunga aur muje ek lauta wala true muje mil jaye
            Boolean val = psrc.get(pot);
            if( val == true){ //agar value tumhari true aayi to yahi overall source hai
              src = pot;
              break;
            }
        }
        //ab apke pas source aa chuka hai
        
        while(true){
            if( map.containsKey(src) == true){ //yeh source map pda hai ki nhi pda hai
              System.out.print(src+" -> "); // jabtak milta hai print karke arrow lagao
              src = map.get(src); //jiska destination tha usko naya source banade
            }else{
                //jab kahi nhi ja rhe to print karke full stop 
                System.out.print(src +".");
                break;
            }
        }
	}
}
