class Solution {
    public void sortColors(int[] nums) {
        DNF(nums);
    }
    public static void DNF(int[] arr){
        int i=0;
        int k=0;
        int j=arr.length-1;
        while(i<=j){
            if(arr[i]==0){
                // swap
                int temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
                k++;
                i++;
            }
            else if(arr[i]==2){
                // swap i,j
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j--;
            }
            else {
                i++;
            }
        }
    }
}