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
    static int c = 0;

    public int pathSum(TreeNode root, int targetSum) {
        c=0;
        pathSum1(root,targetSum);
        return c;
    }
    public void pathSum1(TreeNode root, long targetSum) {
        if (root == null)
            return ;
        pathSum_(root, targetSum);
        pathSum1(root.left, targetSum);
        pathSum1(root.right, targetSum);
    }

    public void pathSum_(TreeNode root, long targetSum) {
        if (root == null)
            return;
        // as we dont need to go till leaf now
        targetSum -= root.val;
        if (targetSum == 0) {
            c++;
        }
        pathSum_(root.left, targetSum);
        pathSum_(root.right, targetSum);
    }
}