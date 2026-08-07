class Solution {
    public int[] singleNumber(int[] nums) {
        return single_No_III(nums);
    }
    public static int[] single_No_III(int[] arr){
        int xor=0;
        for (int i : arr) {
            xor=xor^i;
        }
        int mask=(xor& (-1*xor));
        int a=0;
        for (int i = 0; i < arr.length; i++) {
            if((arr[i]& mask)==0){
                a^=arr[i];
            }
        }
        int b=xor^a;
        int []ar={a,b};
        return ar;
    }
}