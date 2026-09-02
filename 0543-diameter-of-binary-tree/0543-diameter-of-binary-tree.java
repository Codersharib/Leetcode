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
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTree_(root).dia;
    }
    public diaPair diameterOfBinaryTree_(TreeNode root) {
        if(root==null) return new diaPair();
        diaPair ldp=diameterOfBinaryTree_(root.left);
        diaPair rdp=diameterOfBinaryTree_(root.right);
        diaPair sdp=new diaPair();
        int sd=ldp.ht+rdp.ht+2;
        sdp.ht=Math.max(ldp.ht,rdp.ht)+1;
        sdp.dia=Math.max(sd,Math.max(ldp.dia,rdp.dia));
        return sdp;
    }
    
    class diaPair{
        int ht=-1;
        int dia=0;
    }
}