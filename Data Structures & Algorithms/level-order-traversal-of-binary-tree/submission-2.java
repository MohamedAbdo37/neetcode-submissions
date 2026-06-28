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
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) 
            return new ArrayList<>();

        List<List<Integer>> out = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        in.add(root.val);
        out.add(in);
        
        if (isLeaf(root))
            return out;
        
        
        List<List<Integer>> left = levelOrder(root.left); 
        List<List<Integer>> right = levelOrder(root.right); 

        while(!left.isEmpty() && !right.isEmpty()) {
           in = merge(left.remove(0), right.remove(0));
           out.add(in); 
        }

        while(!left.isEmpty())
            out.add(left.remove(0)); 

        while(!right.isEmpty())
            out.add(right.remove(0)); 
    
        
        return out;
    }

    private boolean isLeaf(TreeNode node){
        if(node.right != null)
            return false;
        if (node.left != null)
            return false;
        
        return true;
    }

    private List<Integer> merge(List<Integer> l, List<Integer> r) {
        List<Integer> out = new ArrayList<>();

        for (int i : l)
            out.add(i);
        for (int i: r)
            out.add(i);
        
        return out;
    }

}
