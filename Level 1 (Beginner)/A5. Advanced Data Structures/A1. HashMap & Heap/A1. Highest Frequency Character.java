Highest Frequency Character

1. You are given a string str.
2. You are required to find the character with maximum frequency.
Input Format
A string str
Output Format
The character with highest frequency

Constraints
0 < str.length() <= 100
There will be a single character with highest frequency
Sample Input
zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc
Sample Output
q

Code:

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn= new Scanner(System.in);
        String str= scn.nextLine();
        HashMap<Character, Integer> map= new HashMap<>();
        int maxfreq=0; //max frquency ko maine pehle 0 leliya
        char mfc= str.charAt(0); //max frquency character ko maine 0 wala leliye
        
        for( int i=0; i< str.length(); i++){
            char ch= str.charAt(i);
            
            if( map.containsKey(ch) == true){ //agar woh character already present hai to bas uski value badhayenge
                map.put(ch, map.get(ch)+1 );
            }else{
                //agar woh pehli bar aya hai to uske value 1 rakhdo
                map.put(ch, 1);
            }
            
            if( map.get(ch) >  maxfreq){ //agar uss character ki frequency max frequency se badi hojati hai to maxfrequency ko update kardo aur sathmne maxfrquency character bhi update krdo
             maxfreq= map.get(ch);
             mfc= ch;
            }
        }
        System.out.println(mfc);
    }
    //TC: O(n), n is the length of the string

}
