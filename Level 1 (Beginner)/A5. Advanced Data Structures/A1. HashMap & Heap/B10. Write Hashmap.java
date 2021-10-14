Write Hashmap - Open Book-2 and page No 23 for this.

1. You are required to complete the code of our Hashmap class. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
2. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
put India 135
put Aus 5
put Canada 3
display
get China
remove Aus
get Aus
containsKey US
put US 10
put UK 20
remove US
containsKey US
put Pak 80
put China 200
display
put Utopia 0
display
put Nigeria 3
display
put India 138
display
put Sweden 1
display
put finland 20
display
quit
Sample Output
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 .
Bucket3 India@135 Aus@5 .
Display Ends
null
5
null
false
10
false
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 Sweden@1 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Pak@80 finland@20 .
Bucket3 .
Bucket4 Sweden@1 .
Bucket5 .
Bucket6 Canada@3 UK@20 .
Bucket7 India@138 China@200 Nigeria@3 .
Display Ends

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
      
    private class HMNode { //HashMap ke har node mai key-value pair rahegi
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {  //HashMap ka constuctor
      initbuckets(4); //initbuckets function ko call laga rakhi hai
      size = 0; //size ko 0 se initialise kardi
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N]; // size set kardiya ki kitne size ka array banaye
      for (int bi = 0; bi < buckets.length; bi++) { // by default value null hoti hai isliye har index pe jake new linedlist ko store karwa di means har index pe address store hogya
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value)  {
       //sabse pehle bucket index nikalo
       int bi = hashFunction(key); // iss function se is key ka muje bucket index mil jayega ki konsi bucket mai add hoga 
       int di = findWithInBucket(key, bi); // ab mai iss key ko iss bucket index mi dhundunga to muje data index mil jayga aur nhi milti hai to data index -1 ajayega. dekh rhe hai ki kya yeh key already present hai or pehli bar aa rha hai 
       
       if( di == -1){ //agar data index -1 ajata hai means key doesnt exists
          //to naya key value pair banake uss bucket ke last mia dal denge
          buckets[bi].add(new HMNode(key, value));
          size++; // new key value pair add ki hai to size jarur badhana 
       }else{
           //else matlab key pehlese exist krti hai map ke andar to uski value change karni hai
           buckets[bi].get(di).value = value; // buckets[bi] ek link list hai so uss data index pe HMNode rahega so uski value ko change karenge
       }
       
       //fir lambda calculate karenge
       double lambda = (double)size / (double)buckets.length; //integer/integer= integer value milti hai so isko 1.0 se multiply karo or double mai typecaste karlo
       if( lambda > 2.0){ //agar lambda ki value grater than 2.0 hojati hai to resize krdenge
         resize();
       }
       
    }
    
    public void resize(){
        
        LinkedList<HMNode>[] ob = buckets; // old buckets ko preserve karlo
        
        buckets = new LinkedList[2* ob.length]; //double size ka array banayenge
        
        for( int i=0; i< buckets.length; i++){
            buckets[i] = new LinkedList<>(); //har ek index pe jake new linkedlist banaye
        }
        
        //double size wala bucket abhi khali pda hai to mai old buckets ke upar travel krta hu
        // size ko 0 se initialise kardo
        size = 0;
        for( int bi=0; bi < ob.length; bi++){
            LinkedList<HMNode> ll = ob[bi]; //old bucket mese get bi
            
            for( int i=0; i< ll.size(); i++){
                // ab mai put function ko call lagadunga
                put(ll.get(i).key, ll.get(i).value);
            }
        } //so maine yaha travel kiya jo old bucket thi uske har ek linkedlist pe gya, har ek linkedlist mai hasmapNode uthayi wahase uski key aur value uthayi aur fir maine put function ko call kardiya, buckets mai woh add kardega apne aap 
        
    }
    
    public int hashFunction(K key){ // this function returns bucket index
        return Math.abs(key.hashCode()) % buckets.length; // mai sidha key ke upar hashCode nam ka function call karunga to muje ek interget value milegi.
        // iss integer value ko muje ab 0 se bucket.length-1 ki range mai leke aana hai isliye modulo liya
        // agar woh integer negative hota to usko maine Math.abs se positive banaya
    }
    
    // yeh return karega data index
    public int findWithInBucket(K key, int bi){
        int di = -1; // data index ko -1 se initialise kiya
        
        for( int i=0; i< buckets[bi].size() ; i++){
            if(buckets[bi].get(i).key.equals(key)){ //agar linkedlist ek uss node ki key mere current key ke equal hai to i ki value return kardo otherwise last mai -1 hi return kardena. Key string bhi ho skti hai isliye dontuse ==, use .eqauls
            return i; 
            }
        }
        return di; // -1 denotes that the key doesnt exist in the hashamp
        //upar bina di intialise kiye direct bhi -1 return kar skte ho
    }

    public V get(K key)  {
       int bi = hashFunction(key); 
       int di = findWithInBucket(key, bi);  
       
       if( di == -1){  // data index -1 aya means key exist nhi krti so null return kardo
          return null;
       }else{ //agar exist krti hai to uski value return krdo
           
           return buckets[bi].get(di).value;
       }
       
    }

    public boolean containsKey(K key) {
       int bi = hashFunction(key); 
       int di = findWithInBucket(key, bi);  
       
       if( di == -1){  // data index -1 aya means key exist nhi krti so false return kardo
          return false;
       }else{ //agar exist krti hai to true return krdo
           
           return true;
       }
    }

    public V remove(K key) {
       int bi = hashFunction(key); 
       int di = findWithInBucket(key, bi);  
       
       if( di == -1){  // data index -1 aya means key exist nhi krti so null return kardo
          return null;
       }else{ //agar exist krti hai to uski value return karenge coz yahi remove karni hai
           
           V rv=  buckets[bi].get(di).value; //yeh remove karni hai isliye store karke rakhliye
           buckets[bi].remove(di) ; // buckets[bi] is a linkedlist, usko remove krdo aur size ko 1 se decrease krdo
           size--;
           return rv;
       }
    }

    public ArrayList<K> keyset() { //sari keys ka set chahiye merko
        //sari keys ko ek arraylist mai bharke return karna hai
        ArrayList<K> keys= new ArrayList<>();
        
        //pehle muje iss array pe loop lagana hoga, fir 0th index pe jo linkedlist stored hai uske andar se sari keys utha lenge fir first index pe jo linkedlist stored hai uski sari keys utha lenge so on
        
        for( int bi = 0; bi< buckets.length; bi++){
           // buckets[bi] mauje ek linkedlit of HMNode mil jayegi
           LinkedList<HMNode> ll= buckets[bi];
           
           for( int i=0; i< ll.size(); i++){
               keys.add(ll.get(i).key);
           }
        }
        return keys;
    }

    public int size() {
        return this.size();
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}
