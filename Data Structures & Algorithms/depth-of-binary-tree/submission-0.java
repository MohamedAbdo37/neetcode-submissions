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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if( isLeaf(root)) return 1;

        int left = 0;
        int right = 0;
        if (root.left != null) 
            left = maxDepth(root.left);
        
        if (root.right != null)
            right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
    }

    private boolean isLeaf(TreeNode node) {
        if (node.right == null && node.left == null)
            return true;
        
        return false;
    }
}
