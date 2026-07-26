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

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> sol = new ArrayList<>();

        if (root == null) return sol;

        List<TreeNode> layer1;
        List<TreeNode> layer2 = new ArrayList<>();

        layer2.add(root);

        while (!layer2.isEmpty()){
            int maxValue = 0;
            layer1 = layer2;
            layer2 = new ArrayList<>();

            while(!layer1.isEmpty()){
                TreeNode node = layer1.remove(layer1.size() - 1);
                if (node.left != null) layer2.add(node.left);
                if (node.right != null) layer2.add(node.right);

                maxValue = Math.max(maxValue, node.val);
            }

            sol.add(maxValue);

        }
        return sol;
    }
    


}
