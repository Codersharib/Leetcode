class Solution {
    public boolean isGoodArray(int[] nums) {
        int ans=nums[0];
        for(int a:nums){
            ans=gcd(ans,a);
            if(ans==1) return true;
        }
        return ans==1;
    }
    public int gcd(int a ,int b){
        return b==0?a:gcd(b,a%b);
    }
}