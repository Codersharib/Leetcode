class Solution {
    public int[] twoSum(int[] nums, int target) {
         int[] res =Twosum(nums,target);
         return res;
    }

    public static int[] Twosum(int[] arr,int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[2];
        for (int i = 0; i < arr.length; i++) {
            int req=target-arr[i];
            if(map.containsKey(req)){
                ans[0]=map.get(req);
                ans[1]=i;
                return ans;
            }
            else{
                map.put(arr[i],i);
            }
        }
        return null;
    }
}