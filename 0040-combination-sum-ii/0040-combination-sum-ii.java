class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        // boolean[] board=new boolean[candidates.length];
        Arrays.sort(candidates);
        combi_Sum(candidates,target,0,ll,ans);
        return ans;
    }
    public static void combi_Sum(int[] candidate,int target,int idx,List<Integer> ll,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(ll));
            return ;
        }
        for (int i = idx; i < candidate.length; i++) {
            if(i>idx && candidate[i]==candidate[i-1]) continue;

            if(candidate[i]>target) break;

            if(target - candidate[i] >=0){
                ll.add(candidate[i]);
                combi_Sum(candidate, target-candidate[i], i+1, ll, ans);
                ll.remove(ll.size()-1);
            }
        }
    }
}