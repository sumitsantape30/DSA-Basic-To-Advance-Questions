Prefix Evaluation And Conversions
1. You are given a prefix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to postfix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
Input Format
Input is managed for you
Output Format
value, a number
infix
prefix

Constraints
1. Expression is a valid prefix expression
2. The only operators used are +, -, *, /
3. All operands are single digit numbers.
Sample Input
-+2/*6483
Sample Output
2
((2+((6*4)/8))-3)
264*8/+3-

Code:

package Stack;

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvaNCon {
	
	public static int operation( int v1, int v2, char optor) { // actual operation jisme value 1 value 2 ayegi aur operation ayega
		if( optor== '+') {
			return v1+v2;
		}else if( optor== '-'){
			return v1- v2;
		}else if( optor == '*') {
			return v1*v2;
		}else { 
			return v1/v2;
		}
	}
	
	public static void EvaCon(String exp) {
		
		Stack<Integer> vs= new Stack<>(); //value stack
		Stack<String> is= new Stack<>(); //infix stack
		Stack<String> ps= new Stack<>(); //postfix stack
		
		// hum ulta loop chalate hai isme
		for( int i= exp.length() -1 ; i >= 0; i--) {
			
			char ch= exp.charAt(i);
			
			if( ch == '+' || ch== '-' || ch=='*' || ch== '/') {
				int v1= vs.pop(); //uparwale ko vzlue 1 bola jayega usko pop karenge
				int v2= vs.pop();
				int val= operation(v1, v2, ch);
				// operation karke wapas push kardenge
				vs.push(val);
				
				//same kam hum infix and postfix keliye bhi karenge
				String inv1= is.pop(); 
				String inv2= is.pop();
				String inval= "(" + inv1 + ch + inv2 + ")";
				is.push(inval);
				
				String posv1= ps.pop(); 
				String posv2= ps.pop();
				String posval=  posv1 + posv2+ ch; //post wali stack mai bracket ka koi fanda nhi hota
				ps.push(posval);
				
			}else {
				//aur operand mese koi hoga to hum sirf push kiya krte hai
				vs.push(ch - '0'); //value stack integers ki stack hai to integers mai convert kare
				//baki dono string ki stack hai to string mai convert karenge character ko
				is.push(ch + "");
				ps.push(ch + "");
			}
		}
		
	  System.out.println(vs.peek());
	   System.out.println(is.peek());
	   System.out.println(ps.peek());

	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		String str= s.next();
		EvaCon(str);
	}
}

