class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ll=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        combi_Sum(candidates, target, 0, ll,ans);
        return ans;
    }
    public static void combi_Sum(int[] candidate,int target,int idx,List<Integer> ll,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(ll));
        }
        for (int i = idx; i < candidate.length; i++) {
            if(target - candidate[i] >=0){
                ll.add(candidate[i]);
                combi_Sum(candidate, target-candidate[i], i, ll, ans);
                ll.remove(ll.size()-1);
            }
        }
    }
}