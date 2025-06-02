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
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        // Traverse right subtree first
        flatten(root.right);
        // Then traverse left subtree
        flatten(root.left);

        // Rewire the pointers
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
