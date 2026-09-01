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
    int max_depth=-1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ll=new ArrayList<>();
        rightSideView_(root,0,ll);
        return ll;
    }
    public void rightSideView_(TreeNode root,int currlevel,List<Integer> ll) {
        if(root==null) return ;
        if(max_depth<currlevel){
            ll.add(root.val);
            max_depth=currlevel;
        }
        rightSideView_(root.right,currlevel+1,ll);
        rightSideView_(root.left,currlevel+1,ll);
    }
}