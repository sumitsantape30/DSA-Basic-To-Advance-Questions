Problem Statement
Suggest Edit
You are given a non-empty string S containing no spaces’ and a dictionary of non-empty strings (say the list of words). You are supposed to construct and return all possible sentences after adding spaces in the originally given string ‘S’, such that each word in a sentence exists in the given dictionary.
Note :
The same word in the dictionary can be used multiple times to make sentences.
Assume that the dictionary does not contain duplicate words.
Detailed explanation ( Input/output format, Notes, Constraints, Images )
Sample Input 1:
1
6
god is now no where here
godisnowherenowhere
Sample Output 1:
god is no where no where
god is no where now here
god is now here no where
god is now here now here
Explanation To Sample Input 1:
One way to make sentences is to take “god” and append a space, then take “is”  and append space, take “now” from the dictionary and take “here” as well. 
Similarly, for other sentences also, we can add space to get other possible sentences. Note that we can reuse dictionary words as “no” and “now” are used two times in the same sentence.
Sample Input 2:
1
4
god is no here
godisnowhere
Sample Output 2:
No output to be printed
Explanation To Sample Input 2:
We can not make any sentence because after making “god is no” we will be stuck with “where”. There is no way to break “where” further such that we can get any word from the dictionary.

Code:

imoport java.util.*;
import java.io.*;

class HelloWorld {
    
    public static void wordBreak(String str, String ans, HashSet<String> dict){
        if( str.length() == 0){//aise krte krte string ki length 0 hogi to ans print karke return
          System.out.println(ans);
          return;
        }
        
        for( int i=0; i< str.length(); i++){
            String left = str.substring(0, i+1); //string ka left part nikal liye
            if( dict.contains(left)){//agar dictionary ke andar yeh left part word hua to ise use karenge
               String right = str.substring(i+1);
               //pure sentence mere left part nikalaa to right bacha to right upar jayega aur ans ke andar left part add kardenge aur sathme space add karenge
                wordBreak(right, ans + left + " ", dict);
            }
        }
        
    }
    
    public static void main(String[] args) {
    
        Scanner s = new Scanner(System.in);
        int n= s.nextInt();
        HashSet<String> dict = new HashSet<>();
        for( int i=0; i< n; i++){
            dict.add(s.nextInt());
        }
        String sentence = s.nextInt();
        wordBreak(sentence, "", dict);
    }
}
