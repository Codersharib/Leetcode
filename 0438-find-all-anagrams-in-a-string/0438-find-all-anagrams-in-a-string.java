class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        return findAnagram(s,p);
    }
    private List<Integer> findAnagram(String s, String p) {
        int k=p.length();
        List<Integer> ll=new ArrayList<>();
        for (int i = 0; i <= s.length()-k; i++) {
            if(isAnagram(s.substring(i,i+k), p)){
                ll.add(i);
            }
        }
        return ll;
    }
    private boolean isAnagram(String str,String p){
        int[] alphabet=new int[26];
        for (int i = 0; i < p.length(); i++) {
            // char ch=p.charAt(i);
            alphabet[str.charAt(i)-'a']++;
            alphabet[p.charAt(i)-'a']--;
        }
        for (int i : alphabet) {
            if(i!=0) return false;
        }
        return true;
    }
}