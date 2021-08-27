Balanced Brackets
1. You are given a string exp representing an expression.
2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

e.g.
[(a + b) + {(c + d) * (e / f)}] -> true
[(a + b) + {(c + d) * (e / f)]} -> false
[(a + b) + {(c + d) * (e / f)} -> false
([(a + b) + {(c + d) * (e / f)}] -> false
Input Format
A string str
Output Format
true or false

Constraints
0 <= str.length <= 100
Sample Input
[(a + b) + {(c + d) * (e / f)}]
Sample Output
true

Code:
 
 package Stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
	
	public static boolean handleClosing(Stack<Character> st, char corresoch) { //corresponding opening character
		if( st.size() == 0) {
			return false;
		}else if( st.peek() != corresoch) { //agar stack ke top pe iss closing bracket ka corresponsingOpening bracket nhi hai to false
			return false; //false karke return karenge
		}else {
			st.pop(); //else pop krdijiye
			return true;
		}
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		String str= s.nextLine();
		
		//ab charcters ka stack banana padega
		Stack<Character>st= new Stack<Character>();
		for( int i=0; i< str.length(); i++) {
			char ch= str.charAt(i);
			
			if( ch == '(' || ch == '{' || ch== '[') {
				//koi bhi opening bracket rha to push hoga
				st.push(ch);
				 
			}else if( ch == ')') { //agar woh yeh wala closing bracket hai aur stack ka size 0 hua means sabkuch pehle pop hochuka hai means yeh closing extra hai means false karenge
				boolean val= handleClosing(st, '(');
				if( val == false) { //agar val aya false to val ko print krke return
					System.out.println(val);
					return;
				}
				
			}else if( ch == ']') {
				boolean val= handleClosing(st, '[');
				if( val == false) { //agar val aya false to val ko print krke return
					System.out.println(val);
					return;
				}
				
			}else if( ch == '}') {
				boolean val= handleClosing(st, '{' );
				if( val == false) { //agar val aya false to val ko print krke return
					System.out.println(val);
					return;
				}
				
			}else { //aur koi character hai to unko ignore hi karna hai
				//waise else likhne ki jarurat nhi hai
			}
		}
		
		if( st.size() == 0) { //agar code ke bahar aate hai aur stack ka size 0 hai means sab sahi hai
			System.out.println(true);
			
		}else { //agar stack k size 0 nhi hai means opening brackets jada the means false prnt karenge
			System.out.println(false);
			
		}
		
	}
	

}
