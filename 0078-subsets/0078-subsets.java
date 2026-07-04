class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        print(nums,0,curr,res);
        return res;
    }
    public static void print(int[] arr,int i,List<Integer> curr,List<List<Integer>> res){
        if(i==arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        print(arr, i+1, curr, res);
        curr.add(arr[i]);
        print(arr, i+1, curr, res);
        curr.remove(curr.size()-1);
    }
}