Normal Queue

1. You are required to complete the code of our CustomQueue class. The class should mimic the behaviour of a Queue and implement FIFO semantic.
2. Here is the list of functions that you are supposed to complete
     2.1. add -> Should accept new data if there is space available in the underlying 
     array or print "Queue overflow" otherwise.
     2.2. remove -> Should remove and return value according to FIFO, if available or 
     print "Queue underflow" otherwise and return -1.
     2.3. peek -> Should return value according to FIFO, if available or print "Queue 
     underflow" otherwise and return -1.
     2.4. size -> Should return the number of elements available in the queue.
     2.5. display -> Should print the elements of queue in FIFO manner (space- 
     separated) ending with a line-break.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

None
Sample Input
5
add 10
display
add 20
display
add 30
display
add 40
display
add 50
display
add 60
display
peek
remove
display
peek
remove
display
peek
remove
display
peek
remove
display
peek
remove
display
peek
remove
quit
Sample Output
10 
10 20 
10 20 30 
10 20 30 40 
10 20 30 40 50 
Queue overflow
10 20 30 40 50 
10
10
20 30 40 50 
20
20
30 40 50 
30
30
40 50 
40
40
50 
50
50

Queue underflow
Queue underflow



Code:

import java.io.*;
import java.util.*;

public class Main {

  public static class CustomQueue {
    int[] data;
    int front;
    int size;

    public CustomQueue(int cap) {
      data = new int[cap];
      front = 0;
      size = 0;
    }

    int size() {
      return size;
    }

    void display() {
      // write ur code here
      for(int i = 0; i < size; i++){ //size jitne bande print honga
        int idx = (front + i) % data.length; //aur printing 
        System.out.print(data[idx] + " ");
        //System.out.println(data[(front+i)% data.length] + " ");
      }
      System.out.println();
    }

    // change this code
    void add(int val) {
      if(size == data.length){
        System.out.println("Queue overflow");
        return;
      } 
        int rear = (front + size) % data.length; // rear end nikalte hai aur rear end nikalke modulo bhi lena hota hai 
        data[rear] = val;
        size++;
    }

    int remove() {
      if(size == 0){ //size hi 0 hai to kisko remove karoge
        System.out.println("Queue underflow");
        return -1;
       } 
        int val = data[front];
        front = (front + 1) % data.length; //remove karne ke bad front ko ek kadam aage badhana hoga
        size--; 

        return val;
    }

    int peek() {
       // write ur code here
       if(size == 0){
        System.out.println("Queue underflow");
        return -1;
       }
        int val = data[front];
        return val;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomQueue qu = new CustomQueue(n);

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("add")){
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if(str.startsWith("remove")){
        int val = qu.remove();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("peek")){
        int val = qu.peek();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(qu.size());
      } else if(str.startsWith("display")){
        qu.display();
      }
      str = br.readLine();
    }
  }
}
