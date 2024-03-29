Queue To Stack Adapter - Pop Efficient

1. You are required to complete the code of our QueueToStackAdapter class. 
2. As data members you've two queues available - mainQ and helperQ. mainQ is to contain data and helperQ is to assist in operations. (This is cryptic - take hint from video)
3. Here is the list of functions that you are supposed to complete
     3.1. push -> Should accept new data in LIFO manner.
     3.2. pop -> Should remove and return data in LIFO manner. If not available, print 
     "Stack underflow" and return -1.
    3.3. top -> Should return data in LIFO manner. If not available, print "Stack 
    underflow" and return -1.
    3.4. size -> Should return the number of elements available in the stack.
4. Input and Output is managed for you.

Note -> pop, top and size should work in constant time. push should work in linear time.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
Note -> pop, top and size should work in constant time. push should work in linear time.
Sample Input
push 10
push 20
push 5
push 8
push 2
push 4
push 11
top
size
pop
top
size
pop
top
size
pop
top
size
pop
top
size
pop
top
size
pop
top
size
pop
quit

Sample Output
11
7
11
4
6
4
2
5
2
8
4
8
5
3
5
20
2
20
10
1
10

Code:

package practice;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Code {
	

	  public static class QueueToStackAdapter {
	    Queue<Integer> mainQ;
	    Queue<Integer> helperQ;

	    public QueueToStackAdapter() {
	      mainQ = new ArrayDeque<>();
	      helperQ = new ArrayDeque<>();
	    }

	                    int size() {
			    	return mainQ.size();
			     }

			    void push(int val) {
			    	while(mainQ.size() != 0) {// jabtak q1 ka size 0 nhi hojata q1 se remove karo aur q2 mai add karo
			    		helperQ.add(mainQ.remove());
			    		
			    	}
			    	//ab jo naya banda aya hai usko q1 mai add krdo
			    	mainQ.add(val);
			    	
			    	//aur dubara sare q2 ke bande q1 mai chahiye 
			    	while(helperQ.size() != 0) { //jabtak q2 ka size 0 nhi hojata q2 se remove aur q1 mai add kro
			    		mainQ.add(helperQ.remove());
			    		
			    	}
			    	
			    }

			    int pop() {
			    	if(mainQ.size() == 0) {
			    		System.out.println("Stack underflow");
			    		return -1;
			    	}
			    	return mainQ.remove();  // queue mai aagese front wala element remove hoga to humesha topmost banda front pe hona chahiye isko achieve karne keliye push function hume likhna hoga
			    }

			    int top() { // top will be exactly similar to pop bas yahape remove nhi karenge peek bta denge iski 
			    	if(mainQ.size() == 0) {
			    		System.out.println("Stack underflow");
			    		return -1;
			    	}
			    	return mainQ.peek(); 
			    }
	  }

	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    QueueToStackAdapter st = new QueueToStackAdapter();

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
	      }
	      str = br.readLine();
	    }
	  }
	}
