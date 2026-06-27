class Solution {
    static String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> ll=new ArrayList<>();
        letter_comb_ph_no(digits,"",ll);
        return ll;
    }
    public static void letter_comb_ph_no(String ques,String ans,List<String> ll){
        if(ques.length()==0){
            // System.out.println(ans);
            ll.add(ans);
            return;
        }
        char ch=ques.charAt(0);
        String press=key[ch-'0'];
        for(int i=0;i<press.length();i++) {
            letter_comb_ph_no(ques.substring(1), ans+press.charAt(i),ll);
        }        
    }
}
