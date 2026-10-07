class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        boolean[] board=new boolean[candidates.length];
        Arrays.sort(candidates);
        combination(candidates,target,ll,ans,0,board);
        return ans;
    }
    public void combination(int[] coin,int amount,List<Integer> ll,List<List<Integer>> ans,int idx,boolean[] board){
        if(amount==0){
            if(!ans.contains(ll)){
                ans.add(new ArrayList<>(ll));  
            }
            return;
        }
        for(int i=idx;i<coin.length;i++){
            if (i > idx && coin[i] == coin[i - 1] && !board[i - 1]) {
                continue;
            }
            if(amount>=coin[i] && board[i]==false){
                board[i]=true;
                ll.add(coin[i]);
                // coin[i]=0;
                combination(coin,amount-coin[i],ll,ans,i,board);
                // coin[i]=0;
                ll.remove(ll.size()-1);
                board[i]=false;
            }
        }
    }
}