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
    public boolean isBalanced(TreeNode root) {
        return isBalanced_(root).balanced;
    }
    public balPair isBalanced_(TreeNode root) {
        if(root==null) return new balPair(0,true);
        balPair left=isBalanced_(root.left);
        balPair right=isBalanced_(root.right);
        // check height
        int h=Math.max(left.height,right.height)+1;
        // balacning
        boolean b=left.balanced && right.balanced && Math.abs(left.height-right.height)<=1;
        return new balPair(h,b); 
    }
    class balPair{
        int height;
        boolean balanced;
        balPair(int height, boolean balanced){
            this.height=height;
            this.balanced=balanced;
        }
    }
}