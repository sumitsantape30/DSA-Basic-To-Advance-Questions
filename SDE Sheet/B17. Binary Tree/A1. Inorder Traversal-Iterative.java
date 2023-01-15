Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Code:

/**
 * Definition for a binary tree node.
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


    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;//current abhi root pe hai
        
        while(curr != null || !stack.isEmpty()) {

            while(curr != null) { //curr jabtak null nhi hota tabtak left mai jate rahenge
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop(); //stack ki top pe jo rahega woh mai in order rahega
            result.add(curr.val);
            curr = curr.right; //print krne ke bad left mai jao
        }
        
        return result;
    }
}
