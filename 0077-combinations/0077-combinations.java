class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        boolean[] board=new boolean[n];
        n_queen_combination(board,k,0,0,ll,ans);
        return ans;
    }

    public  void n_queen_combination(boolean[] board,int tq,int qpsf,int idx,List<Integer> ll,List<List<Integer>> al){
        if(qpsf==tq){
            al.add(new ArrayList<>(ll));
            return;
        }
        for (int i = idx; i < board.length; i++) {
            if(board[i]==false){
                board[i]=true;
                ll.add(i+1);
                n_queen_combination(board, tq,qpsf+1,i+1,ll,al);
                ll.remove(ll.size()-1);
                board[i]=false;
            }
        }
    }
}