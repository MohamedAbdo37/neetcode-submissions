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
    public int diameterOfBinaryTree(TreeNode root) {
        return depth(root)[1];
    }

    private int[] depth(TreeNode root) {
        int[] result = new int[2];
        int[] r = {0,0}, l = {0, 0};

        if (root == null || isLeaf(root)) {
            result[0]++;
            return result;
        }


        if(root.left != null){
            l = depth(root.left);
        }

        
        if(root.right != null) {
            r = depth(root.right);
        }
        
        result[1] = Math.max(Math.max(r[1] , l[1]) , (r[0] + l[0]));
        result[0] = Math.max(r[0] , l[0]) + 1;

        return result;
            
    }

    private boolean isLeaf(TreeNode node) {
        if (node.left != null)
            return false;
        
        if (node.right != null)
            return false;

        return true;
    }
}
