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
    int max = Integer.MAX_VALUE;
    int min = - Integer.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        return this.is_valid(root, this.min, this.max);
    }

    private boolean is_valid(TreeNode node, int minn, int maxx) {
        if (node == null)
            return true;
        
        if (node.val <= minn || node.val >= maxx)
            return false;
        
        return is_valid(node.left, minn, node.val) && is_valid(node.right, node.val, maxx);
    }

}
