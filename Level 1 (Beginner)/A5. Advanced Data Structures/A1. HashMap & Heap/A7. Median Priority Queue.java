Median Priority Queue

1. You are required to complete the code of our MedianPriorityQueue class. The class should mimic the behaviour of a PriorityQueue and give highest priority to median of it's data.
2. Here is the list of functions that you are supposed to complete
2.1. add -> Should accept new data.
2.2. remove -> Should remove and return median value, if available or print "Underflow" otherwise and return -1
2.3. peek -> Should return median value, if available or print "Underflow" otherwise and return -1
2.4. size -> Should return the number of elements available
3. Input and Output is managed for you.

Note -> If there are even number of elements in the MedianPriorityQueue, consider the smaller median as median value.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
add 10
add 20
add 30
add 40
peek
add 50
peek
remove
peek
remove
peek
remove
peek
remove
peek
quit
Sample Output
20
30
30
20
20
40
40
10
10
50

Code:

//======================================JB's===================

import java.io.*;
import java.util.*;

public class Main {

  public static class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
      left = new PriorityQueue<>(Collections.reverseOrder()); //left pq mai max element ko sabse jada priority hogi
      right = new PriorityQueue<>(); // right pq mai sabse chote element ko jada priority hogi
    }

    public void add(int val) {
      if (left.size() == 0 && right.size() == 0) { //agar dono pq khali hai to left mai add kardenge
        left.add(val);
      } else if (left.size() == 0) { //agar left ka size 0 hua aur right ka size non zero hua
        if (val < right.peek()) { //agar value choti hoti hai right ke peek se to left mai add karenge nhito right mai add karenge coz sorted array aarha input mai jo agar yeh value right pe peek se choti hai to boviously right mai dalni chahiye
          left.add(val);
        } else { 
          right.add(val);
        }
      } else { // agar left ki queue non zero hai 
        if ( val < left.peek()) { //aur yeh values left ke peek se choti hai to left mai add krdo nhito right mai add krdo
          left.add(val);
        } else {
          right.add(val);
        }
      }

      // add karne ke bad last mai muje check karna hoga difference
      int diff = Math.abs(left.size() - right.size());
      if ( diff > 1) {
        if (left.size() > right.size()) { //left ka size bada hai to left mese karo remove aur right mai add krdo
           right.add(left.remove());
        } else {
           left.add(right.remove()); //nhito right se remove karke left mai add krdo
        }
      }
    }

    public int remove() {
      if (left.size() + right.size() == 0) {
        System.out.println("Underflow");
        return -1;
      }

      if ( left.size() >= right.size()) { //agar left ki size equal yafir jada ho to median left side mai exist karega to usko remove krdo
        return left.remove();
      }else{
          return right.remove(); 
      }
    }

    public int peek() {
        if (left.size() + right.size() == 0) {
        System.out.println("Underflow");
        return -1;
      }

      if ( left.size() >= right.size()) { //agar left ki size jada or equal hai to median left ke peek pe hi rahega
         return left.peek();
      }else{
          return right.peek(); 
      }
    }

    public int size() {
      return left.size() + right.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MedianPriorityQueue qu = new MedianPriorityQueue();

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

//===========================Blog======================================================
import java.io.*;

import java.util.*;

public class Main {

  public static class MedianPriorityQueue {
    PriorityQueue< Integer> left;
    PriorityQueue< Integer> right;

    public MedianPriorityQueue() {
      left = new PriorityQueue<>(Collections.reverseOrder());
      right = new PriorityQueue<>();
    }

    public void add(int val) {
      if (right.size() > 0 && val > right.peek()) {
        right.add(val);
      } else {
        left.add(val);
      }

      handleBalance();
    }

    private void handleBalance() {
      if (left.size() - right.size() == 2) {
        right.add(left.remove());
      } else if (right.size() - left.size() == 2) {
        left.add(right.remove());
      }
    }

    public int remove() {
      if (this.size() == 0) {
        System.out.println("Underflow");
        return -1;
      } else if (left.size() >= right.size()) {
        return left.remove();
      } else {
        return right.remove();
      }
    }

    public int peek() {
      if (this.size() == 0) {
        System.out.println("Underflow");
        return -1;
      } else if (left.size() >= right.size()) {
        return left.peek();
      } else {
        return right.peek();
      }
    }

    public int size() {
      return left.size() + right.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MedianPriorityQueue qu = new MedianPriorityQueue();

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

