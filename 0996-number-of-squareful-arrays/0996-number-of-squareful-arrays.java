class Solution {
    public int numSquarefulPerms(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<Integer> ll = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        permutation(nums, ll, used, ans);
        return ans.size();
    }

    public static void permutation(int[] nums, List<Integer> ll, boolean[] used, List<List<Integer>> ans) {
        if (ll.size() == nums.length) {
            if (!ans.contains(ll)) {
                ans.add(new ArrayList<>(ll));
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            if (ll.isEmpty() || isValid(ll.get(ll.size() - 1) + nums[i])){
                used[i] = true;
                ll.add(nums[i]);
                permutation(nums, ll, used, ans);
                ll.remove(ll.size() - 1);
                used[i] = false;
            }
        }
    }

    private static boolean isValid(int sum) {
        if (sum < 0)
            return false;
        long sqrt = (long) Math.sqrt(sum);
        if (sqrt * sqrt != sum)
            return false;
        return true;
    }
}