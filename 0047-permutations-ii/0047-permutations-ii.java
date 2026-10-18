class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used=new boolean[nums.length];
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        Permutation(nums, used, ans, ll);
        return ans;
    }

    public static void Permutation(int[] arr,boolean used[],List<List<Integer>> ans,List<Integer> ll){
        if(ll.size()==arr.length){
            if(!ans.contains(ll))
                ans.add(new ArrayList<>(ll));
            return ;
        }
        for (int i = 0; i < arr.length; i++) {
            if(!used[i]){
                used[i]=true;
                ll.add(arr[i]);
                Permutation(arr, used, ans, ll);
                ll.remove(ll.size()-1);
                used[i]=false;
            }
        }
    }
}