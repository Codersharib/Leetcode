class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permutation(nums, used, curr, res);
        return res;
    }

    public static void permutation(int[] arr, boolean used[], List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == arr.length) {
            if (!res.contains(curr)) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            curr.add(arr[i]);
            permutation(arr, used, curr, res);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}