Bottom view of a Binary Tree
Problem Statement: Given a binary tree, print the bottom view from left to right. A node is included in the bottom view if it can be seen when we look at the tree from the bottom.

Example 1:

Input: 

Output: 3 1 2
Explanation:

Explanation: 

If you look up from the bottom from left to right then first we get 3, then 1 and 2.

Example 2:

Input: 


Output: 40 20 60 30
  
Code:

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>(); 
      
        if(root == null) return ans;//root null hai to return ans
      
        Map<Integer, Integer> map = new TreeMap<>();
      
        Queue<Node> q = new LinkedList<Node>();
      
        root.hd = 0; 
        q.add(root); 
        while(!q.isEmpty()) { //levelorder traversal
            Node temp = q.remove();
            int hd = temp.hd; 
            map.put(hd, temp.data); 
          
            if(temp.left != null) { //if there's left insert -1
                temp.left.hd = hd - 1; 
                q.add(temp.left); 
            }
            if(temp.right != null) {//if there's right insert + 1
                temp.right.hd = hd + 1; 
                q.add(temp.right); 
            }
        }
        
      //map pe iterate karenge and get the value, yeh sorted order mai dega
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
        
    }
}
