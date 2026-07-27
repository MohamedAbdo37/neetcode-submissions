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
    private int solution = 0;
    public int goodNodes(TreeNode root) {

        this.pruning(root, root.val);

        return solution;
    }

    private void pruning (TreeNode root, int max) {
        if (root == null)
            return ;

        if (root.val >= max)
            this.solution++;

        
        this.pruning(root.left, Math.max(root.val, max));

        this.pruning(root.right, Math.max(root.val, max));
    }


}
