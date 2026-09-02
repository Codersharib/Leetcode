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
        return (int)maxSumBST_(root).ans;
    }
    public BstPair maxSumBST_(TreeNode root) {
        if(root==null) return new BstPair();
        BstPair lbp=maxSumBST_(root.left);
        BstPair rbp=maxSumBST_(root.right);
        BstPair sbp=new BstPair();
        sbp.min=Math.min(root.val,Math.min(lbp.min,rbp.min));
        sbp.max=Math.max(root.val,Math.max(lbp.max,rbp.max));
        sbp.sum=root.val+lbp.sum+rbp.sum;
        sbp.isBST=lbp.isBST && rbp.isBST && lbp.max<root.val && rbp.min>root.val;
        if(sbp.isBST){
            sbp.ans=Math.max(sbp.sum,Math.max(lbp.ans,rbp.ans));
        }
        else{
            sbp.ans=Math.max(lbp.ans,rbp.ans);
        }
        return sbp;
    }
    class BstPair{
        boolean isBST=true;
        long max=Long.MIN_VALUE;
        long min=Long.MAX_VALUE;
        long sum=0;
        long ans=0;
    }
}