class Solution {
    public int maximumScore(int[] nums, int k) {
        return max_good(nums,k);
    }
    public static int max_good(int[] arr,int k){
        int i=k;
        int j=k;
        int min=arr[k];
        int ans=arr[k];
        while(i>0 || j<arr.length-1){
            if(i==0) j++;
            else if(j==arr.length-1) i--;
            else if(arr[i-1]>arr[j+1]) i--;
            else j++;
            min=Math.min(min, Math.min(arr[i],arr[j]));
            ans=Math.max(ans,min*(j-i+1));
        }
        return ans;
    }
}