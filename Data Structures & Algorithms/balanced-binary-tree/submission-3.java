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
    // Basically check if heights of left and right nodes differ by atmost 1, and if not, ret false...
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return balanced;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);

        if (Math.abs( l - r) > 1) {
            balanced = false;
        }

        return Math.max(l, r) + 1;
    }
}
