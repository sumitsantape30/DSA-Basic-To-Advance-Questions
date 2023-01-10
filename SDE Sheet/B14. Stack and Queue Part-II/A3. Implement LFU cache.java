LFU Cache

Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

Example 1:

Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3
 
Code:

class LFUCache {

    final int capacity; //capacity tells the max frequency a cache can have
    int curSize; //it gives the present size of your cache
    int minFrequency; //it tells the minimal frequency that is currently present
    Map<Integer, DLLNode> cache;//cache map: it's saying the key is present at this node
    Map<Integer, DoubleLinkedList> frequencyMap; //frequency map: it's saying this frequency has this LinkedList

    /*.*/
    /*
    * @param capacity: total capacity of LFU Cache
    * @param curSize: current size of LFU cache
    * @param minFrequency: frequency of the last linked list (the minimum frequency of entire LFU cache)
    * @param cache: a hash map that has key to Node mapping, which used for storing all nodes by their keys
    * @param frequencyMap: a hash map that has key to linked list mapping, which used for storing all
    * double linked list by their frequencies
    * */
  
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;

        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    /** get node value by key, and then update node frequency as well as relocate that node **/
    public int get(int key) {
        DLLNode curNode = cache.get(key); //we check if this key exists
        if (curNode == null) { //if it doesnt contains then return -1
            return -1;
        }
        updateNode(curNode);//if it does exists then we update the node
        return curNode.val;//after updating return the value
    }

    /**
     * add new node into LFU cache, as well as double linked list
     * condition 1: if LFU cache has input key, update node value and node position in list
     * condition 2: if LFU cache does NOT have input key
     *  - sub condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node
     *  in minimum frequency list, then add new node
     *  - sub condition 2: if LFU cache has enough space, add new node directly
     * **/
  
    public void put(int key, int value) { 
        // corner case: check cache capacity initialization
        if (capacity == 0) { //if initial capacity given is 0 then return
            return;
        }

        if (cache.containsKey(key)) { //we check if our cache contains this key
            DLLNode curNode = cache.get(key); //we'll take it and initialise the new value
            curNode.val = value;
            updateNode(curNode); //since we have accessed this key so frequency will be increased, it'll go the next frequencies list
        }
        else {
            curSize++; //currSize will increase coz new element is coming
            if (curSize > capacity) { //if currSize is grater than capacity means its already full so need to remove someone
                // get minimum frequency list
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);// whatever is the LFU we'll get that frequency's list
                cache.remove(minFreqList.tail.prev.key); //in that frequency list there can be multiple variables so make sure to remove the previous of the tail. tail ke previous is the least recently used
                minFreqList.removeNode(minFreqList.tail.prev); 
                curSize--; //after removing curreSize will decrease by 1
            }
            // reset min frequency to 1 because of adding new node
            minFrequency = 1; //its a new element so frequency wil be set to 1, it'll be definitely minimum frequency
            DLLNode newNode = new DLLNode(key, value); //will keep the key and value in doubly linkedlist

            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());//if there exist a list which has frequency 1 we'll take it or we'll make a new doublyLL
            curList.addNode(newNode);//we'll add this node
            frequencyMap.put(1, curList);// put in frequencyMap and cache
            cache.put(key, newNode);
        }
    }

    public void updateNode(DLLNode curNode) {
        int curFreq = curNode.frequency; //we took frequency of that node
        DoubleLinkedList curList = frequencyMap.get(curFreq);// then we took out the list that belong to that frequency
        curList.removeNode(curNode);//then we remove this node coz its frequency will be updated so it'll have different address so it'll get removed from current list

        // if current list the the last list which has lowest frequency and current node is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        if (curFreq == minFrequency && curList.listSize == 0) { //if that frequency was the minimum frequency  and list turned out 0 after removal that means it was removed from the list which was the minimal frequency list and now it doesnt have any element so the minimum frequency will be next minimum frequency so ++
            minFrequency++;
        }
        
        curNode.frequency++; //frequency will be increased
        // add current node to another list has current frequency + 1,
        // if we do not have the list with this frequency, initialize it
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList()); //get the doubleLL from frequency map for this given frequency if it exists you'll get it and if it doesnt exists you'll get a empty doubly linkedlist
         newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);//update frequency map
    }

    /*
    * @param key: node key
    * @param val: node value
    * @param frequency: frequency count of current node
    * (all nodes connected in same double linked list has same frequency)
    * @param prev: previous pointer of current node
    * @param next: next pointer of current node
    * */
    class DLLNode {
        int key;
        int val;
        int frequency;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    /*
    * @param listSize: current size of double linked list
    * @param head: head node of double linked list
    * @param tail: tail node of double linked list
    * */
    class DoubleLinkedList {
        int listSize;
        DLLNode head;
        DLLNode tail;
        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        /** add new node into head of list and increase list size by 1 **/
        public void addNode(DLLNode curNode) {
            DLLNode nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }

        /** remove input node and decrease list size by 1**/
        public void removeNode(DLLNode curNode) {
            DLLNode prevNode = curNode.prev;
            DLLNode nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
