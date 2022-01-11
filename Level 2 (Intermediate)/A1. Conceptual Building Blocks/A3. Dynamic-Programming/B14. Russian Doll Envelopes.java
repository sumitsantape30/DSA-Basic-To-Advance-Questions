Russian Doll Envelopes

1. You are given a number n, representing the number of envelopes.
2. You are given n pair of numbers, representing the width and height of each envelope.
3. You are required to print the count of maximum number of envelopes that can be nested inside each other.
Note -> Rotation is not allowed.
Input Format
A number n
.. n pair of number each on a separate line (and pair separated by space)
Output Format
A number representing the count of maximum number of envelopes that can be nested inside each other.

Constraints
0 <= n <= 20
0 <= n1w, n1h, n2w, n2h, .. <= 100
Sample Input
11
17 5
26 18
25 34
48 84
63 72
42 86
9 55
4 70
21 45
68 76
58 51
Sample Output
5

Code:

import java.io.*;
import java.util.*;

public class Main {
    
    public static class Envelope implements Comparable<Envelope>{
        
        int w; //width
        int h; //height 
        
        Envelope(int w, int h){
            this.w = w;
            this.h = h;
        }
        
        public int compareTo(Envelope o){
            return this.w - o.w;// sirf width ke basis pe mai sort karna chahta hu
            //bridges mai ek aur kam kiya tha humne, ki agar north barabr na ho to north ke basis pe krde north barabr ho to south ke basis pe krdet yaha uski jarurat nhi hai sirf width ke basis pe krde
        }
    }

    public static void main(String[] args) throws Exception {
        
        Scanner s= new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine()); //input liya ki kitne Envelopes hai
        
        Envelope envlps[] = new Envelope[n];
        for( int i=0 ; i < n; i++){
            String line = s.nextLine();
            String parts[] = line.split(" "); //space ke basis pe split karenge taki width aur height mil ske
            int w = Integer.parseInt(parts[0]); //width
            int h = Integer.parseInt(parts[1]);  //height
            envlps[i] = new Envelope(w, h);
        }
        
        Arrays.sort(envlps); //envlps ke array ko sort kardiya
        
        //ab iske basis pe lis nikalna hai
        int dp[] = new int[n];
        int omax = 0;
        for( int i=0; i< dp.length; i++){
            int max = 0;
            
            for( int j = 0; j < i; j++){ //ab hume check karna hai envelope andar aa skta hai ye nhi aa skta
            // jab height kam hogi tabhi bad wala envelope pehle wale envelope ko apne andar rakh kr aur jada badi nesting bana skta hai
                if(envlps[j].h < envlps[i].h && envlps[j].w < envlps[i].w ){ //dusra bhi check lagana hoga ki jo pehle wala envelope hai uski width bhi strictly less hai ki nhi kyuki sorting humne sirf width ke basis pe ki hai aur width barabr bhi ho skti hai lekin barbr ke isme nesting nhi ho skti 
                    if( dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            
            dp[i] = max + 1;
            
            if( dp[i] > omax){
                omax = dp[i];
            }
            
        }
        System.out.println(omax);
        //dono ques mai difference yeh hai ki wahapr north bridge equal ho skta tha to humne dusra check nhi lagaya tha
    }

}
