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
    public int maxSumBST(TreeNode root) {
        return validBST(root).ans;
    }
    public bstpair validBST(TreeNode root){
        if(root==null) return new bstpair();
        bstpair lbp=validBST(root.left);
        bstpair rbp=validBST(root.right);
        bstpair sbp=new bstpair();
        sbp.min=Math.min(root.val,Math.min(lbp.min,rbp.min));
        sbp.max=Math.max(root.val,Math.max(lbp.max,rbp.max));
        sbp.sum=lbp.sum+rbp.sum+root.val;
        if(lbp.isbst && rbp.isbst && lbp.max<root.val && rbp.min>root.val){
            sbp.isbst=true;
            sbp.ans=Math.max(sbp.sum,Math.max(lbp.ans,rbp.ans));
        }
        else {
            sbp.isbst=false;
            sbp.ans=Math.max(lbp.ans,rbp.ans);
        }
        return sbp;
    }
    class bstpair{
        boolean isbst=true;
        long max=Long.MIN_VALUE;
        long min=Long.MAX_VALUE;
        int sum=0;
        int ans=0;
    }
}