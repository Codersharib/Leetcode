class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return sliding(nums,k);
    }
    public static int sliding(int[] arr,int k){
        int si=0,ei=0;
        int p=1;
        int c=0;
        while(ei<arr.length){
            // grow
            p*=arr[ei];
            // shrink
            while(p>=k && si<=ei){
                p/=arr[si++];
            }
            // update
            if(p<k) c+=ei-si+1;
            ei++;
        }
        return c;
    }
}