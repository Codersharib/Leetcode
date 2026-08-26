class Solution {
    public int beautySum(String s) {
        return beauty_sum(s);
    }
    public static int beauty_sum(String s){
        int ans=0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq=new int[26];
            for (int j = i; j < s.length(); j++) {
                char ch=s.charAt(j);
                freq[ch-'a']++;
                int max=0;
                int min=Integer.MAX_VALUE;
                for (int k : freq) {
                    if(k>0){
                        max=Math.max(max,k);
                        min=Math.min(min,k);
                    }
                }
                ans+=max-min;
            }
        }
        return ans;
    }
}