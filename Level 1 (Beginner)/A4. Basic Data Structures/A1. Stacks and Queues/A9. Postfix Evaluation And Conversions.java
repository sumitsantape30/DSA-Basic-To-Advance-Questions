Postfix Evaluation And Conversions

1. You are given a postfix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to prefix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
Input Format
Input is managed for you
Output Format
value, a number
infix
prefix

Constraints
1. Expression is a valid postfix expression
2. The only operators used are +, -, *, /
3. All operands are single digit numbers.
Sample Input
264*8/+3-
Sample Output
2
((2+((6*4)/8))-3)
-+2/*6483

Code:

package Stack;

import java.util.Scanner;
import java.util.Stack;

public class PostfixExpressions {

//muje input mai postfix expression mili hai isme brackets bhi nhi honge aur sare operators unke precedence wise hi honge so brackets aur precedence wala scene nhi hai isliye operators ki stack rakhne ki jarurat nhi hai
	
	public static int operation( int v1, int v2, char op) {
		
		if( op == '+') {
			return v1+v2;
		}else if( op == '-') {
			return v1-v2;
		}else if( op == '*') {
			return v1*v2;
		}else {
			return v1/v2;
		}
	}
	
	public static void postfixCon(String exp) {
		
		// integer ka stack banayenge thats integer ka
		Stack<Integer> vs = new Stack<Integer>(); //value stack
		Stack<String> is= new Stack<>(); //infix stack of integer
		Stack<String> ps= new Stack<>(); // postfix stack
		
		for( int i= 0; i<exp.length(); i++ ) {
			char ch= exp.charAt(i);
			
			//ab hume dekhna hai woh operand hai ki operator hai
			if( ch == '+' || ch== '-' || ch== '*' || ch== '/') { //agar koi operator ayega to mai 2 pop lagaunga, 1 stack mese 2 pop lagaye aur result banake dubara stack mai push kardenge
				
				int op2= vs.pop() ; //upar wala hai v2
				int op1= vs.pop();
				int val= operation(op1, op2, ch); //operation call kar denge iske upar
				
				// jis tarah ka operation hua uss operation ke bad ab value stack mai usko wapas push kardenge
				vs.push(val);
				
				//infix ki values
				String o2= is.pop(); // yeh infix stack se niklega
				String o1= is.pop();
				String ival= "(" + o1+ ch + o2 + ")"; //infix ke andar pehle hota hai opening bracket + fir value 1 + fir hota hai operand which is just character + fir value 2  + fir closing bracket
				//yeh karne ke bad hum infix stack mai infix value ko push kardenge
				is.push(ival);
				
				//yahi lines prefix mai bhi ayegi bas order alag rahega
				String opp2= ps.pop(); // yeh infix stack se niklega
				String opp1= ps.pop();
				String pval= ch + pv1 + pv2; //operator + prefixvalue1+ prefixvalue2
				ps.push(pval);
			
			}else { // number hota hai to stacks mai push krdo
				//operands ke case mai boht simple kam kr rhe hai hum, bas push karna hai 
				vs.push(ch-'0');  //push krte waqt uska integer bana de
				is.push(ch+ ""); //yaha ch ko string mai convert karo
				ps.push(ch+ "");
				
			}
		}
		//bahar nikalke teeno ko print karna hai
		System.out.println(vs.pop());
		System.out.println(is.pop());
		System.out.println(ps.pop());
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		String str= s.next();
		postfixCon(str);
	}

}

