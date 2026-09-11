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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newNode=new TreeNode(val);
            newNode.left=root;
            return newNode;
        }
        addOneRow_(root,val,depth,1);
        return root;
    }
    public void addOneRow_(TreeNode root, int val, int depth,int c) {
        if(root==null) return ;
        if(depth-1==c){
            // left
            TreeNode newLeft=new TreeNode(val);
            newLeft.left=root.left;
            root.left=newLeft;
            // right
            TreeNode newRight=new TreeNode(val);
            newRight.right=root.right;
            root.right=newRight;
        }
        else{
            addOneRow_(root.left,val,depth,c+1);
            addOneRow_(root.right,val,depth,c+1);
        }
    }
    
}