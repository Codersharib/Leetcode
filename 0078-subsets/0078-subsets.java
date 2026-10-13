class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        Subset(nums, ans, ll, 0);
        return ans;
    }
    public static void Subset(int[] arr,List<List<Integer>> ans,List<Integer> ll,int i){
        if(i==arr.length){
            ans.add(new ArrayList<>(ll));
            return ;
        }
        Subset(arr, ans, ll, i+1);
        ll.add(arr[i]);
        Subset(arr, ans, ll, i+1);
        ll.remove(ll.size()-1);
    }
}