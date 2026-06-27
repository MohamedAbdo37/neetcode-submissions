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
    public TreeNode invertTree(TreeNode root) {
        if (root == null || this.isLeaf(root)) return root;

        invertTree(root.left);
        invertTree(root.right);

        return this.swap(root);
    }

    private boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null ) 
            return true;
        return false;

    }

    private TreeNode swap(TreeNode node) {
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;

        return node;
    }
}
