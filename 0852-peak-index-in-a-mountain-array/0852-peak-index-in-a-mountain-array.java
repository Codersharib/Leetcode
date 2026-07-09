class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return peak(arr);
    }
    public static int peak(int[] arr) {
        int l = 1;
        int h = arr.length - 2;
        // if(arr.length<=1) return 0;
        // if (arr[0] > arr[1]) {
        //     return 0;
        // }
        // if (arr[h + 1] > arr[h]) {
        //     return h+1;
        // }
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] >arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid + 1]) {
                h = mid - 1;
            }
            else if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            }
        }
        return -1;
    }
}