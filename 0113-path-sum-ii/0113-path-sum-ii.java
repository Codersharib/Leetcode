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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        pathSum_(root, targetSum, ans, ll);
        return ans;
    }

    public void pathSum_(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> ll) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                ll.add(root.val);
                ans.add(new ArrayList<>(ll));
                ll.remove(ll.size() - 1);
            }
        }
        ll.add(root.val);
        pathSum_(root.left, targetSum - root.val, ans, ll);
        pathSum_(root.right, targetSum - root.val, ans, ll);
        ll.remove(ll.size() - 1);
    }
}
