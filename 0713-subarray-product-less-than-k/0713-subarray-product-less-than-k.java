class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return product_less_k(nums,k);
    }
    public static int product_less_k(int[] arr,int k){
        int ans=0;
        int p=1,si=0,ei=0;
        // grow
        while(ei<arr.length){
            p*=arr[ei];
            // shrink
            while(p>=k){
                p/=arr[si];
                si++;
            }
            // ans update
            ans+=ei-si+1;
            ei++;
        }
        return ans;
    }
}