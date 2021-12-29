Minimum Stack - I

1. You are required to complete the code of our MinStack class. 
2. As data members you've two stacks available in the class - one for data values and another for minimum values. (This is cryptic - take hint from video)
2. Here is the list of functions that you are supposed to complete
2.1. push -> Should accept new data in LIFO manner
2.2. pop -> Should remove and return data in LIFO manner. If not available, print "Stack underflow" and return -1.
2.3. top -> Should return data in LIFO manner. If not available, print "Stack underflow" and return -1.
2.4. size -> Should return the number of elements available in the stack
2.5. min -> Should return the smallest element available in the stack. If not available, print "Stack underflow" and return -1.
3. Input and Output is managed for you.

Note -> The judge maynot be able to check if all your functions are O(1) in time, but that is what the expectation is. 

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

import java.util.Stack;

public class MinimumStack1 {
//================================== Submitted Code=====================================
	//yahape hum ek extra stack use kr rhe hai means O(n) Space hai so kya hum sirf ek hi stack se yahi kam achieve kr skte hai yeh next question mai dekhenge
import java.io.*;
import java.util.*;

public class Main {

  public static class MinStack {
		    Stack<Integer> allData;
		    Stack<Integer> minData;
	  
		    public MinStack() {
		      allData = new Stack<>();
		      minData = new Stack<>();
		    }
	  
		    int size() {
				return allData.size();
		    }
	  
		    void push(int val) {
		      allData.push(val); //all data mai push karna hi hai
		      
		      //aur minData mai tab push karna hai jab value choti hai minData ke peek se aur jab minData ka size 0 ho
		      if(minData.size()==0 || val <= minData.peek()) {
		    	  minData.push(val);
		      }
		    }
	  
		    int pop() {
		    	if(size() == 0) {
		    		System.out.println("Stack Underflow");
		    		return -1;
		    	}
		    		int val= allData.pop();
		    		//agar yahi value minData ke peek pe dikhi to woh bhi pop hota hi hai
		    		if( val == minData.peek()) {
		    			minData.pop();
		    		}
		    		return val;
		    	
		    }
	  
		    int top() {
		    	if(size() == 0) {
		    		//agar size 0 hua -1 return karenge
		    		System.out.println("Stack Underflow");
		    		return -1;
		    	}else {
		    		return allData.peek();
		    	}
		    }
	  
		  //1.jo content abhitak dala gya hai stack mai usme jo sabse chota hai woh O(1) milna chahiye
		   //jab value minData stack ke peek se choti aati hai tab dono taraf push karna hota hai, so ab top() dete waqt allData stack ka top denge and min dete waqt minData stack se dejiye
		    int min(){
		    	if(size() == 0) {
		    		//agar size 0 hua -1 return karenge
		    		System.out.println("Stack Underflow");
		    		return -1;
		    	}else {
		    		return minData.peek();
		    	}
		    }
		 }
		  public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    MinStack st = new MinStack();
		    String str = br.readLine();
		    while(str.equals("quit") == false){
		      if(str.startsWith("push")){
		        int val = Integer.parseInt(str.split(" ")[1]);
		        st.push(val);
		      } else if(str.startsWith("pop")){
		        int val = st.pop();
		        if(val != -1){
		          System.out.println(val);
		        }
		      } else if(str.startsWith("top")){
		        int val = st.top();
		        if(val != -1){
		          System.out.println(val);
		        }
		      } else if(str.startsWith("size")){
		        System.out.println(st.size());
		      } else if(str.startsWith("min")){
		        int val = st.min();
		        if(val != -1){
		          System.out.println(val);
		        }
		      }
		      str = br.readLine();
		    }
		  }
		}
	
//======================================== THis has some error============================================
	 public static class MinStack {
		    Stack<Integer> allData;
		    Stack<Integer> minData;

		    public MinStack() {
		      allData = new Stack<>();
		      minData = new Stack<>();
		    }

		    int size() { //stack1 ka size return kardiya
			return allData.size();
		    }

		    void push(int val) { // agar push karna hai to dono stack mai push karenge
		      allData.push(val); //all data mai push karna hi hai
		      
		      //aur minData mai tab push karna hai jab value choti hai minData ke peek se aur jab minData ka size 0 ho
		      if(minData.size()==0 || val <= minData.peek()) {
		    	  minData.push(val);
		      }
		    }
		 
		 /*  void push( int val){
			   if(allData.size() == 0){
				   allData.push(val);
				   minData.push(val);
			   }else{
				   allData.push(val);
				   minData.push(Math.min(val, minData.peek())); //jab current value aur minData ke peek mese jo choti ho wahi minData mai push hoga
			   }
		   } */

		    int pop() {
		    	 if(size() == 0) {
		    		System.out.println("Stack Underflow");
		    		return -1;
		    	} 
		    		int val= allData.pop();
		    		
		    		//agar yahi value minData ke peek pe dikhi to woh bhi pop hota hi hai
		    		if( val == minData.peek()) {
		    			minData.pop();
		    		}
		    		return val;
		    	}  
			    /* minData.pop();
			    return allData.pop(); //dono stack mese pop lagaya, aur value uski stack1 wale ki return karenge */
		    }

		    int top() {
		    	if(size() == 0) {
		    		//agar size 0 hua -1 return karenge
		    		System.out.println("Stack Underflow");
		    		return -1;
		    	}/*else {
		    		return allData.peek();
		    	}*/
			    return allData.peek();
		    }

		  //1.jo content abhitak dala gya hai stack mai usme jo sabse chota hai woh O(1) milna chahiye
		   //jab value minData stack ke peek se choti aati hai tab dono taraf push karna hota hai, so ab top() dete waqt allData stack ka top denge and min dete waqt minData stack se dejiye
		    int min(){
		    	if(size() == 0) {
		    		//agar size 0 hua -1 return karenge
		    		System.out.println("Stack Underflow");
		    		return -1;
		    	}
		    	  return minData.peek();
		    }
		 }

		  public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    MinStack st = new MinStack();

		    String str = br.readLine();
		    while(str.equals("quit") == false){
		      if(str.startsWith("push")){
		        int val = Integer.parseInt(str.split(" ")[1]);
		        st.push(val);
		      } else if(str.startsWith("pop")){
		        int val = st.pop();
		        if(val != -1){
		          System.out.println(val);
		        }
		      } else if(str.startsWith("top")){
		        int val = st.top();
		        if(val != -1){
		          System.out.println(val);
		        }
		      } else if(str.startsWith("size")){
		        System.out.println(st.size());
		      } else if(str.startsWith("min")){
		        int val = st.min();
		        if(val != -1){
		          System.out.println(val);
		        }
		      }
		      str = br.readLine();
		    }
		  }
		}
