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
		if( optor== '+' || optor== '-') {
			return 1;
		}else if( optor == '*' || optor== '/') {
			return 2;
		}else { 
			return 0;
		}
		// + and - keliye 1 return karre aur / * keliye 2 return karre
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
		Stack<Integer> st1= new Stack<Integer>();
		Stack<Character> st2= new Stack<Character>();
		
		//fir string ke upar loop lagayenge
		for( int i=0; i< exp.length(); i++) {
			char ch= exp.charAt(i);
			
			 if(Character.isDigit(ch)) { //yafir woh character koi digit ho skta hai, digit ko aise check krte hai. // if( ch >= '0' && ch <= '9') yeh bhi condition use kr skte ho
				//agar woh digit hai to operands mai push kardo but usko character se number mai convert karna
				st1.push(ch - '0');
			
			 //ab woh character ab kya kya ho skta hai
			}else if( ch == '(') { //woh character opening bracket ho skta hai
				//agar woh opening bracket hai to operators stack mai mai push kardo
				st2.push(ch);
				
			}else if(ch == '+' || ch== '-' || ch =='/' || ch=='*') { // yafir yeh ek operator ho skta hai
				//ch is wanting higher priority operators to solve first
					
				      // agar stack ki top pe merese equal or jada precidence ka banda hai to usko solve karunga tabhi mai jaunga
					//isme tabtak pop hota hai jabtak size grater than 0 hai aur peek pr opening bracket nhi hai, yafir humko unko pop krte hai jo precedence mai greater than equal hai
					while(st2.size() > 0 && precedence(st2.peek()) >= precedence(ch)) { //peek wale ki priority badi ya barbar aapse(ch) hai to pop hota rahega
						
						// ab wahi kam karenge, operator mese ek pop hoga and operands mese 2 pop honge and fir calculate krke wapas operand mai push kardenge
							char optor= st2.pop();
							int v2= st1.pop(); 
							int v1= st1.pop(); 
							
							int res = operation(v1, v2, optor); 
							st1.push(res);
						}
						//aur finally jo aapka apna operator hai usko push karna na bhule, woh keh rha ki mujse badi priority walo ko pehle process karadu then ch will push itself
						st2.push(ch);
			}else if( ch == ')') { //yafir yeh ek closing bracket bhi ho skta hai, closing bracket mila to tabtak solve karenge jabtak opening bracket nhi mil jata
				//closing brack hai to tabtak pop hoga jabtak ek opening brack nazar na ajaye aur fir ek aur pop karenge coz opening bracket kobhi nikalna hai
				while( st2.peek() != '(') { // jatab stack2 ke top pe opening nhi ajata
					//jab operators mai ek pop krte hai to operands mai do pop krte hai
					char optor= st2.pop();
					int v2= st1.pop(); // jo pehle niikala uska nam v2 rakha
					int v1= st1.pop(); //jo badme nikala uska nam v1 rakha
					
					//ab hum operation karke value mangayenge
					int res = operation(v1, v2, optor); // v1 v2 and opertor pass karenge
					//aur operands mai push karenge operation ki value
					st1.push(res);
				}
				
				//ek aur pop karenge coz opening bracket kobhi nikalna hai
				st2.pop(); //pop the opening bracket
				
			}
		}
			
			//last mai ho skta hai ki kuch operators stack mai reh jaye
			//yeh sab hoone ke bad bhi kuch operator bach skte hai to unko bhi handle karna padega
			while( st2.size() != 0) {
				char optor= st2.pop();
				int v2= st1.pop(); 
				int v1= st1.pop(); 
				
				int res = operation(v1, v2, optor); 
				st1.push(res);
			}
			
			//aur finally jo operands stack mai aakhri calculated banda bachega woh humara answer hoga
			System.out.println(st1.peek());
			//System.out.println(st1.pop()); bhi use kr skte ho
	       }

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		String str= s.next();
		infixEva(str);
		
	}

}
