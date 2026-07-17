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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key>root.val){
            root.right=deleteNode(root.right,key);
        }
        else if(key<root.val){
            root.left=deleteNode(root.left,key);
        }
        else{
            // 1 child or no child
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            // 2 child
            else{
                int leftmax=max(root.left);
                root.left=deleteNode(root.left,leftmax);
                root.val=leftmax;
            }
        }
        return root;
    }
    private int max(TreeNode node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int right_max=max(node.right);
        return Math.max(node.val,right_max);
    }
}