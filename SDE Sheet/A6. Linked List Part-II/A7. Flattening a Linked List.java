Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
Note: The flattened list will be printed using the bottom pointer instead of next pointer. For more clearity have a look at the printList() function in the driver code.

 
Example 1:

Input:
5 -> 10 -> 19 -> 28
|     |     |     | 
7     20    22   35
|           |     | 
8          50    40
|                 | 
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20->
22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation:
The resultant linked lists has every 
node in a single level.
  
Code:

/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
      Node mergeTwoLists(Node a, Node b) {
        
        //temp node lenge traverse krne keliye, initially res pe rahega yeh
        Node temp = new Node(0);
        Node res = temp; 
        
        while(a != null && b != null) { //a and b node ke bottoms mai hi data hai
            if(a.data < b.data) { //agar a ka data chota hai b se to temp ke botton mai a ko daldo, aur temp ko aur niche leke jao
                temp.bottom = a; 
                temp = temp.bottom; 
                a = a.bottom; //a ko bhi aur niche leke jao
            }
            else {
                temp.bottom = b;
                temp = temp.bottom; 
                b = b.bottom; 
            }
        }//dono mere koi ek khali hojaye to iss while loop ke bahar ajayenge
        
        //agar a khali nhi hua hai to temp ke niche bachi hui a list daldo
        if(a != null) temp.bottom = a; 
        
        else temp.bottom = b;// agar b khali nhi hua hai to bachi hui b list temp ke bottom mai daldo
        
        return res.bottom; //mera answer res ke bottom mai hai to woh return karenge
    
    }
    
    Node flatten(Node root)
    {
	 if (root == null || root.next == null) 
            return root; 
      
            // recur for list on right, muje apne recursion pe bharosa hai ki mere next mai jo LL hai woh flatten hoke ajayegi
            root.next = flatten(root.next); 
      
            // now merge , ab mai meri current LL and flattened LL ko merge karunga
            root = mergeTwoLists(root, root.next); 
      
            // return the root 
            // it will be in turn merged with its left 
            return root;
    }
}
