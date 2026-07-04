class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> curr=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        subset2(nums,0,curr,res);
        return res;
    }
    public static void subset2(int arr[],int n,List<Integer>curr,List<List<Integer>> res){
        if(n==arr.length){
            List<Integer> curr_copy=new ArrayList<>(curr);
            Collections.sort(curr_copy);
            if(!res.contains(curr_copy)){
                res.add(new ArrayList<>(curr_copy));
            }
            return;
        }
        subset2(arr, n+1, curr, res);
        curr.add(arr[n]);
        subset2(arr, n+1, curr, res);
        curr.remove(curr.size()-1);
    }
}