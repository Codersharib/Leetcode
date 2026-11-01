class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        subset1(nums, 0,ans, ll);
        return ans;
    }
    public static void subset1(int[] nums,int idx,List<List<Integer>> ans,List<Integer> ll){
            ans.add(new ArrayList<>(ll));
            
            for (int j = idx; j < nums.length; j++) {
                ll.add(nums[j]);
                subset1(nums, j+1, ans, ll);
                ll.remove(ll.size()-1);
            }
        }
}