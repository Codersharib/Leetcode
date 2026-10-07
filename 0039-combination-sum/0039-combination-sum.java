class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ll=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        comb_sum(candidates, target, 0, ll,ans);
        return ans;
    }
    public static void comb_sum(int[] coin,int target,int idx,List<Integer> ll,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(ll));
            return ;
        }
        for (int i = idx; i < coin.length; i++) {
            if(target>=coin[i]){
                ll.add(coin[i]);
                comb_sum(coin, target-coin[i], i, ll, ans);
                ll.remove(ll.size()-1);
            }
        }
    }
}