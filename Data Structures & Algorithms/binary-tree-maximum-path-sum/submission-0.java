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

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        int val = this.path(root);

        return Math.max(val, this.max);
        
    }

    private int path(TreeNode node) {
        if(node == null) return 0;
        
        this.max = Math.max(max, node.val);

        int l = path(node.left);
        int r = path(node.right);

        this.max = Math.max(max, node.val + l + r);
        return node.val + Math.max(0, Math.max(l, r));
    }

}
