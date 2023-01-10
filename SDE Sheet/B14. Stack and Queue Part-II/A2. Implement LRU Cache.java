Implement LRU Cache
Problem Statement: “Design a data structure that follows the constraints of Least Recently Used (LRU) cache”.

Implement the LRUCache class:

LRUCache(int capacity) we need to initialize the LRU cache with positive size capacity.
int get(int key) returns the value of the key if the key exists, otherwise return -1.
Void put(int key,int value), Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.if the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Example:

Input:
 ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
       [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

Output:
 [null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation:

LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

Code:

class LRUCache {
    Node head = new Node(0, 0), tail = new Node(0, 0); //firstly we initialised head and tail 
    Map < Integer, Node > map = new HashMap(); //then we declare a hashmap, map mai key is integer and value is address of the node
    int capacity; //this capacity states the capacity of cache

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
      //head's next will point to tail and tail's previous will point to head
    }
  
  //have to built get put in O(1) 

    public int get(int key) {
        if (map.containsKey(key)) { //if it exists already we'll get it from map
            Node node = map.get(key); // we'll get the reference pointer from map easily
            remove(node);//then we remove it coz this is the lru guy
            insert(node); //then we insert it after head
            return node.value; //it'll give the answer
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) { //add krne se pehle we'll check does the cache contains it on not
            remove(map.get(key)); //already contain krta hai to remove karo coz a key agyi hai with a new value
        }
      //then capacity check karo
        if (map.size() == capacity) {//agar cache already full hai to tail ki previous ko remove karo
            remove(tail.prev);
        }
        insert(new Node(key, value)); //then insert the new guy, it will be inserted next to head
    }

    private void remove(Node node) {// remove mai node ka address hoga which is to be removed
        map.remove(node.key); //node aya means its previously existing so usko map se hatao
        node.prev.next = node.next; //current node ke previous ko current node ke next mai point krhe
        node.next.prev = node.prev;//then current node next ke previous mai current node ka previous dalrhe
    }

    private void insert(Node node) {//iss node ko dalna hai means this node is already been created
        map.put(node.key, node);
        node.next = head.next; //node ke next mai head ka next dalrhe
        node.next.prev = node; //current node ke next ke previous mai current node dalrhe
        head.next = node; //head ke next mai current node mai dalrhe
        node.prev = head; //node ke previous mai head ko dalrhe
    }

    class Node { //we have node here
        Node prev, next; //these are the reference pointers for previous and next
        int key, value;
        Node(int _key, int _value) { //this will take key and value input
            key = _key;
            value = _value;
        }
    }
}
