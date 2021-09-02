Normal Stack

1. You are required to complete the code of our CustomStack class. The class should mimic the behaviour of java.util.Stack class and implement LIFO semantic.
2. Here is the list of functions that you are supposed to complete
   2.1. push -> Should accept new data if there is space available in the underlying 
   array or print "Stack overflow" otherwise.
   2.2. pop -> Should remove and return last data if available or print "Stack 
   underflow" otherwise and return -1.
   2.3. top -> Should return last data if available or print "Stack underflow" 
   otherwise and return -1.
   2.4. size -> Should return the number of elements available in the stack.
   2.5. display -> Should print the elements of stack in LIFO manner (space- 
   separated) ending with a line-break.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you


Constraints
None
Sample Input
5
push 10
display
push 20
display
push 30
display
push 40
display
push 50
display
push 60
display
top
pop
display
top
pop
display
top
pop
display
top
pop
display
top
pop
display
top
pop
quit
Sample Output
10 
20 10 
30 20 10 
40 30 20 10 
50 40 30 20 10 
Stack overflow
50 40 30 20 10 
50
50
40 30 20 10 
40
40
30 20 10 
30
30
20 10 
20
20
10 
10
10

Stack underflow
Stack underflow

Code:

package Stack;

import java.util.Scanner;

public class BuildNormalStack {

	 public static class CustomStack {
		    int[] data;
		    int tos; // top of the stack pe konsa element hai iska track rakhne keliye yeh index rakhenge

		    public CustomStack(int cap) {
		      data = new int[cap];
		      tos = -1;
		    }

		    int size() {
		    	return tos+1;
		    }

		    void display() {

		    	for(int i= tos; i>= 0; i--) {
		    		System.out.print(data[i]+" ");
		    	}
		    	
		    	System.out.println();
		    }

		    void push(int val) {
		    	if( size()== data.length) {
		    		System.out.println("Stack Overflow");
		    	}
		    	tos++;
		    	data[tos]= val;
		    }

		    int pop() {
		    	if( size() == 0) {
		    		System.out.println("Stack Underflow");
		    		return -1;
		    	}
		    	
		    	int temp= data[tos];
		    	tos--;
		    	return temp;
		    }

		    int top() {
		    	if( size() == 0) {
		    		System.out.println("Stack Underflow");
		    		return -1;
		    	}
		    	return data[tos];
		    }
		  }

		  public static void main(String[] args) throws Exception {
		   Scanner s= new Scanner(System.in);
		   String str= s.next();
		   
		   CustomStack st= new CustomStack(10);
		   
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
		      } else if(str.startsWith("display")){
		        st.display();
		      }
		    }
		  }
		}
