class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ll=new ArrayList<>();
        parenthessis(n,0,0,"",ll);
        return ll;
    }
    public static void parenthessis(int n,int open,int closed,String ans,List<String> ll){
        if(open==n && closed==n){
            ll.add(ans);
            return;
        }
        if(open>n || closed>open){
            return ;
        }
        parenthessis(n, open+1, closed, ans+"(",ll);
        parenthessis(n, open, closed+1, ans+")",ll);
    }
}