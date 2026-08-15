class Solution {
    public int longestSubsequence(int[] nums) {
        int total=0;
        boolean non_zero=false;
        for(int num:nums){
            non_zero |=num>0;
            total^=num;
        }
        if(total !=0) return nums.length;
        if(non_zero) return nums.length-1;
        return 0;
    }
}