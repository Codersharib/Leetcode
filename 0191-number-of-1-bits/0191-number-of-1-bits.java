class Solution {
    public int hammingWeight(int n) {
        int c=0;
        // method 1
        // while(n>0){
        //     if((n&1) !=0){
        //         c++;
        //     }
        //     n/=2;
        // }
        // return c;

        // method 2
        while(n!=0){
            n=n&(n-1);
            c++;
        }
        return c;
    }
}