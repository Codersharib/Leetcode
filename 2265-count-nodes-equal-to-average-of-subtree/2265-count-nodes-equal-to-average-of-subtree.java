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
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        if(root==null){
            return 0;
        }
        pair sp=req(root);
        int avg=sp.sum/sp.c;
        if(avg ==root.val) count++;
        int left=averageOfSubtree(root.left);
        int right=averageOfSubtree(root.right);
        // System.out.println(sp.sum+" "+sp.c+" "+avg+" "+count);

        return count;
    }
    public pair req(TreeNode root){
        if(root==null) {
            // System.out.println(sum+" "+c);
            return new pair();
        }
        pair lp=req(root.left);
        pair rp=req(root.right);
        pair sp=new pair();
        sp.c=lp.c+rp.c+1;
        sp.sum=lp.sum+rp.sum+root.val;
        return sp;
    }
    class pair{
        int c=0;
        int sum=0;
    }
}