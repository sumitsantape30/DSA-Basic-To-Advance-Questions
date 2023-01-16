Problem Statement: Given a Binary Tree, find the Right/Left view of it. The right view of a Binary Tree is a set of nodes visible when the tree is viewed from the right side. The left view of a Binary Tree is a set of nodes visible when the tree is viewed from the left side.

Example 1:

Input:

Output: Right view- 1 2
        Left view- 1 3
Explanation: Seeing through the left side it sees only 1 and 3 while through the right side we only see 1 and 2.

Example 2:

Input:

Output: Right View- 10 30 60
        Left view- 10 20 40

Code:


/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        leftViewHelper(root, 0, result);
        return result;
    }
    
     void leftViewHelper(Node root, int level, ArrayList<Integer> result){
        
        if(root == null){
            return;
        }
        
        if(level == result.size()){
            result.add(root.data);
        }
        
        leftViewHelper(root.left, level+1, result);
        leftViewHelper(root.right, level+1, result);
        
    }
}

// right view keliye pehle right mai call karo then left mai call karo
