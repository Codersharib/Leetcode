class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int si = 0, max = 0;
        for (int ei = 0; ei < nums.length; ei++) {
            map.put(nums[ei], map.getOrDefault(nums[ei], 0) + 1);
            while (map.get(nums[ei]) > k) {
                map.put(nums[si], map.get(nums[si]) - 1);
                si++;
            }
            max = Math.max(max, ei - si + 1);
        }
        return max;
    }
}