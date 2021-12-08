Remove Invalid Parenthesis

1. You are given a string, which represents an expression having only opening and closing parenthesis.
2. You have to remove minimum number of parenthesis to make the given expression valid.
3. If there are multiple answers, you have to print all of them.

Note -> Check out the question video and write the recursive code as it is intended without changing signature. The judge can't 
               force you but intends you to teach a concept.
Input Format
A string containing only opening and closing parenthesis
Output Format
Print all the Valid expressions.
Check the sample ouput and question video.

Constraints
1 <= length of string <= 20
Sample Input
()())()
Sample Output
(())()
()()()

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void solution(String str, int mra, HashSet<String> ans) { // mra = minimum removals allowed
    if (mra == 0) { // agar removal decrease krte krte minimum removals allowed 0 hogyi ho to return karna hai. jitni removals allowed thi utni karli iske bad call lagaoge to extra removal hojayegi, yahapr print karna nhi karna woh uss chiz pe depend krta hai jo aap string leke aaye ho woh valid hai ya nhi
      
      //jo bhi string generate hoke aayi hai uske andar minimum removals 0 lag rhe hai to yeh mera jawab hai
      int mrnow = getMin(str); //yahapr apke pas jo string pdi hai uske liye minimum removals allowed nikal lo ki jo aap string leke aaye ho uske liye kitne removals chahiye
      if (mrnow == 0) { // agar removal 0 hai to aap already balanaced hai
        //ab koi removal nhi chahiye to isko print kiya ja skta hai
        if(!ans.contains(str)){ // agar answer haset isko already contain krta hai to yeh dublicate hai hai so ans nhi contain krta hai tohi print kare
            System.out.println(str);
            ans.add(str); //aur ans mai add karle
        }
      }
      return;
    }

    //har character ko pehle level pr pehle removal karenge, har character ko remove hone ki option denge (tu remove hota to kya hota)
    for(int i = 0; i < str.length(); i++) {
      // i ko remove karna hai to i ke pehle ka content chahiye
      String left = str.substring(0, i);// i se pehle ka content
      String right = str.substring(i + 1);
      solution(left + right, mra - 1, ans); // left + right aage pass kiya to apka character chut gya hai aur minimum allowed removals mese ek kam krdo kyuki ek removal apne use karli hai
    }
  }

  public static int getMin(String str) { // expression mese kitne brackets remove kiya jaye ki woh balanced hojaye

    Stack<Character> st = new Stack<>();

    for(int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if(ch == '(') { // agar character opening ho to sidha push hota hai
        st.push(ch);
      } else if (ch == ')') { //agar character closing bracket hai
         
         if(st.size() == 0) { // closing brcket hai aur stack ka size 0 hai, iss closing ko opening mila nhi to push krdenge
          st.push(ch);
        }else if (st.peek() == ')') { // agar closing aya hai aur stack ki top pebhi closing hi pda hai tobhi invalid hai to isko bhi push krdende
          st.push(ch);
        }else if (st.peek() == '(') { // agar stack ki top pe pda hai opening to pop krdenge
          st.pop();
        }
      }
    }
    return st.size(); // jitne stack mai end mai reh gye hai woh sare invalid hai
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    int mr = getMin(str);// minimum removals
    solution(str, mr, new HashSet<>()); // actual remove krke print karna hai ki kitna removal ho skta hai
    //dublicates generate na ho isliye hashet banaya hai
  }

}
