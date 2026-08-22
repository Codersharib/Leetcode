class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return median_2_sorted_Arr(nums1,nums2);
    }
    public static double median_2_sorted_Arr(int[] arr1,int[] arr2){
        int n1=arr1.length;
        int n2=arr2.length;
        int[] finall=merge(arr1, arr2);
        int idx=finall.length/2;
        if(finall.length%2==0){
            return (double)(finall[idx]+finall[idx-1])/2;
        }
        else{
            return (double)finall[idx];
        }
    }
    public static int[] merge(int[] arr1,int [] arr2){
        int n1=arr1.length;
        int n2=arr2.length;
        int[] finall=new int[n1+n2];
        int i=0,j=0,k=0;
        while(i<n1 && j<n2){
            if(arr1[i]<arr2[j]){
                finall[k++]=arr1[i++];
            }
            else{
                finall[k++]=arr2[j++];
                
            }
        }
        while(i<n1){
            finall[k++]=arr1[i++];
        }
        while(j<n2){
            finall[k++]=arr2[j++];
        }
        return finall;
    }
}