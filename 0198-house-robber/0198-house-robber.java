class Solution {
    public int rob(int[] nums) {
        return RobberBU(nums);
    }
    public static int RobberBU(int[] arr) {
        if(arr.length==1) return  arr[0];
        if(arr.length==2) return Math.max(arr[0],arr[1]);
        int[] dp=new int[arr.length];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i]=Math.max(arr[i]+dp[i-2],dp[i-1]);
        }
        return dp[dp.length-1];
    }
}