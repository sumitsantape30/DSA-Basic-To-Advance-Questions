Infix Conversions

1. You are given an infix expression.
2. You are required to convert it to postfix and print it.
3. You are required to convert it to prefix and print it.
Input Format
Input is managed for you
Output Format
postfix
prefix


Constraints
1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.
Sample Input
a*(b-c+d)/e
Sample Output
abc-d+*e/
/*a+-bcde

*/
Code:

package Stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixConversions {
	
	public static int precedence( char optor) { //yeh function operator ki precedence dega
		if( optor== '+') {
			return 1;
		}else if( optor== '-'){
			return 1;
		}else if( optor == '*') {
			return 2;
		}else { //yafir operator divide ho
			return 2;
		}
		// + and - keliye 1 return karre aur /* keliye 2 return karre
	}
	
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
	
	public static void infixConversion( String exp) {
		
		Stack<String> postfix= new Stack<>();
		Stack<String> prefix= new Stack<>();
		Stack<Character> ops= new Stack<>(); //operators
		
		for( int i=0; i< exp.length(); i++) {
			char ch= exp.charAt(i);
			
			//ab yeh character kya kya ho skta hai
			if( ch == '(') {
				// opening bracket hai to push kardo
				ops.push(ch);
			}else if((ch >= '0' && ch<= '9') ||
					(ch >= 'a' && ch <= 'z') ||
					(ch >= 'A' && ch <= 'Z')){ // agar woh single digit ka operand hai(meaning order wise): (ya to woh ek digit hai && ya woh choti wali abcd hai) || (ya woh small a se bada && small a se chota) || (ya woh capital A se bada && aur capital A se chota ) baiscally woh single digit kahi perand hai 
				//agar koi operand hai to prefix and postifx mai daldo bas usko string mai convert karna hoga coz woh <string> ki hi staack hai. character mai doublequote add kiya to woh string mai convert hojayega
				postfix.push(ch+ "");
				prefix.push(ch+ "");
				
			}else if( ch == ')') {
				//clsing bracket hai to kam tabtak hota hai jabtak operators mai peek pr opening bracket'(' nazar na aaye tabtak hum kuch krte rehte hai uske bad bhi ek pop lagate hai actually opening bracket ko pop krte hai
				while( ops.peek() != '(') {
					process(ops, postfix, prefix);
				}
				
				// jatbtak opning bracket nhi ata tabtak pop kiye fir opening bracket kobhi pop krte hai
				ops.pop(); //popping the opening bracket
				
			}else if( ch == '+' || ch == '-' || ch == '*' || ch== '/') {
				// agar operator ka size grater than 0 hai to pop hota rahega aur jabtak opening bracket nhi milta aur aur hight aur equal priority tak hi pop hota hai
				while(ops.size()> 0 &&
						ops.peek() != '(' &&
						precedence(ch) <= precedence(ops.peek())) {
					process(ops, postfix, prefix);
				}
				
				//last mai pop nhi krte hum apne operator ko push krdete hai
				ops.push(ch); //pushing current operator
			}
		}
			
			//loop se bahar aane ke bad yeh code firse ata hai coz ho skta hai ki stack puri khali na hui ho, stack mai kuch bacha hua ho to jo last mai bache hue characters hai unko process karne keliye yeh use krte hai
			while( ops.size() > 0) {
				process(ops, postfix, prefix); //tabtak process kariya jabtak size grater than 0 hai
			}
			
		//ab post and pre mai jo aakhri banda bacha hai usko pop karke print krdo
		System.out.println(postfix);
		System.out.println(prefix);
  }
	
	
	public static void process(Stack<Character>ops, Stack<String> prefix, Stack<String> postfix) {
		
		char op= ops.pop(); //sabse pehle operators mese ek pop krte hai, op= operator
		
		String postv2= postfix.pop(); //upar wali value v2 hoti hai
		String postv1= postfix.pop();
		
		String postv= postv1 + postv2 + op;
		//isko post mai push krdenge
		postfix.push(postv);
		
		// ab same kam hum prefix ke andar bhi karenge
		String prev2= prefix.pop(); 
		String prev1= prefix.pop();
		String prev= op+ prev1 + prev2 ; //pre ke andar operator pehle lagta hai
		prefix.push(prev);
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		String str= s.next();
		infixConversion(str);
	}
}

//==============================================================JB's method================================================
package Stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation2 {
	
	public static int precedence( char optor) { //yeh function operator ki precedence dega
		if( optor== '+') {
			return 1;
		}else if( optor== '-'){
			return 1;
		}else if( optor == '*') {
			return 2;
		}else { //yafir operator divide ho
			return 2;
		}
		// + and - keliye 1 return karre aur /* keliye 2 return karre
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str = s.next();

		Stack<String> st1 = new Stack<>(); // prefix
		Stack<Character> st2 = new Stack<>(); // operators
		Stack<String> st3 = new Stack<>(); // postfix

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch >= 'a' && ch <= 'z') { // operand ka case
				//koi operand ata hai to stack 1 aur stack 3 mai push krdo
				st1.push(ch + "");
				st3.push(ch+ "");

			} else if (ch == '(') { // agar opening bracket ata hai to stack 2 mai push krdo
				st2.push(ch);
 
			} else if (ch == ')') { 
				// jabtak opening bracket nhi mil jata mai pop lagaunga stack2 se
				while( st2.peek() != '(') {
					char oprtr= st2.pop();
					String op2= st1.pop();
					String op1= st1.pop();
					//stack 1 mai prefix chahiye to pehle operator ayega then operand 1 and then operand 2
					st1.push(oprtr + op1 + op2); //yeh prefix ka handle kiya
					
					//postfix kabhi handle karenge
					String o2= st3.pop();
					String o1= st3.pop();
					st3.push(o1+ o2+ oprtr);
					
				} //jabtk opening nhi milta yeh kam krte rahenge
                //finally uss opening bracket kobhi pop karado
				st2.pop();
				
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') { //agar koi bhi operator ata hai
				// woh dekhega kisiki precidence merese equal or jada hai to usko solve karado aur fir merko stack mai push kardo
				
				while(st2.size() > 0 && precedence(st2.peek()) >= precedence(ch)) { //yahabhi similar kam karenge, solve karke apna result daldo
					char oprtr= st2.pop();
					String op2= st1.pop();
					String op1= st1.pop();
					st1.push(oprtr + op1 + op2); //yeh prefix ka handle kiya
					
					//postfix kabhi handle karenge
					String o2= st3.pop();
					String o1= st3.pop();
					st3.push(o1+ o2+ oprtr);
					
				}
				//fir jo operator aya usko stack mai push bhi krdo
				st2.push(ch);
			}
		}
	
	//iss loop se bahar aane ke bad, string pe puri tarah se traverse karne ke bad 
		while (st2.size() != 0) { // jabtak stack2 ka size 0 nhi hojata dubara yahi kam
			char oprtr= st2.pop();
			String op2= st1.pop();
			String op1= st1.pop();
			st1.push(oprtr + op1 + op2); //yeh prefix ka handle kiya
			
			//postfix kabhi handle karenge
			String o2= st3.pop();
			String o1= st3.pop();
			st3.push(o1+ o2+ oprtr);
			
		}
		
		System.out.println(st3.pop());
		System.out.println(st1.pop());
		
	}
}
