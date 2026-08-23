class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        return kth_smallest(nums1,nums2,k);
    }
    public static long kth_smallest(int[] arr1,int[] arr2,long k){
        int n=arr1.length;
        int m=arr2.length;
        long c1=(long)arr1[0]*arr2[0];
        long c2=(long)arr1[0]*arr2[m-1];
        long c3=(long)arr1[n-1]*arr2[0];
        long c4=(long)arr1[n-1]*arr2[m-1];
        // get min and max for BS
        long l=Math.min(Math.min(c1,c2),Math.min(c3,c4));
        long h=Math.max(Math.max(c1,c2),Math.max(c3,c4));

        while(l<h){
            long mid=l+(h-l)/2;
            if(isCountLessOrEqual(arr1,arr2,mid)>=k){
                h=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public static long isCountLessOrEqual(int[] arr1,int[] arr2,long x){
        long count=0;
        int m=arr2.length;
        for (int num : arr1) {
            if(num==0){
                if( x>=0) count+=m;
            }
            else if(num>0){
                // BS on arr2
                int l=0,h=m-1,idx=-1;
                while(l<=h){
                    int mid=l+(h-l)/2;
                    if((long)num*arr2[mid]<=x){
                        idx=mid;
                        l=mid+1;
                    }else{
                        h=mid-1;
                    }
                }
                count+=(idx+1);
            }
            else{
                // BS on arr2 reverse
                int l=0,h=m-1,idx=m;    
                while(l<=h){
                    int mid=l+(h-l)/2;
                    if((long)num*arr2[mid]<=x){
                        idx=mid;
                        h=mid-1;
                    }else{
                        l=mid+1;
                    }
                }
                count+=(m-idx);
            }
        }
        return count;
    }
}