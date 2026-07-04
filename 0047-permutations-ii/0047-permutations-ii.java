class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permutation(nums, used, curr, res);
        return res;
    }

    public static void permutation(int [] arr,boolean used[],List<Integer> curr,List<List<Integer>> res){
        if(curr.size()==arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<arr.length;i++) {
            if(used[i]) continue;
            if(isPresent(arr,used,i+1,arr[i])==false){
                used[i]=true;
                curr.add(arr[i]);
                permutation(arr,used, curr, res);
                curr.remove(curr.size()-1);
                used[i]=false;

            }
        }
    }
    public static boolean isPresent(int[] arr,boolean[] used,int idx,int val){
        for(int i=idx;i<arr.length;i++) {
            if(arr[i]==val && used[i]==true) return true;
        }
        return false;
    }
}