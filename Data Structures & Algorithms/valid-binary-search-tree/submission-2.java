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
    public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean valid(TreeNode root, int minBound, int maxBound) {
        if (root == null) return true;

        if (root.val <= minBound || root.val >= maxBound) return false;

        return valid(root.left, minBound, root.val) && valid(root.right, root.val, maxBound);
    }
}
// root=[5,4,6,null,null,3,7]
//              5 (inf, inf)
//          4(inf,5)       6(5, inf)
//         n n            3(5,6)F  7 (6,inf)
