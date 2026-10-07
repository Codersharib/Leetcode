class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        boolean[] board=new boolean[9];
        n_queen_combination(board,k,0,0,ll,ans,n);
        return ans;
    }

    public  void n_queen_combination(boolean[] board,int tq,int qpsf,int idx,List<Integer> ll,List<List<Integer>> al,int amount){
        if(qpsf==tq){
            if(amount==0){
            al.add(new ArrayList<>(ll));
            return ;
            }
        }
        
        for (int i = idx; i < board.length; i++) {
            if(amount>=i+1 && board[i]==false){
                board[i]=true;
                ll.add(i+1);
                n_queen_combination(board, tq,qpsf+1,i+1,ll,al,amount-(i+1));
                ll.remove(ll.size()-1);
                board[i]=false;
            }
        }
    }
}