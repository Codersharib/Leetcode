class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;  // smallest number NOT yet coverable — [1, miss-1] is covered
        int patches = 0;
        int i = 0;
        
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                // existing number helps extend coverage
                miss += nums[i];
                i++;
            } else {
                // gap found — must add 'miss' itself as a patch
                miss += miss;   // add miss, new coverage becomes [1, 2*miss - 1]
                patches++;
            }
        }
        
        return patches;
    }
}