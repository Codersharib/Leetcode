class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return min_cost(cost);
    }
    public static int min_cost(int arr[]){
        int[] dp=new int[arr.length];
        dp[0]=arr[0];
        dp[1]=arr[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i]=arr[i]+Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }
}