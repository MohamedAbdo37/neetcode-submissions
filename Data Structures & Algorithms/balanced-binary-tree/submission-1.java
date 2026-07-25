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
    public boolean isBalanced(TreeNode root) {
        if(root == null || this.isLeaf(root)) {
            return true;
        }

        int[] r = new int[2];
        int[] l = new int[2];
        r[1] = 1;
        l[1] = 1;

        if (root.left != null) 
            l = this.depth(root.left);

        
        if (root.right != null)
            r = this.depth(root.right);


        return ( l[1] == 1 && r[1] == 1 && Math.abs(l[0] - r[0]) < 2);
    }

    private int[] depth(TreeNode root){
        int[] result = new int[2];

        if(root == null || this.isLeaf(root)) {
            result[0] = 1;
            result[1] = 1;
            return result;
        }

        int[] r = new int[2];
        int[] l = new int[2];
        r[1] = 1;
        l[1] = 1;

        if (root.left != null) 
            l = this.depth(root.left);
        
        if (root.right != null)
            r = this.depth(root.right);
        
        result[0] = Math.max(l[0] , r[0]) + 1;
        if ( l[1] == 1 && r[1] == 1 && Math.abs(l[0] - r[0]) < 2)
            result[1] = 1;
        else
            result[1] = 0;
        return result;
    }

    private boolean isLeaf(TreeNode node){
        if(node.left != null)
            return false;
        
        if(node.right != null)
            return false;
        
        return true;
    }
}
