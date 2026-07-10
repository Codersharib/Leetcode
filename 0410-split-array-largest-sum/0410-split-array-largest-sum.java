class Solution {
    public int splitArray(int[] nums, int k) {
        return splitarray(nums,k);
    }
    public static int splitarray(int[] arr,int k){
        int great=Integer.MIN_VALUE;
        int sum=0;
        for(int num:arr) {
            sum+=num;
            if(great<num) great=num;
        }
        // BS
        int l=great;
        int h=sum;
        int ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isPossible(arr,k,mid)){
                ans=mid;
                h=mid-1;
                
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] arr,int k,int max_sum){
        int sum=0;
        int count=1;
        for(int num:arr){
            if(sum+num>max_sum){
                count++;
                sum=num;
            }
            else{
                sum+=num;
            }
        }
        if(count<=k) return true;
        else return false;
    }
}