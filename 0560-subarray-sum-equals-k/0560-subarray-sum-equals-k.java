class Solution {
    public int subarraySum(int[] nums, int k) {
        return subarray(nums,k);
    }
    public static int subarray(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int c=0;
        int sum=0;
        map.put(0,1);
        for (int i : arr) {
            sum+=i;
            int need=sum-k;
            if(map.containsKey(need)){
                c+=map.get(need);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return c;
    }
}