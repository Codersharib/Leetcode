class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            ans = Math.min(ans, min_fallingPath(matrix, 0, i, dp));
        }
        return ans;
    }
    public static int min_fallingPath(int[][] matrix, int cr, int cc, Integer[][] dp) {
        if (cc < 0 || cc >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (cr == matrix.length - 1) {
            return matrix[cr][cc];
        }
        if (dp[cr][cc] != null) {
            return dp[cr][cc];
        }
        int ld = min_fallingPath(matrix, cr + 1, cc - 1, dp);
        int rd = min_fallingPath(matrix, cr + 1, cc + 1, dp);
        int down = min_fallingPath(matrix, cr + 1, cc, dp);
        return dp[cr][cc] = Math.min(down, Math.min(rd, ld)) + matrix[cr][cc];
    }
}