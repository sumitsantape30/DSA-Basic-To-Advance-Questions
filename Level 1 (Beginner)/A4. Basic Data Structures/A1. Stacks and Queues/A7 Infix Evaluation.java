Infix Evaluation

1. You are given an infix expression.
2. You are required to evaluate and print it's value.
Input Format
Input is managed for you
Output Format
Value of infix expression

Constraints
1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.
Sample Input
2 + 6 * 4 / 8 - 3
Sample Output
2

code:

package Stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
	
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
	
	public static void infixEva( String exp) {
		
		//2 stacks banani padegi operands and operators ki
		Stack<Integer> opnds= new Stack<Integer>();
		Stack<Character> optors= new Stack<Character>();
		
		for( int i=0; i< exp.length(); i++) {
			char ch= exp.charAt(i);
			
			//woh character ab kya kya ho skta hai
			if( ch == '(') { //woh character opening bracket h skta hai
				//agar woh opening bracket hai to operators stack mai mai push kardo
				optors.push(ch);
				
			}else if(Character.isDigit(ch)) { //yafir woh character koi digit ho skta hai, digit ko aise check krte hai
				//agar woh digit hai to operands mai push kardo but usko character se number mai convert karna
				opnds.push(ch - '0');
				
			}else if( ch == ')') { //yafir yeh ek closing bracket bhi ho skta hai
				//closing brack hai to tabtak pop hoga jabtak ek opening brack nazar na ajaye aur fir ek aur pop karenge coz opening bracket kobhi nikalna hai
				while( optors.peek() != '(') {
					//jab operators mai ek pop krte hai to operands mai do pop krte hai
					char optor= optors.pop();
					int v2= opnds.pop(); // jo pehle niikala uska nam v2 rakha
					int v1= opnds.pop(); //jo badme nikala uska nam v1 rakha
					
					//ab hum operation karke value mangayenge
					int opv = operation(v1, v2, optor); // v1 v2 and opertor pass karenge
					//aur operands mai push karenge operation ki value
					opnds.push(opv);
				}
				
				//ek aur pop karenge coz opening bracket kobhi nikalna hai
				optors.pop();
				
			}else if(ch == '+' || ch== '-' || ch =='/' || ch=='*') { // yafir yeh ek operator ho skta hai
				//ch is wanting higher priority operators to solve first
				
					//isme tabtak pop hota hai jabtak size grater than 0 hai aur peek pr opening bracket nhi hai, yafir humko unko pop krte hai jo precedence mai greater than equal hai
					while(optors.size() > 0 && optors.peek() != '(' && precedence(ch) <= precedence(optors.peek())) { //peek wale ki priority badi ya barbar aapse(ch) hai to pop hota rahega
						
						// aur bichme ab wahi kam karenge jo upar kiye the
						if( optors.peek() != '(') {
							char optor= optors.pop();
							int v2= opnds.pop(); 
							int v1= opnds.pop(); 
							
							int opv = operation(v1, v2, optor); 
							opnds.push(opv);
						}
						//aur finally jo aapka apna operator hai usko push karna na bhule, woh keh rha ki mujse badi priority walo ko pehle process karadu then ch will push itself
						optors.push(ch);
				}
			}
			
			//yeh sab hoone ke bad bhi kuch operator bach skte hai to unko bhi handle karna padega
			while( optors.size() != 0) {
				char optor= optors.pop();
				int v2= opnds.pop(); 
				int v1= opnds.pop(); 
				
				int opv = operation(v1, v2, optor); 
				opnds.push(opv);
			}
			
			//aur finally jo perands stack mai aakhri banda bachega woh humara answer hoga
			System.out.println(opnds.peek());
		}
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		String str= s.next();
		infixEva(str);
		
	}

}
