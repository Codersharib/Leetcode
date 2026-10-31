class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        boolean[] board=new boolean[9];
        combSum3(n,k,0,ll,ans,1);
        return ans;
    }

    public static void combSum3(int target ,int k,int qpsf,List<Integer> ll,List<List<Integer>> ans,int idx){
        if(qpsf==k && target ==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        if(target<0 || qpsf>k) return;
        for (int i = idx; i <=9; i++) {
            if(target -i >=0){
                ll.add(i);
                combSum3(target-i, k, qpsf+1, ll, ans,i+1);
                ll.remove(ll.size()-1);
            }
        }
    }
}