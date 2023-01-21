Construct Binary Tree from Inorder and Postorder Traversal

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder 
is the postorder traversal of the same tree, construct and return the binary tree.

 
Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]

Code:

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)//if any of these happens we'll return null
            return null;
      
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>(); //we'll add all the elements in the map
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
      
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1,hm); //inorder, start point of inorder, end point of inorder, postorder, start point of postorder, end point of postorder
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
      
        TreeNode root = new TreeNode(postorder[pe]); //postorder ke end pe rakhe ele ko root banayenge
      
        int ri = hm.get(postorder[pe]);//then i find that root ele in inorder using map
      
      //isme kaise pass kiya hai jara dekhoo
        TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ ri-is-1, hm); //next function call keliye inorder ka range rahega 0 to root index-1. aur postorder keliye ps(postorder starting) to 2nd index
        TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
      
      //fir inko root ke left and right mai attach krdenge
        root.left = leftchild;
        root.right = rightchild;
      
        return root;
      
    }
}
