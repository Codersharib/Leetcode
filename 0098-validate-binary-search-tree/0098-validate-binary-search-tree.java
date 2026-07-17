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
        return validBST(root).isbst;
    }
    public bstpair validBST(TreeNode root){
        if(root==null) return new bstpair();
        bstpair lbp=validBST(root.left);
        bstpair rbp=validBST(root.right);
        bstpair sbp=new bstpair();
        sbp.min=Math.min(root.val,Math.min(lbp.min,rbp.min));
        sbp.max=Math.max(root.val,Math.max(lbp.max,rbp.max));
        if(lbp.isbst && rbp.isbst && lbp.max<root.val && rbp.min>root.val){
            sbp.isbst=true;
        }
        else {
            sbp.isbst=false;
        }
        return sbp;
    }
    class bstpair{
        boolean isbst=true;
        long max=Long.MIN_VALUE;
        long min=Long.MAX_VALUE;
    }
}