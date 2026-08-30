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
    boolean equivelent = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p, q);
        return equivelent;
    }

    private void dfs(TreeNode p, TreeNode q) {
        // Basecases
        if (p == null && q == null) {
            return;
        } 
        else if (p == null && q != null || p != null && q == null || p.val != q.val) {
            equivelent = false;
            return;
        }

        // Now we go deeper:
        dfs(p.left, q.left);
        dfs(p.right, q.right);

        return;
    }
}
