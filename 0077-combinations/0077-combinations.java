class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        boolean[] board=new boolean[n];
        combination_(board,k,0,0,ll,ans);
        return ans;
    }

    public static void combination_(boolean board[], int tq,int qpsf,int idx,List<Integer> ll,List<List<Integer>> ans){
        if(qpsf==tq){
            ans.add(new ArrayList<>(ll));
        }
        for (int i = idx; i < board.length; i++) {
            if(board[i]==false){
                board[i]=true;
                ll.add(i+1);
                combination_(board, tq, qpsf+1, i+1, ll, ans);
                ll.remove(ll.size()-1);
                board[i]=false;
            }
        }   
    }
}