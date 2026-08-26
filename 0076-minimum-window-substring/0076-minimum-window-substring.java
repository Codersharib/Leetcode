class Solution {
    public String minWindow(String s, String t) {
        return minSub(s, t);
    }

    public static String minSub(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int required = need.size();
        int formed = 0;
        int si = 0;
        int ans = Integer.MAX_VALUE;
        String a = "";
        for (int i = 0; i < s.length(); i++) {
            // grow
            char ch = s.charAt(i);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (need.containsKey(ch) && window.get(ch).intValue() == need.get(ch).intValue()) {
                formed++;
            }

            // shrink and update
            while (formed == required) {
                if (i - si + 1 < ans) {
                    ans = i - si + 1;
                    a = s.substring(si, i + 1);
                }
                char ch2 = s.charAt(si);
                window.put(ch2, window.get(ch2) - 1);
                if (need.containsKey(ch2) && window.get(ch2) < need.get(ch2)) {
                    formed--;
                }
                si++;
            }
        }
        return a;
    }
}