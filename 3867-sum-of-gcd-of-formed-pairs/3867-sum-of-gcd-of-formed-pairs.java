class Solution {
    public long gcdSum(int[] nums) {
        return gcd_sum(nums);
    }
    public static int gcd(int divd,int div){
        return divd%div==0? div:gcd(div,divd%div);
    }
    public static long gcd_sum(int[] arr){
        // if(arr.length<2) return arr[0];
        int max=0;
        int[] prefix_gcd=new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            if(max<arr[i]){
                max=arr[i];
            }
            prefix_gcd[i]=gcd(arr[i], max);
        }
        Arrays.sort(prefix_gcd);
        long sum_pairs=0;
        int j=arr.length-1;
        int i=0;
        while(i<j){
            sum_pairs+=gcd(prefix_gcd[i], prefix_gcd[j]);
            i++;
            j--;
        }
        return sum_pairs;
    }
}