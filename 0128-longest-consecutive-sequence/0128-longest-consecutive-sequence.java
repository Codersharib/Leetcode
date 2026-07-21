class Solution {
    public int longestConsecutive(int[] nums) {
        return LCseq(nums);
    }
    public static int LCseq(int [] arr){
        HashSet<Integer> set=new HashSet<>();
        int ans=0;
        for(int i=0;i<arr.length;i++) {
            set.add(arr[i]);
        }
        for(int i=0;i<arr.length;i++) {
            int x=arr[i];
            if(set.contains(x)&& !set.contains(x-1)){
                int c=0;
                while(set.contains(x)){
                    c++;
                    set.remove(x);
                    x++;
                }
                ans=Math.max(ans, c);
            }
        }
        return ans;
    }
}