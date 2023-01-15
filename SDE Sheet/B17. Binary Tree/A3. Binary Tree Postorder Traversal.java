
Code:

/**
 * Definition for a binary tree node.
 Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [3,2,1]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 
 
 Code:
 
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        Stack<TreeNode> st = new Stack<>();
		List<Integer> list = new ArrayList<>();
		TreeNode curr = root;
		
		while(curr != null || !st.isEmpty()) {
			
			while(curr != null) {
				list.add(0, curr.val); //list mai aagese dalrhe elements ko to right side mai jo sabse last visit hoga woh list mai sabse aage ayega
				st.push(curr);
				curr = curr.right;
			}
			
			curr = st.pop();
			curr = curr.left;
			
		}
		return list;
    }
}
