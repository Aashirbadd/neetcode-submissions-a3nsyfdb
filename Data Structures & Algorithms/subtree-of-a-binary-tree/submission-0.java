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
    // This will use the helper function to guide us to the answer
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base Case
        if (subRoot == null) {
            return true;
        } 
        else if (root == null && subRoot != null) {
            return false;
        }

        if (root.val == subRoot.val) {
            // could potentially be a subtree here
            if (sameTree(root, subRoot)) {
                return true;
            }
        }

        boolean isLeftSubTree = isSubtree(root.left, subRoot);
        boolean isRightSubTree = isSubtree(root.right, subRoot);

        return isLeftSubTree || isRightSubTree;
    }

    private boolean sameTree(TreeNode root, TreeNode subRoot) {
        // Base case
        if (root == null && subRoot == null) {
            return true;
        }
        else if (root == null && subRoot != null || 
                    root != null && subRoot == null ||
                    root.val != subRoot.val) {
            return false;
        }

        boolean isLeftSame = sameTree(root.left, subRoot.left);
        boolean isRightSame = sameTree(root.right, subRoot.right);

        return isLeftSame && isRightSame;
    }
}
