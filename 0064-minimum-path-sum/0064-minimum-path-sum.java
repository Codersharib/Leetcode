class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return min_path(grid, 0, 0, dp);
    }
    public static int min_path(int[][] grid, int i, int j,int[][] dp) {
        if (i == grid.length - 1 && j == grid[0].length-1) {
            return grid[i][j];
        }
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] !=-1) return dp[i][j];
        int right = min_path(grid, i, j + 1,dp);
        int down = min_path(grid, i + 1, j,dp);
        return dp[i][j]=Math.min(down, right) + grid[i][j];
    }
}