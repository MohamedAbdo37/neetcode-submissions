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
    int min;
    public int kthSmallest(TreeNode root, int k) {
        min = Integer.MAX_VALUE;

        setMin(root);

        return search(root, k).val;
    }

    private void setMin(TreeNode node){
        if (node == null)
            return;
        min = Math.min(min, node.val);     
        setMin(node.left);
    }

    private TreeNode search(TreeNode node, int k) {
        if (node == null)
            return node;
        int val = node.val - this.min + 1;
        if ( val == k)
            return node;
        
        if(val > k )
            return search( node.left, k);
        else
            return search( node.right, k); 
    }

}
