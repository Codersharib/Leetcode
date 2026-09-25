class Solution {
    public int[] productExceptSelf(int[] nums) {
        return pro_arr_exe_self(nums);
    }
    public static int[] pro_arr_exe_self( int[] arr){
        int n=arr.length;
        // prefix_product
        int[] left=new int[n];
        left[0]=1;
        for(int i=1;i<n;i++){
            left[i]=left[i-1]*arr[i-1];
        }
        
        // suffix_product
        int[] right=new int[n];
        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*arr[i+1];
        }
        // calculation
        for(int i=0;i<n;i++){
            left[i]=left[i]*right[i];
        }
        return left;
    }
}