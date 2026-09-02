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
    long prev=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // using inorder
        if(root==null) return true;
        // left
        if(!isValidBST(root.left)) return false;
        // current
        if(root.val<=prev) return false;
        prev=root.val;
        // right
        return isValidBST(root.right);
    }
}