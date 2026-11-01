class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        Arrays.sort(nums);
        Subset(nums,0, ans, ll);
        return ans;
    }
    public static void Subset(int[] nums,int i,List<List<Integer>> ans,List<Integer> ll){
        if(!ans.contains(ll)){
            ans.add(new ArrayList<>(ll));
        }
        for (int j = i; j < nums.length; j++) {
            ll.add(nums[j]);
            Subset(nums, j+1, ans, ll);
            ll.remove(ll.size()-1);
        }
    }
}