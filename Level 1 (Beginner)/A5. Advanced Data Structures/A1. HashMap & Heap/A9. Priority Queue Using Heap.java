Write Priority Queue Using Heap

1. You are required to complete the code of our Priority Queue class using the heap data structure. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
2. Here is the list of functions that you are supposed to complete:
    2.1. add -> Should accept new data.
    2.2. remove -> Should remove and return smallest value, if available or print 
     "Underflow" otherwise and return -1.
     2.3. peek -> Should return smallest value, if available or print "Underflow" 
     otherwise and return -1.
     2.4. size -> Should return the number of elements available.
3. Input and Output is managed for you.
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
10
10
10
20
20
30
30
40
40
50

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data; //arraylist of integers data memeber hai

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) { //data add karo aur unheapify ke function ko call lagalo
      data.add(val);
      upheapify(data.size() - 1); //jo aakhri banda humne add kiya hai arraylist mai uska index pass karte hai isme

    }

    public void upheapify( int ci) { //isme input child index ayega
       if( ci == 0){ 
           return;
       }
      
      int pi= (ci-1) / 2; //aatehi sabse pehle parent index nikalo
      //ab child and parent ki value compare karenge
      if(data.get(ci) < data.get(pi)){ //agar child index pe rakhi value parent index pe rakhi hui value se choti hai to donoko swap karaunga
         swap(ci, pi);
         //aur recursive call lagegi upheapify() ko usme parent index input jayega as a child, ab parent child banega
         upheapify(pi);
      }
    }
    
    public void swap( int i, int j){
        int ith = data.get(i);
        int jth = data.get(j);
        
        data.set(i, jth);
        data.set(j, ith);
        
    }

    public int remove() {
         if (data.size() == 0) { //size 0 rha to kyahi remove karenge
        System.out.println("Underflow");
        return -1;
      }
        
        //sabse pehla kam 0th aur last index ka data swap karado
        swap(0, data.size()-1);
                
        //uske bad aakhri wale ko remove karna hai
        int rv= data.remove(data.size()-1);
	    
        //but agar swapping ke bad agar property violet hui hai to downheapify call karenge 0th element pe
        downheapify(0);
        
        //jisko remove kiya usko return karenge
        return rv;
    }
    
    public void downheapify( int pi){ //isme parent index input ayega
        
        int lci = 2* pi + 1;
        int rci = 2* pi + 2;
        
        //ab muje left child, right child, parent ismese minimum nikalna hai, so pehle parent ko min index manliya
        int minidx = pi; //maine yeh man liya ki min index parent index hi hai 
        
        if(lci < data.size() && data.get(lci) < data.get(minidx)){ //agar left child index ki value min index se choti hai to ab mera min index hoga lci
           minidx = lci;
        } // lci arraylist ke range mai hona chahiye tabhi to nikal payenge isliye lci< data.size() kiye
        
        if(rci < data.size() && data.get(rci) < data.get(minidx)){ //agar right child index ki value choti hogi min index se to minindex hoga rci
           minidx = rci;
        }
        //lci and rci range mai hai aur unki value minindex pe rakhi hui value se choti hai to minindex ko update kardo
        
        if(minidx != pi){ //agar minindex parent index ke barabr nhi hai means woh donomese ke if mai update ho chuka hai matlab minindex parent index nhi hai left or right mese minindex hai so muje swap karke downheapify() call karna chahiye
         //agar woh dono if mai update nhi hua means minindex hi parent index rahega means wahi minimum hai to kisiko call nhi lageegi
         
         // to parent index ko swap karayenge
          swap(pi, minidx);
          downheapify(minidx); //fir minindex ko recursive call lagadenge
        }
// ragarding basecase: agar mai leaf node pe pohoch gya hu to uska nahi left or right child hota hai means minindex parent index ke barbar hi hoga to yahase koi call hi nhi lagegi     
        
    }

    public int peek() {
      if (data.size() == 0) {
        System.out.println("Underflow");
        return -1;
      } else {
        return data.get(0); //arraylist ke 0th index pe jo value hogi that is my peek
      }
    }

    public int size() {
      // jo arraylist ka size hai wahi size hoga
      return data.size();
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

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

//==========================More optimised, when the array is given in input=============================================

package practice;

import java.util.*;

public class Code {

	public static class PriorityQueue {
		ArrayList<Integer> data; 

		public PriorityQueue() {
			data = new ArrayList<>();
		}
		
		//dusra constructor banane padega isme aap array receive krte ho
		public PriorityQueue( int arr[]) {
			data= new ArrayList<>();
			
			for( int i=0; i< arr.length; i++) {
				data.add(arr[i]); // sare elements ko as it is arraylist mai add kardiya
			}
			
			// heap order property maintain karne keliye downheapify call karenge
			// but jitni leaf node hai unko downheapify call karneki jarurat nhi hai so call lagni chahiye first non-leaf node se 0th node tak
			//basically akhri index ka parent index chahiye means ci-1/2 use karenge aur akhri index hota hai data.size()-1 so data.size()-1-1/2 => data.size()-2/2 yahase leke 0th index tak call lagado
			
			for( int i= (data.size() -2)/2 ; i>=0; i--) {
				downheapify(i);
			}
		}

		public void add(int val) { 
			data.add(val);
			upheapify(data.size() - 1); 

		}

		public void upheapify(int ci) { 
			if (ci == 0) {
				return;
			}

			int pi = (ci - 1) / 2; 
			if (data.get(ci) < data.get(pi)) { 
				swap(ci, pi);
				upheapify(pi);
			}
		}

		public void swap(int i, int j) {
			int ith = data.get(i);
			int jth = data.get(j);

			data.set(i, jth);
			data.set(j, ith);

		}

		public int remove() {
			if (data.size() == 0) { 
				System.out.println("Underflow");
				return -1;
			}

			swap(0, data.size() - 1);

			int rv = data.remove(data.size() - 1);

			downheapify(0);

			return rv;
		}

		public void downheapify(int pi) {

			int lci = 2 * pi + 1;
			int rci = 2 * pi + 2;

			
			int minidx = pi; 

			if (lci < data.size() && data.get(lci) < data.get(minidx)) { 
				minidx = lci;
			}

			if (rci < data.size() && data.get(rci) < data.get(minidx)) { 
				minidx = rci;
			}

			if (minidx != pi) { 
				swap(pi, minidx);
				downheapify(minidx); 
			}

		}

		public int peek() {
			if (data.size() == 0) {
				System.out.println("Underflow");
				return -1;
			} else {
				return data.get(0); 
			}
		}

		public int size() {
			return data.size();
		}

	}

	public static void main(String[] args) throws Exception {
		int arr[]= {12, 8, -40, 11, 16, 9, 3, 119, -786, 754, 19, 1};

		PriorityQueue pq = new PriorityQueue(arr); //maine array pass kiya aur muje O(1) mai priority queu banke mil jayegi

		while( pq.size() != 0) {
			System.out.println(pq.remove());
		}
	}
}
Output:

-786
-40
1
3
8
9
11
12
16
19
119
754
