Code:

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
      //take iter and front and intialise on head
          Node iter = head; 
          Node front = head;

          // First round: make copy of each node,
          // and link them together side-by-side in a single list.
          while (iter != null) { //we are going to iter until it reaches null
            front = iter.next;//move front to iter

            Node copy = new Node(iter.val);//then we'll create a copy node, basically we're creating the deep copy of node having value as val
            iter.next = copy;//iter's next should point to deep copy node
            copy.next = front; //then copy's next is going to point front

            //then move itern to front for the next iteration
            iter = front;
          }

          // Second round: assign random pointers for the copy nodes.
          iter = head;//we keep iter on head and keep moving until it reaches null
          while (iter != null) {
            if (iter.random != null) {//agar iter ka random null ko point nhi kr rha
              iter.next.random = iter.random.next; //iter's next random is going to point iter's random next(deep copy)
            }
            iter = iter.next.next;//then iter's going to move ahead
          }

          // Third round: restore the original list, and extract the copy list.
          iter = head;
          Node pseudoHead = new Node(0);// this is a dummy node having value 0
          Node copy = pseudoHead;//we'll create a copy node so that we dont lose the track of initial head of the deep copy list and this copy is initialised to pseudoHead

          while (iter != null) { //till it reaches null
            front = iter.next.next; //we'll assign front to 2 steps ahead

            //now extract the deep copy list
            copy.next = iter.next; //dummy guys(copy's) next will be pointing to iter's next
            copy = copy.next;

            // now restore the original list
            iter.next = front;

            iter = front;
          }

          return pseudoHead.next;
    }
}
