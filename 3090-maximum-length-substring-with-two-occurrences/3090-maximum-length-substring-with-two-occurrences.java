class Solution {
    public int maximumLengthSubstring(String s) {
        int si = 0;
        int ans = 0;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] < 2) {
                arr[s.charAt(i) - 'a']++;
            } else if (arr[s.charAt(i) - 'a'] == 2) {
                while (arr[s.charAt(i) - 'a'] >= 2) {
                    arr[s.charAt(si) - 'a']--;
                    si++;
                }
                arr[s.charAt(i) - 'a']++;
            }
            ans = Math.max(ans, i - si+1);
        }
        return ans;
    }
}