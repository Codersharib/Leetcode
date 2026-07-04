class Solution {
    static String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> ll=new ArrayList<>();
        print(digits,"",ll);
        return ll;
    }
    public static void print(String que,String ans,List<String> ll){
        if(que.length()==0){
            ll.add(ans);
            return;
        }
        char ch=que.charAt(0);
        String press=key[ch-'0'];
        for(int i=0;i<press.length();i++) {
            print(que.substring(1), ans+press.charAt(i), ll);
        }
    }
}
