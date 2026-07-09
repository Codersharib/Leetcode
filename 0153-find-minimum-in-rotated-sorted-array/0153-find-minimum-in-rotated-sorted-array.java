class Solution {
    public int findMin(int[] nums) {
        return findmin(nums);
    }
    public static int findmin(int[] arr){
        int min=Integer.MAX_VALUE;
        int l=0;
        int h=arr.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]>=arr[l]){
                min=Math.min(min,arr[l]);
                l=mid+1;
            }
            else{
                min=Math.min(min,arr[mid]);
                h=mid-1;
            }
        }
        return min;
    }
}