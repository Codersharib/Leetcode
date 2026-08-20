class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        return divisible_array(nums,k);
    }
    public static int divisible_array(int[] arr, int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefixSum=0;
        int c=0;
        map.put(0,1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum+=arr[i];
            // get rem
            int r=prefixSum%k;
            if(r<0) r+=k;
            if(map.containsKey(r)){
                c+=map.get(r);
            }
            map.put(r,map.getOrDefault(r, 0)+1);
        }
        return c;
    }
}