class Solution {
    public int climbStairs(int n) {
        return count(new int[n+1],n);
    }
   public static int count(int[] cache, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if(cache[n]!=0) return cache[n];
        int x=0;
        for (int dice = 1; dice <= 2; dice++) {
             x+=count(cache, n - dice);
        }
        cache[n]=x;
        return x;
        
    }
}