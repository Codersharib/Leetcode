class Solution {
    public int removeElement(int[] nums, int val) {
        return remove(nums,val);
    }
    public static int remove(int arr[],int key){
        int k=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!=key){
                arr[k]=arr[i];
                k++;
            }
        }
        return k;
    }
}