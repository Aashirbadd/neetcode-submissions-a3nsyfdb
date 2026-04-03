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
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);

        int maxDepth = Math.max(leftDepth, rightDepth);
        int sumDepth = leftDepth + rightDepth;

        max = Math.max(max, sumDepth);  // Check if current diameter is max
        return maxDepth + 1;    // Pass deepest child to see if it contributes to a higher diameter
    }
}

// depthL + depthR (max depth with root at current)
// or Parent(depthL + depthR)
//   1
//    \ 2
//    3 /\ 4
//   5/

// 5(0)
// 3(1)
// 2(2) or (1) or (3)
// 4(0)
// 1 (3)
// Out of all of those, the max == 3