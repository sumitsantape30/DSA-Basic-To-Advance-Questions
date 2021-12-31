Stack To Queue Adapter - Remove Efficient

1. You are required to complete the code of our StackToQueueAdapter class. The class should mimic the behaviour of a Queue and implement FIFO semantic.
2. Here is the list of functions that are written in the class
    2.1. add -> Accepts new data if there is space available in the underlying array or 
    print "Queue overflow" otherwise.
    2.2. remove -> Removes and returns value according to FIFO, if available or print 
    "Queue underflow" otherwise and return -1.
    2.3. peek -> Returns value according to FIFO, if available or print "Queue 
    underflow" otherwise and return -1.
    2.4. size -> Returns the number of elements available in the queue.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
Note -> remove, peek and size should work in constant time. add should work in linear time.
Sample Input
add 10
add 20
add 30
add 40
add 50
remove
remove
add 60
add 70
peek
remove
peek
remove
peek
remove
peek
remove
peek
remove
peek
remove
quit
Sample Output
10
20
30
30
40
40
50
50
60
60
70
70
Queue underflow
Queue underflow

COde:

import java.io.*;
import java.util.*;

public class Main {

  public static class StackToQueueAdapter {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
      helperS = new Stack<>();
    }

    //4. main stack ke andar hi aap sara content rakhte hai so uska hi size return karo
    int size() {
        return mainS.size();
    }

   //1.
    void add(int val) {
      
      while( mainS.size() > 0){ //jabtak main stack mai elements hai
          helperS.push(mainS.pop()) ; // main stack se remove karke helper stack mai dalte rhe
      }
      //ab main stack khaliho chuki hai to nayi value ko push krde
      mainS.push(val);
      
      //ab helper stack se wapas apni values lekar aaye
      while( helperS.size() > 0){
          //aur ab helper stack se pop hokar main stack mai add hoga
          mainS.push(helperS.pop());
      } //jo sabse purani value hogi woh sabse upar hogi so iska fayda aap remove mai kr skte ho
    }
    
    //2.
    int remove() {
        if(size()== 0 ){
            System.out.println("Queue underflow");
            return -1;
        }
      return mainS.pop(); //main stack ke top pe sabse purani value pdi hai to usko pop krdenge
    }
    
    //3. remove jaisahi same kam karenge but yaha pop karneki jarurat nhi hai peek hi karo and return it
    int peek() {
        if(size()== 0 ){
            System.out.println("Queue underflow");
            return -1;
        }
      return mainS.peek(); 
      
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StackToQueueAdapter qu = new StackToQueueAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}

