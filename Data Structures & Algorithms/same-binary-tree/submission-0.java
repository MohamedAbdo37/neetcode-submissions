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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if( p == null || q == null ){
            if (p == null && q == null)
                return true;
            else 
                return false;
        }   

        if (isLeaf(p) != isLeaf(q))
            return false;

        if (isLeaf(p) && isLeaf(q)) {
            if (p.val == q.val)
                return true;
            else 
                return false;
        }

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right;
    }

    private boolean isLeaf(TreeNode node){
        if (node.left == null && node.right == null)
            return true;

        return false;
    }
}
