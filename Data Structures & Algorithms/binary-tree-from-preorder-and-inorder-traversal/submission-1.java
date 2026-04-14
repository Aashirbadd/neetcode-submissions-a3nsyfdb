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
    private int index = 0;      // preorder index of current element (preorder lets us know root)
    private HashMap<Integer, Integer> map;  // inorderNum -> Index (map lets us locate)
    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        // Fill inordermap
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);     // Num -> Index
        }
        return helper(0, inorder.length-1);
    }

    private TreeNode helper(int start, int end) {
        TreeNode root = null, left = null, right = null;
        if (start > end) return root;

        int rootValue = preorder[index++];
        int rootInorderIndex = map.get(rootValue);
        
        // Left child must have an inorder value lesser than the root.
        left = helper(start, rootInorderIndex - 1);
        // Right child must have an inorder value greater than root.
        right = helper(rootInorderIndex + 1, end);

        return new TreeNode(rootValue, left, right);
    }

}
