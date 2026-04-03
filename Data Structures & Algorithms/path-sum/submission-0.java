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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode root, int targetSum, int curr) {
        if (root == null) return false;
        curr += root.val;
        if (root.left == null && root.right == null) return (curr == targetSum);
        boolean left = dfs(root.left, targetSum, curr);
        boolean right = dfs(root.right, targetSum, curr);

        return left || right;
    }
    // Problem: Early return value? Could that cook us?
    // dfs(root)
    // dfs(root.left)
    // dfs(null) --> Return false
    // But what happens to dfs(root.right)? it is still in the call stack
    // What value gets used? I'm not sure.
}

// Return if a tree has a root-to-leaf path with a sum == target sum
// Possibly there are also negative values.
// Do a full search from root to leaf, check if val at leaf == t, return t
// else false if we find no matches.