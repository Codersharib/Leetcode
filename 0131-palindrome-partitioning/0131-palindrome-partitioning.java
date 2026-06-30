class Solution {
    public List<List<String>> partition(String s) {
        List<String> ll=new ArrayList<>();
        List<List<String>> ans=new ArrayList<>();

        partition(s, ll,ans);
        return ans;
    }
    public static void partition(String ques,List<String> ll,List<List<String>> ans){
        if(ques.length()==0) {
            // System.out.println(ll);
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=1;i<=ques.length();i++) {
            String s=ques.substring(0,i);
            if(ispalindrome(s)){
                ll.add(s);
                partition(ques.substring(i), ll,ans);
                ll.remove(ll.size()-1);
            }
        }
    }
    public static boolean ispalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}