Minimum Stack - Constant Space
1. You are required to complete the code of our MinStack class. 
2. As data members you've one stack and a min element available in the class. (This is cryptic - take hint from video)
3. Here is the list of functions that you are supposed to complete
      3.1. push -> Should accept new data in LIFO manner.
      3.2. pop -> Should remove and return data in LIFO manner. If not available, print 
       "Stack underflow" and return -1.
      3.3. top -> Should return data in LIFO manner. If not available, print "Stack 
      underflow" and return -1.
     3.4. size -> Should return the number of elements available in the stack.
     3.5. min -> Should return the smallest element available in the stack. If not 
     available, print "Stack underflow" and return -1.
4. Input and Output is managed for you.

Note -> The judge maynot be able to check if all your functions are O(1) in time, but that is what the expectation is. Also, you can only use constant space.r
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
push 10
push 20
push 5
push 8
push 2
push 4
push 11
top
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
quit
Sample Output
11
2
11
4
2
4
2

Code:
package Stack;

import java.util.Scanner;
import java.util.Stack;

public class MinimumStack2 {

	// ab hum extra space means extra stack nhi lenge, normal variable ko use krke karenge means constant space mai
	 public static class MinStack {
		    Stack<Integer> data;
		    int min;

		    public MinStack() {
		      data = new Stack<>();
		    }

		    int size() {
		    	return data.size();
		    }

		    void push(int val) {
		    	if( data.size() == 0) { //agar data ka size 0 hai to data mai push karenge aur min mai set kardenge
		    		data.push(val);
		    	}else if(val >= min) { //agar value badi or barabr hai min se to keval push krde
		    		data.push(val);
		    	}else {
		    		//khas kam tab krte hai jab value min se choti hoti hai
		    		
		    		//ab value ki jagah ek zuti value store krte hai
		    	   data.push(val+ val - min);// detection, storing a fake smaller value
		    		min= val; // min woh value receive krlete hai (original value stored in min)
		    	}

		    }

		    int pop() {
		    	// humare 2 remove/pop ho rha hai to min reset hona chahiye 
		    	if( size() == 0) {
		    		System.out.println("Stack Underflow");
		    		return -1;
		    	}else {
		    		if( data.peek() >= min) { // agar woh peek min se badi hai to woh sacchi value hoti thi usko return kardo bas
		    			return data.pop();
		    		}else { //agar woh value min se choti hai to min 2min-data.peek() dalo 
		    			int ov= min; //iss case mai original value min mai hoti hai
		    			min= 2 * min - data.pop();
		    			return ov;
		    		}
		    	}
		    }

		    int top() {
		    	if( size() == 0) {
		    		System.out.println("Stack Underflow");
		    		return -1;
		    	}else {
		    		if( data.peek() >= min) {
		    			//agar data ki peek mai min se badi or barabr value hai tab woh thik value hai
		    			return data.peek();
		    		}else {
		    			//agar woh value choti hai min se to woh top value nhi hai woh to fake wali value hai uss waqt original value humne min mai daldi thi
		    			// uss time jo value aayi thi woh humne stack mai dali hi nhi thi woh toh humne min mai daldi thi
		    			//so iss case mai min return karenge
		    			return min;
		    		}
		    	}
		    }

		    int min() {
		    	if( size() == 0) {
		    		System.out.println("Stack Underflow");
		    		return -1;
		    	}else {
		    		return min;
		    	}
		    }
		    
		  }

		  public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    MinStack st = new MinStack();

		    String str = br.readLine();
		    while (str.equals("quit") == false) {
		      if (str.startsWith("push")) {
		        int val = Integer.parseInt(str.split(" ")[1]);
		        st.push(val);
		      } else if (str.startsWith("pop")) {
		        int val = st.pop();
		        if (val != -1) {
		          System.out.println(val);
		        }
		      } else if (str.startsWith("top")) {
		        int val = st.top();
		        if (val != -1) {
		          System.out.println(val);
		        }
		      } else if (str.startsWith("size")) {
		        System.out.println(st.size());
		      } else if (str.startsWith("min")) {
		        int val = st.min();
		        if (val != -1) {
		          System.out.println(val);
		        }
		      }
		      str = br.readLine();
		    }
		  }
		}

//============================================JB's ====================================================================================

 public static class MinStack {
		    Stack<Integer> data;
		    int min;

		    public MinStack() {
		      data = new Stack<>();
		    }

		    int size() {
		    	return data.size(); // data stakc ka jo size hai wahi apna size hoga
		    }

		    void push(int val) {
		    	if(data.size() == 0) { //agar data ka size 0 hai to data bas push kardo aur min bhi set hojayega
		    		data.push(val);
		    		min= val;
		    	}else if( val < min) { //agar current value choti hai mere abtak ke min se to dummy value banake dummy value push karenge
		    		
		    		int dv= 2 * val - min;
		    		data.push(dv); // stack mai push kardenge dummy value aur min ki value update hojayegi val ke equal
		    		min= val;
		    	}else { // agar equal or badi hoti hai to normal push kardenge
		    		data.push(val); 
		    		
		    	}
		    }

		    int pop() { 
		    	if( data.size() == 0) {
		    		System.out.println("stack underflow");
		    		return -1;
		    	}
		    	
		    	if( data.peek() < min) { // agar value choti hai to muje previous min nikalna padega
		    		int rv= min; //yeh min preserve karke rakho
		    		int pmin= 2 * min - data.pop() ; // dummy value apko data.peek() se milti hai hum data.pop() use karenge coz usko remove bhi karna hi hai 
		    		min= pmin;
		    		return rv;
		    	}else { //agar value bdi hoti hai to simply pop
		    		return data.pop();
		    	}
		    }

		    int top() {
		    	if( data.size() == 0) {
		    		System.out.println("Stack underflow");
		    		return -1;
		    	}
		    	
		    	if( data.peek() < min) { // agar data ka peek min se chota hai means dummy value hai to original value min hoti hai
		    		return min;
		    	}else { 
		    		return data.peek();
		    	}
		    }

		    int min() {
		    	if( data.size() == 0) {
		    		System.out.println("Stack underflow");
		    		return -1;
		    	}
		    	//min ki case mai simply return min
		    	return min;
		  }
