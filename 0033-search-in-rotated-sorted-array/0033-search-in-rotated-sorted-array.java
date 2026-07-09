class Solution {
    public int search(int[] nums, int target) {
        return search1(nums,target);
    }
    public static int search1(int arr[],int target){
        int l=0;
        int h=arr.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]==target) return mid;
            if(arr[mid]>=arr[l]){
                if(arr[mid]>=target && arr[l]<=target){
                    h=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            else{
                if(arr[h]>=target && arr[mid]<=target){
                    l=mid+1;
                }
                else{
                    h=mid-1;
                }
            }
        }
        return -1;
    }
}