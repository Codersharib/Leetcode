class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return MiniOpres(word1,word2,0,0,dp);
    }
    public static int MiniOpres(String word1 ,String word2,int i,int j,int[][] dp){
        if(i==word1.length()){
            return word2.length()-j;
        }
        if(j==word2.length()){
            return word1.length()-i;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        if(word1.charAt(i)==word2.charAt(j)){
            ans=MiniOpres(word1, word2, i+1, j+1,dp);
        }
        else{
            int I=MiniOpres(word1, word2, i, j+1,dp);
            int R=MiniOpres(word1, word2, i+1, j+1,dp);
            int D=MiniOpres(word1, word2, i+1, j,dp);
            ans=1+Math.min(R, Math.min(I, D));
        }
        return dp[i][j]=ans;
    }
}