class Solution {
    public int lengthOfLongestSubstring(String s) {
        return longest(s);
    }
    public static int longest(String s) {
        int si = 0, ei = 0;
        int max=0;
        HashSet<Character> set=new HashSet<>();
        while (ei < s.length()) {
            char c = s.charAt(ei);
            while (set.contains(c)) {
                set.remove(s.charAt(si));
                si++;
            }
            set.add(c);
            max=Math.max(max, ei-si+1);
            ei++;
        }
        return max;
    }
}