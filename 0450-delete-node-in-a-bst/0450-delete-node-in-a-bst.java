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
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        else{
            // actual deletion takes place
            //  0 or 1 child
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            // now for 2 child 
            else{
                // max value from left of root so that i can put max val in place of that root val we can also put min value form right of root
                int max=max(root.left);
                root.left=deleteNode(root.left,max);
                root.val=max;
            }
        }
        return root;
    }
    private int max(TreeNode node){
        if(node==null) return Integer.MIN_VALUE;
        int rightmax=max(node.right);
        return Math.max(node.val,rightmax);
    }
}