class Solution {
    public int shipWithinDays(int[] weights, int days) {
        return min_capacity(weights,days);
    }
    public static int min_capacity(int[] arr,int days){
        int greatest=Integer.MIN_VALUE;
        int sum=0;
        for(int num:arr) {
            sum+=num;
            if(greatest<num) greatest=num;
        }
        // BS
        int l=greatest;
        int h=sum;
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(Days(arr,mid)<=days){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public static int Days(int[] arr,int capacity){
        int load=0;
        int days=1;
        for(int num:arr){
            if(load+num>capacity){
                days++;
                load=num;
            }
            else{
                load+=num;
            }
        }
        return days;
    }
}