Duplicate Brackets

1. You are given a string exp representing an expression.
2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
3. But, some of the pair of brackets maybe extra/needless. 
4. You are required to print true if you detect extra brackets and false otherwise.

e.g.'
((a + b) + (c + d)) -> false
(a + b) + ((c + d)) -> true
Input Format
A string str
Output Format
true or false
Question Video


Constraints
0 <= str.length <= 100
Sample Input
(a + b) + ((c + d))
Sample Output
true

Code:

package Stack;

import java.util.Stack;
import java.util.Scanner;

public class DuplicateBrackets {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		String str= s.nextLine();

		//so isme hum characters ki stack bnayenge
		Stack<Character> st = new Stack<>();
		
		//ab input pe loop lagayenge
		for( int i=0; i< str.length(); i++) {
			char ch= str.charAt(i); // humko character milgya
			if( ch == ')') { //agar character hai ek closing bracket
				if( st.peek() == '(') { // agar peek mai direct closing bracket milgya means duplicacy hai coz uske andar kuch content hi nhi hai pop hone keliye means woh bracket duplicate hai
					System.out.println("True");
					return; // true print krke code ko terminate kardenge
				}else {
					// otherwise tabtak pop krte rahenge jabtak peek pr opening bracket na ajaye 
					while( st.peek() != '(' ) {
						st.pop();
					}
					st.pop(); //last mai ek pop extra karenge coz opening bracket kobhi udana hai
				}
				
			}else { // agar woh character opening bracket or abc hai to sirf push karenge
				st.push(ch);
			}
		}
		
		//string khatam hogyi hai aur duplicacy nhi mili hai to false print krde
		System.out.println("false");
		
	}

}

Analysis -:
Time Complexity : O(n)

The time complexity of the above algorithm is O(n) as we are traversing a string of length n once. What about the push and pop operations then? Come on, you already know they take O(1) time, right? So, the only thing affecting the time complexity is the traversing of the string.


Space Complexity : O(n)

The space complexity is O(n). Why? We are continuously popping and pushing the elements from the stack. 
So why O(n)? Well, let me ask you a question. What can be the maximum size of the stack? 
	Yes, it can be equal to the length of the string if we can input the string with all opening brackets. 
It is after the string gets completely scanned that we will realize that the brackets are not balanced. Otherwise, we keep on pushing all the opening brackets into the stack.
