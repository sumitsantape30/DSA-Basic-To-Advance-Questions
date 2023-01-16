The logic for top view and bottom view is exactly same as bottom view. 
Just use map.putIfAbsent(line,node.val) for Top view and map.put(line,node.val) for Bottom view. 
In top view we put on the map only once because all other nodes on lower level are hidden. 
In bottom view we replace because we got another node on lower node that hides the upper node.

Problem Statement

Top view of a Binary Tree
Problem Statement: Given below is a binary tree. The task is to print the top view of the binary tree. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.

Example 1:

Input: 

Output: 2 1 3
Example 2:

Input: 

Output: 40 20 10 30 100

Code:
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0)); 
        while(!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.hd; 
            Node temp = it.node; 
            if(map.get(hd) == null) map.put(hd, temp.data); 
            if(temp.left != null) {
                
                q.add(new Pair(temp.left, hd - 1)); 
            }
            if(temp.right != null) {
                
                q.add(new Pair(temp.right, hd + 1)); 
            }
        }
    
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
        
    }
}
